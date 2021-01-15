
# Projet balises satelites M2 TIIL
Le but du projet est d'améliorer le code de l'enseignant en apportant des modifications dans la qualité de code et dans la conception. Ce document énumère tous les choix et amélioriations aportées au projet. Voici le lien actuel du projet: https://github.com/Prakkkmak/cours-satelites-projet/

### Conventions de nommage

Le code est écris en franglais. Pour la compréhension du code dans son ensemble et pour la maintenanbilité au long terme, suivre une écriture constante dans le nommage des variables et autres éléments est primordial. Chaque classe a été inspectée afin d'y apporter un changement dans la langue vers l'anglais.

### Scopes

Certaines portées de variables étaient maladroites. Beaucoup de propriétés de classes pouvaient être internes à la classe (`private`). Un grand ménage a été fait a ce niveau la. Avoir les bonnes portées pour chaque classe et bien définir quel service elle rend permet d'avoir une architecture beaucoup plus résistante aux évolutions non prévues et par conséquent aux bugs.

### Packages

Pour faciliter le développement, le projet a été déccoupé en packets regroupés par rôle métier. De cette manière chaque package peux être testé individuellement et amélioré sans porter atteinte aux autres packets. Le projet a été déccoupé de la manière suivante:
* simulation: Comprends la simulation avec l'instantiation de tous les éléments nécessaires à la simulation. 
    * simulation.vue: La vue comprends les éléments graphiques créés pour représenter le projet.
* model: Modèle complet de l'application. C'est ici que les principaux changements dans la conception ont lieu.
    * model.element: Contient les objets principaux de l'application.  Le package comprends des éléments mobiles.
    * model.event: La partie dédiée aux evenements.
    * model.movement: Le package de movement comprends toutes les classes permettant de déplacer les éléments mobiles. Elles permettent d'implémenter le strategy pattern sur les élémentes mobiles.
        * model.movement.beacon: Les mouvements liés aux balises.
        * model.movement.satelitte: Les mouvements liés aux balises.
            * model.movement.beacon.decorator: Le décorateur est un design pattern implémenté. Ici il représente des mouvements avec le concept de mouvement "next" (suivant).
    * model.registerer: Le systeme d'enregistreur et de désenregistreur de balise aurpès des satellites. Implemente le design pattern Double Dispatch.

### Tests

Pour bien comprendre le code et l'architecture il a été nécessaire de tester toutes les classes une à une afin d'analyser tout le code. Beaucoup de petites améliorations ont été faite dans ce processus. Avec une couverture de tests haute, les morceaux de codes testés sont beaucoup plus propres. Voici un exemple de test `HorizontalMovementTest`.
```java
HorizontalMovement movement = new HorizontalMovement(0, 2);  
  
@Test  
void shouldMoveMobileElement() {  
  MobileElement mobileElement = new Beacon(10);  
  movement.move(mobileElement);  
  assertEquals(1, mobileElement.getPosition().x);  
}  

@Test  
void shouldMoveMobileElementBackwards() {  
  MobileElement mobileElement = new Beacon(10);  
  movement.move(mobileElement);  
  movement.move(mobileElement);  
  movement.move(mobileElement);  
  assertEquals(1, mobileElement.getPosition().x);  
}
```
Tester permet de remarquer beaucoup de choses comme par exemple le couplage entre les classes. Un couplage fort rends les tests plus compliqués.  J'ai pu réduire les couplages entre les classes afin d'aérer le code et de permettre des tests plus simples.

### Magic Numbers

