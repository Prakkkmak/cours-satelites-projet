grammar AntlrSat;

script : command* ;
command : ( create | pause | 'stop');
create : 'create ' OBJ ' ' pos ' ' NB; // create S x y speed
pos : NB ' ' NB ;
pause : 'pause' ; // Pause the sim

OBJ : ('S'|'B') ;
NB  : [0-9]+ ;
DEP : ( 'hor'| 'sin' | 'ver' ) ;
WS  : [ \t\r\n]+ -> skip ;