grammar AntlrSat;

script : command* ;
command : ( create | pause | 'stop') '!' ;
create : 'create ' OBJ ' ' NB ' ' NB ' ' NB ; // create S x y speed
pause : 'pause' ; // Pause the sim

OBJ : ('S'|'B') ;
NB  : [0-9]+ ;
DEP : ( 'hor'| 'sin' | 'ver' ) ;
WS  : [ \t\r\n]+ -> skip ;