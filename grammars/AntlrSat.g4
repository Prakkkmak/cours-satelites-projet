grammar AntlrSat;

spawn : 'spawn ' OBJ ' ' NB ' ' NB ' ' NB (' ' DEP)?'!'; // spawn S x y speed
pause : 'pause' ; // Pause the sim

OBJ : ('S'|'B') ;
NB  : [0-9]+ ;
DEP : ( 'hor'| 'sin' | 'ver' ) ;