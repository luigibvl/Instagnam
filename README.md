# INSTAGNAM 

Progetto del corso di Analisi e progettazione del software per l'anno accademico 2019-2020. 

Per avviare l'applicazione occorre aver installato Docker.

Effettuata l'installazione è possibile digitare i comandi (ciascuno in un diverso terminale)
* sh start-consul.sh (per lanciare il servizio di service discovery)
* sh start-kafka.sh (kafka va lanciato all'interno dell'omonima cartella)

e gli ulteriori comandi
* sh start-ricette-db.sh
* sh start-connessioni-db.sh 
* sh start-ricette-seguite-db.sh 

per avviare i database ricette-db, connessioni-db e ricette-seguite-db rispettivamente.</br>
Infine è possibile digitare sh start-instagnam.sh per avviare l'applicazione.

Per chiudere l'applicazione è possibile digitare i comandi
* sh stop-consul.sh
* sh stop-kafka.sh
* sh stop-all-docker-db.sh
* sh stop-instagnam.sh
