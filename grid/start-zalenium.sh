#!/bin/bash
docker stop siebelSelenium || true
docker rm siebelSelenium || true

docker pull docker.sicredi.net/selenium/standalone-chrome
docker run -d -name siebelSelenium -e SCREEN_WIDTH=1366 -e SCREEN_HEIGHT=768 -e SCREEN_DEPTH=24 -e SCREEN_DPI=74 -p 4446:4444 -v /dev/shm:/dev/shm docker.sicredi.net/selenium/standalone-chrome

#Garantir Grid Online
contador=0
sleep 5
until curl -sSL http://localhost:4446/wd/hub/status | jq '.value.ready' | grep true
do
if [ $contador = 5 ]; then
echo "Esgotado numero de tentativas!"
break;
fi
echo "Aguardando Selenium…"
let contador=contador+1
sleep 10
done