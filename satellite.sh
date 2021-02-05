export CLASSPATH="`pwd`/lib/antlr-4.9.1-complete.jar:$CLASSPATH"
ECHO "`pwd`/lib/antlr-4.9.1-complete.jar:$CLASSPATH"
antlr4='java org.antlr.v4.Tool'
prj='satellite'
pkg='satellite'
$antlr4 -visitor -package $pkg.generated "grammars/$prj.g4"
rm src/generated/*
mv *.java src/generated
rm *.interp *.tokens 
