#!/bin/bash

echo Halting all running instagnam java processes  

ps -ef | grep -e 'ricette.jar' | awk '{print "kill " $2}' | sh
ps -ef | grep -e 'connessioni.jar' | awk '{print "kill " $2}' | sh
ps -ef | grep -e 'ricette-seguite.jar' | awk '{print "kill " $2}' | sh
ps -ef | grep -e 'api-gateway.jar' | awk '{print "kill " $2}' | sh

sh ./stop_docker_db.sh
sh ./stop-consul.sh
