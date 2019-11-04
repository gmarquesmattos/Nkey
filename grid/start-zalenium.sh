#!/bin/bash
docker stop zaleniumsiebel || true
docker rm zaleniumsiebel || true

docker pull docker.sicredi.net/elgalu/selenium
docker pull docker.sicredi.net/dosel/zalenium

docker run --rm -d --name zaleniumsiebel -p 4445:4444 \
-v /var/run/docker.sock:/var/run/docker.sock \
--privileged docker.sicredi.net/dosel/zalenium start --timeZone "America/Sao_Paulo" \
--screenWidth 1280 --screenHeight 800 \
--desiredContainers 1 --maxDockerSeleniumContainers 10 --maxTestSessions 1 \
--videoRecordingEnabled false --seleniumImageName docker.sicredi.net/elgalu/selenium

#Garantir Grid Online
contador=0
sleep 5
until curl -sSL http://localhost:4445/wd/hub/status | jq '.value.ready' | grep true
do
  if [ $contador = 5 ]; then
	echo "Esgotado numero de tentativas!"
	break;
  fi
  echo "Aguardando Grid..."
  let contador=contador+1
  sleep 10
done
