grammar AntlrSat;

script : command* ;
// Commands
command :  create # cmdCreate | pause # cmdPause | assign # cmdAssign | remove # cmdRemove;
assign : VAR ' = ' create ;
create : 'create ' OBJ ' ' pos ' ' NB; // create S x y speed
remove : 'remove ' VAR ;
pause : 'pause' ; // Pause the sim
pos : NB ' ' NB ;


OBJ : ('S'|'B') ;
NB  : [0-9]+ ;
DEP : ( 'hor'| 'sin' | 'ver' ) ;
WS  : [ \t\r\n]+ -> skip ;
VAR : [a-zA-Z]+ ;