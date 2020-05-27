#!/bin/bash

docker stop ricette_db
docker rm ricette_db

docker stop connessioni_db
docker rm connessioni_db
