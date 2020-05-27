#!/bin/bash

docker pull mysql

docker stop ricette_db
docker rm ricette_db

docker build -t ricette_db ./ricette_db
docker run -p 8067:3306 --name ricette_db ricette_db:latest

