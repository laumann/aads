javac -classpath lpsolve55j.jar $1.java
java -Djava.library.path=/usr/lib/lp_solve -classpath .:lpsolve55j.jar $1
