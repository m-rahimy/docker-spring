#!/bin/bash

mvn clean package
docker-compose down -v 
docker-compose up --build
