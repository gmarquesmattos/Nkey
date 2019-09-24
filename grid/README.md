## Selenium Grid baseado em contêiner flexível e escalável com gravação de vídeo, visualização ao vivo, autenticação básica e painel de controle.
Inicie Selenium Grid em segundos. Grid que se expande dinamicamente baseada em docker-selenium para executar seus testes no Firefox e Chrome. Se você precisar de um navegador diferente, o Zalenium pode redirecionar seus testes para um provedor de testes na nuvem (Sauce Labs, BrowserStack, TestingBot).

O Zalenium é 100% open source e é ao mesmo tempo seu e nosso, e é por isso que o convidamos a contribuir para ele.

Mais detalhes...
- [Zalenium](https://opensource.zalando.com/zalenium/) 

## Requisitos
 - Ter [Docker](https://www.docker.com/get-started) instalado.

## Como utilizar
#### Local: 
1. Clicar no start-zalenium - Inicia o Zalenium
2. Acessar http://localhost:4444/grid/console - Visuzalizar navegadores disponiveis
3. Executar os testes desejados
4. Clicar em stop-zalenium - Para o Zalenium

_Obs: .bat (Windows) e .sh (Unix)_

#### Acompanhar execução dos testes: 
 - http://localhost:4444/grid/admin/live

#### Dashboard:
- http://localhost:4444/dashboard 

#### Gitlab-ci:

```bash
zalenium:
  stage: e2e
  before_script:
    - sh grid/start-zalenium.sh
	  #- docker-compose up
	
  script: 
    - echo "Meu script/suite de teste"
    #- mvn clean test
   
  after_script:
    - sh grid/stop-zalenium.sh
	  #- docker-compose down
  
  tags:
    - docker
```

## Perguntas frequentes
- Zalenium ja vem com os browsers setados? _1 chrome e 1 firefox para cada container_
- Como faço gravacao de video? _--videoRecordingEnabled true_
- Qual a quantidade de containers padrão? _2, maximo 10 por padrao (pode ser alterado para + ou -)._
- Como aumentar quantidade de containers que inicia? _--desiredContainers	4_
- Como aumentar o número de container? _--maxDockerSeleniumContainers 20_ 
- Qual o máximo de containers que ele suporta? _6 sem perca de performance_
- Qual o máximo de sessão recomendado? _1_
- Como aumentar o número de sessão ? _--maxTestSessions 2_


## Referencias
- [Docker](https://www.docker.com/get-started)
- [Selenium](https://www.seleniumhq.org/docs/)
- [Github-Zalenium](https://github.com/zalando/zalenium)
