[//Esta parte de cima precisa?]:#

[![pipeline status](https://git.sicredi.net/siebel-qa/siebel-web/badges/master/pipeline.svg)](https://git.sicredi.net/siebel-qa/siebel-web/commits/master)

## Backlog 
* [Itens Passiveis de Melhorias](src/test/resources/backlog_do_projeto/TODOLIST.md)


## Descrição
Objetivo desse projeto, é Automatizar os testes funcionais do Front-End do sistema *Siebel*.

## Pré-requisito
Ter instalado na maquina Git Bash, Arquivo "settings" o mesmo precisa estar na pasta ".m2":
- [JDK versão 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [Intellij](https://www.jetbrains.com/idea/download/#section=windows)
- [Git Bash](https://git-scm.com/downloads)
- [Maven](https://maven.apache.org/download.cgi)

## Como Baixar
- Criar uma pasta local no computador.
Exemplo:
````
Se possivel criar a mesma no diretório c:
````
- Acessar o git Bash, navegar até a pasta criada.
- Realizar o clone do projeto no repositório: https://git.sicredi.net/siebel-qa/siebel-web usando o comando git clone e a URL
- Garantir que as dependências como: TestNg, Selenium, tenham sido baixadas caso não, realizar a importação do site: https://mvnrepository.com


## Como Rodar
- Abrir o Intellij, ir em file -> open abrir o projeto.
- Para executar todos os testes basta navegar até o caminho: src->test->resources->suites-> botão direito no arquivo SuiteSiebelWeb.xml na opção "Run"


## Padrões
Metodos : 

1. Nome dos métodos Deve seguir o padrão "CamelCase". 
2. Os métodos dos testes, deve indicar o que de fato precisa ser feito.
   
Exemplo:
````
@Test
public void deveSalvarComMesMaiorQueAtual()

@Test
public void naoDeveSalvarComMesMenorQueAtual()
````

- Campos E botões:

[//Campos e botoes de onde? talve precise de um pouco mais de detalhes. ]:#
1)No momento de mapear os elementos, os nomes precisam indicar a natureza do elemento.
Exemplo:
````
WebElement textDataRenda;
WebElement botaoRetornarFila;
````


