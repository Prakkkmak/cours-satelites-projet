// define a grammar called hello
grammar anslygrammar;

@header {
// antlr exo1
}

meeting : hour '-' ID ;
hour : H'h'MIN | H':'MIN ;

 ID  : [a-zA-Z]+ ;
 H : [0-1][0-9] | '2'[0-3];
 MIN : [0-5][0-9] ;
 WS  : [ \t\r\n]+ -> skip ;