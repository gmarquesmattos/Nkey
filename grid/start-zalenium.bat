cmd /C start/MIN docker pull docker.sicredi.net/elgalu/selenium
docker run --rm --name zalenium -d -p 4444:4444 ^
-v /var/run/docker.sock:/var/run/docker.sock -v /temp/videos:/home/seluser/videos ^
--privileged docker.sicredi.net/dosel/zalenium start --timeZone "America/Sao_Paulo" ^
--screenWidth 1280 --screenHeight 800 ^
--desiredContainers 2 --maxDockerSeleniumContainers 10 --maxTestSessions 1 ^
--videoRecordingEnabled false --seleniumImageName docker.sicredi.net/elgalu/selenium