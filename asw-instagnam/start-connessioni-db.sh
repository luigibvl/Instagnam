#!/bin/bash

docker pull mysql

docker build -t connessioni-db ./connessioni-db
docker run -p 8066:3306 --name connessioni-db connessioni-db:latest