Régulièrement, des constantes non définies apparaissent dans le code. Dans ce [commit](https://github.com/Prakkkmak/cours-satelites-projet/commit/e6dcc55eb082cea210fc98c69dd9c05456071d9a) une constante a été définie.
```java
private  static  final  int  SYNC_RANGE  =  10;
``` 
Cette constante permet de rendre la taille de synchronisation directement au début de la classe. Ce nombre est utilisé plusieurs fois dans la classe, en le rendant paramétrable, il n'y aura qu'un ligne a changé au besoin.


### Single Responsability Principle

Le code existant ne suis pas le SRP à de très nombreux endroits. Les classes et méthodes n'agissent pas toutes selon leurs responsabilités. Je me suis assuré que toutes les classes et méthodes en aient le moins possible. 

**Exemple**:

```java
public  void tick() {
	this.readSensors();
	if (this.memoryFull()) {
		Movement backMovement = new BeaconBackMovement(this.movement, this.getDepth());
		Movement syncMovement = new SyncMovement(backMovement);
		Movement goToSurfaceMovement = new GoToSurfaceMovement(syncMovement);
		this.setMovement(goToSurfaceMovement);
		this.resetData();
	}
	super.tick();
}
```
Dans ce morceau de code, de la classe *Beacon.java* la méthode `tick()` s'occupe de lire les capteurs, de vérifier si la mémoire est pleine et de mettre en place les prochains mouvements ainsi que la remise à zéro des données.

Une première amélioration est tout simplement de mettre le mouvement à l'extérieur de la méthode.
```java
public  void tick() {
	this.readSensors();
	if (this.memoryFull()) {
		setNextMovements();
	}
	super.tick();
}

public void setNextMovements(){
	Movement backMovement = new BeaconBackMovement(this.movement, this.getDepth());
	Movement syncMovement = new SyncMovement(backMovement);
	Movement goToSurfaceMovement = new GoToSurfaceMovement(syncMovement);
	this.setMovement(goToSurfaceMovement);
	this.resetData();
}
```
Le commit associé est disponible [ici](https://github.com/Prakkkmak/cours-satelites-projet/commit/86a527b86b902e99567942f3d1731fd0fc43efda?branch=86a527b86b902e99567942f3d1731fd0fc43efda&diff=unified). Dans le futur, la méthode `tick()` ressemble à ça:
```java
public void tick() {  
	this.state = this.state.next(this);  
	super.tick();  
}
```
La méthode n'a qu'une responsabilité, celle de passer a au prochain état et de l'exécuter.
Je ne vais pas expliciter toutes les méthodes et classes améliorées de la sorte. Grâce au principe de responsabilité,  les services proposés par les classes sont beaucoup plus simples à tester. Les principales modifications sur la responsabilité sont les suivantes: 
* `Beacon` a désormais un attribut `BeaconSynchronizer` qui gère toute la synchronisation de la balise. 
* `Beacon` a désormais un attribut `IBeaconState` qui maintient l'état de la balise. La balise peux être dans différents états et à chaque tick, exécute son action en vérifiant si elle doit passer à l'état suivant.
* `Manager` ne s'occupe désormais de gérer les éléments mobiles présents dans la simulation et utiliser un `IRegisterer` pour enregistrer les éléments entre eux au besoin.
* `Movement` n'a plus aucune responsabilité lié à autre chose que le mouvement. Certaines classes notamment celle dédiée à la synchronisation de la balise en surface.

### Mouvements

Le package `movement` permet d'implémenter le design pattern strategy aux éléments mobiles. Chaque `MobileElement` a un mouvement associé et l'exécute à chaque tick. L'ancien code proposais le concept de mouvement suivant pour chaque mouvement. Or, les mouvements "basiques" (l'horizontal, le vertical ...) n'avaient jamais de suivant et implémentaient l'attribut next.
Le concept de next des donc un décorateur, autrement dit un ajout, spécifique a certains mouvements. Seuls 3 mouvements, dans le présent code en ont besoin. Voici le diagramme de d'héritage associé.
![Diagramme de dépendances](https://i.imgur.com/SGtGcGH.png)
De cette manière seul les `BeaconMovementDecorator` comprennent le systeme de suivant et l'implémentent. Si par la suite il y a besoin de créer des mouvements qui doivent s'enchainer, alors il suffira d'étendre la classe de cette dernière. Dans le cas contraire il suffira d'étendre de `BeaconMovement`.

On peux aussi remarquer que `SatelliteMovement` et `BeaconMovement` sont passés en Abstract. `BeaconMovement` n'était jamais instancié et ne décris pas réellement un mouvement concret. Pour rendre le code 'symétrique'. `SatelliteMovement` a reçu le même sort. Il est désormais nécessaire d'avoir des implémentations du mouvement du satellite.

**Ma gestion de la machine à état**
 
```java
public abstract class BeaconMovementDecorator extends BeaconMovement {  

	protected Movement next;  
	
	public BeaconMovementDecorator(Movement next){  
		this.next = next;  
	}
	
	@Override  
	public void move(MobileElement target){  
		if(isReadyForNextMovement(target)) this.nextMovement(target);  
	}  
	
	public abstract boolean isReadyForNextMovement(MobileElement target);  
	
	public void nextMovement(MobileElement target){  
		target.setMovement(this.next);  
	}  
}
```
Chaque déplacement pourvu d'un mouvement suivant doit implémenter la méthode `move()` et `isReadyForNextMovement()`.  Cette dernière vérifie si il est nécessaire de passer au mouvement. Le mouvement est responsable du mouvement et et de la vérification du passage au prochain au final:

```java
public class GoToSurfaceMovement extends BeaconMovementDecorator {     
	public GoToSurfaceMovement(Movement next) {  
		super(next);  
	}  

	@Override  
	public void move(MobileElement target) {  
		Point p = target.getPosition();  
		int y = p.y;  
		if (y > 0) {  
			y -= this.speed;  
			if (y < 0) y = 0;  
			target.setPosition(new Point(p.x, y));  
		}  
		super.move(target);  
	}  

	@Override  
	public boolean isReadyForNextMovement(MobileElement target) {  
		return target.getPosition().getY() <= 0;  
	}  
}
```
On notera de l'ajout du concept de **`this.speed`** qui est commun a tous les mouvements et permet de définir la vitesse de l'objet. De cette manière on enlève le magic number et rend la vitesse paramétrable pour tous.

### Le cas du Manager

Par choix le Manager est un singleton qui gère des éléments mobiles. Plusieurs classes ont besoin du Manager et le rendre Singleton lui permet d'être accessible partout. Malheureusement, travailler de cette manière bloque le code a un cas ou nous ne pouvons faire plusieurs implémentations du Manager. L'application dans son état actuel est propice à l'utilisation d'un singleton avec un seul et unique Manager concret. 
Le manager ne gère plus deux listes d'objets Satellite et Balise mais bien une seule liste d'éléments mobiles. Voici les responsabilités du Manager: ajouter les éléments mobiles au `Set` d'éléments mobiles, `tick()` les éléments mobiles et enregistrer les éléments entre eux (pour le système d'évènements).

### Double Dispatch

Afin de permettre aux objets de s'enregistrer sans eux sans utiliser des cast explicites dans le Manager ( et par conséquent ne pas rendre le Manager dépendant des objets concrets éléments mobiles ), j'ai utilisé le double dispatch.
![enter image description here](https://i.imgur.com/0O8dttF.png)
![enter image description here](https://i.imgur.com/JQ9tJAz.png)
Voici un diagramme de séquence qui représente l'implémentation du double dispatch. La partie intéressante est l'utilisation de cette interface.
```java
public interface IRegisterer {  
    default void run(MobileElement mobileElement){}  
    default void run(Beacon beacon) {}  
    default void run(Satelitte satelitte) {}  
}
```
Cette interface permet de ne pas avoir à cast l'élément visité. J'ai utilisé le DP visitor pour inspirer cette implémentation. Dans le code actuel, si le `MobileElement` est un `Satelitte` il y aura une exécution de code, sinon, rien. Aujourd'hui on peux très facilement ajouter un enregistreur sans a avoir a modifier la classe `Manager`, `Beacon` et `Satellite` ce qui entre dans le Open–closed principle et donc limite la régression.

### MobileElement

Un élément mobile n'a pas a être instancié. Il est donc passé en abstract afin de le rendre cohérent avec sa sémantique. Ainsi , les éléments mobiles doivent implémenter certaines fonctionnalités que `MobileElement` force.

### BeaconSynchronizer

Le `BeaconSynchronizer` est un attribut du `Beacon` il gère tout ce qui a un rapport avec la synchronisation. La synchronisation etais un peu partout dans le code et n'avais rien à fare dans les classes de mouvement ou dans la balise. J'ai donc décidé d'éclater le blob qu'étais `Beacon`. 

### State Pattern

Le concept d'état se ressent dans la classe Beacon. En effet, la balise peux être en collecte de donnée ou en envoi de donnée. J'ai décidé d'implémenter une machine a état transition pour le bien du projet. 
![enter image description here](https://i.imgur.com/hmspnWK.png)
Un état renvoie toujours un autre état, lui même ou bien le prochain état. Il s'occupe de vérifier si le prochain état doit être retourner. Voici a quoi ressemble un état:
```java
public class GoToSurfaceState implements IBeaconState{  
  @Override  
  public IBeaconState next(Beacon beacon) {  
        if(beacon.isInSurface()){  
            return new SyncState();  
		}  
        return this;  
  }  
}
```
De cette manière nous pouvons facilement rajouter des état a une balise (ex. recharge, panne, détresse etc ..). 

## Axes d'améliorations
Tout code est améliorable à l'infini, j'ai décidé de ne pas prendre de temps sur certains aspects pour ne pas prendre tout mon temps libre sur le projet. J'ai fais des choix plus ou moins pertinent pour comprendre et améliorer le projet. Malheureusement chaque amélioration doit-être documenté et c'est ce qui me prends le plus de temps sur le projet: rédiger le rapport.
### Redondance
Il y a deux machines à état qui exécutent plus ou moins la même chose dans les mouvements et dans la balise. Les 4 états sont "mirroir". On a donc une duplication de code qui peux se défendre par le fait que le mouvement est indépendant dans la conception. 
Pour régler le problème soulevé il suffit que les état de la balise connaissent un mouvement associé et s'occupent de lancer la méthode du mouvement.
### Threads
La partie la plus intéressante que je n'ai pas osé aborder. Un système de thread pour chaque element mobile aurait pu être un challenge intéressant et cohérent avec le projet. C'est le prochain gros morceau que je voulais aborder mais le temps m'a rattrapé.
La simulation construit toutes les machines et les machines communiquent via des évènements et des signaux. 
### Documentation
J'ai décidé de ne pas documenter le code et j'ai tenté de rendre le code le plus "self-documented" possible. Une javadoc du projet n'aurais pas été de refus.
### Les oubliées
Il y a quelques classes qui n'ont pas étés trop touchés par les améliorations. Je n'ai pas pris le temps de trouver la pertinence de leurs améliorations et changements, le code ne me choque pas plus que ça à l'état actuel.
### S.O.L.I.D
Ce projet peut-être une bonne base pour appliquer le principe du S.O.L.I.D, ca a été mon premier souhait mais je n'ai pas eu le courage de tout analyser pour tout appliquer. Les améliorations ont quand même bien rapproché le code de ses principes.

