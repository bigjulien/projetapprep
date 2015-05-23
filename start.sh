#!/bin/bash
xterm -hold -e "java -jar ServeurLogin.jar" &
xterm -hold -e "java -jar Publisher.jar" &
xterm -hold -e "java -jar Subscriber.jar" &
xterm -hold -e "java -jar Publisher.jar" &
xterm -hold -e "java -jar Subscriber.jar" &

