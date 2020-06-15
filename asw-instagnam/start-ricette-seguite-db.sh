#!/bin/bash

docker pull mysql

docker build -t ricette-seguite-db ./ricette-seguite-db
docker run -p 8068:3306 --name ricette-seguite-db ricette-seguite-db:latest
