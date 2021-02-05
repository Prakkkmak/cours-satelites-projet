SET CLASSPATH=.;C:\Javalib\antlr-4.9.1-complete.jar;%CLASSPATH%
java org.antlr.v4.Tool -visitor -package generated "satellite.g4"
del ../src/main/java/generated/*
move *.java ../src/main/java/generated
del *.interp .tokens