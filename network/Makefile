all: 


net: Network.class MF.class
	java -Djava.library.path=/usr/lib/lp_solve -classpath .:lpsolve55j.jar Network


Network.class: Network.java
	javac -classpath .:lpsolve55j.jar Network.java


small: SmallNet.class MF.class
	java -Djava.library.path=/usr/lib/lp_solve -classpath .:lpsolve55j.jar SmallNet


SmallNet.class: SmallNet.java
	javac -classpath .:lpsolve55j.jar SmallNet.java

MF.class: MF.java
	javac -classpath .:lpsolve55j.jar MF.java
