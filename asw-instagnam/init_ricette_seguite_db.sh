#!/bin/bash

docker pull mysql

docker stop ricette-seguite_db
docker rm ricette-seguite_db

docker build -t ricette-seguite_db ./ricette-seguite_db
docker run -p 8068:3306 --name ricette-seguite_db ricette-seguite_db:latest

