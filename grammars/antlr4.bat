SET CLASSPATH=.;C:\Javalib\antlr-4.9.1-complete.jar;%CLASSPATH%
java org.antlr.v4.Tool -visitor -package generated "AntlrSat.g4"
del /s ../src/main/java/generated/*
move *.java ../src/main/java/generated
del /s /q /f *.interp
del /s /q /f *.tokens