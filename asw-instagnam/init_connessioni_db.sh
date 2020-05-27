#!/bin/bash

docker pull mysql

docker stop connessioni_db
docker rm connessioni_db

docker build -t connessioni_db ./connessioni_db
docker run -p 8066:3306 --name connessioni_db connessioni_db:latest
