#!/bin/bash

docker stop ricette-db
docker rm ricette-db

docker stop connessioni-db
docker rm connessioni-db

docker stop ricette-seguite-db
docker rm ricette-seguite-db
