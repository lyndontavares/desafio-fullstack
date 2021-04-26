#!/bin/sh

cd backend
./build.sh

cd ..
cd frontend
./build.sh

cd ..
docker-compose build
