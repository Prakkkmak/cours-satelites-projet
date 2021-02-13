grammar AntlrSat;

script : command* ;
// Commands
command :  create | pause | assign | remove | speed | movement | color ;
assign : VAR ' = ' create ;
create : 'create ' OBJ ' ' pos ' ' NB; // create S x y speed
remove : 'remove ' VAR ;
speed : 'speed ' VAR ' ' NB ;
movement: 'movement ' VAR ' ' DEP ;
pause : 'pause' ; // Pause the sim
color : 'color ' VAR ' ' COLOR;
pos : NB ' ' NB ;


OBJ : ('S'|'B') ;
NB  : [0-9]+ ;
DEP :  'hor' | 'ver' ;
COLOR : 'blue' | 'green' | 'yellow' ;
WS  : [ \t\r\n]+ -> skip ;
VAR : [a-zA-Z]+ ;