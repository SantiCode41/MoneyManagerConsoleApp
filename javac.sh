#!/bin/zsh
javac -cp .:sqlite-jdbc-3.50.3.0.jar *.java
if [ $? -eq 0 ]; then
	java -cp .:sqlite-jdbc-3.50.3.0.jar MoneyManagerApp
else
	echo "Compilation failed, skipping java execution."
fi