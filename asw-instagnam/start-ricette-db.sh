#!/bin/bash

docker pull mysql

docker build -t ricette-db ./ricette-db
docker run -p 8067:3306 --name ricette-db ricette-db:latest
