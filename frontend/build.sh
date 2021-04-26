#!/bin/sh

docker pull lyndontavares/ng-cli-karma
docker run -u $(id -u) --rm -v "$PWD":/app lyndontavares/ng-cli-karma npm install
docker run -u $(id -u) --rm -v "$PWD":/app lyndontavares/ng-cli-karma ng build --prod --aot --sourcemaps

docker build -t lyndontavares/angular-app .

echo 'docker run -it -p 8081:8080 --rm lyndontavares/angular-app'
