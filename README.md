[![pipeline status](https://git.sicredi.net/siebel-qa/siebel-web/badges/master/pipeline.svg)](https://git.sicredi.net/siebel-qa/siebel-web/commits/master)

## Backlog 
* [Itens Passiveis de Melhorias](src/test/resources/backlog_do_projeto/TODOLIST.md)


## Descrição
Objetivo desse projeto, é Automatizar os testes funcionais do Front-End do sistema *Siebel*.

## Pré-requisito
 - Ter instalado  na máquina Git , Arquivo "settings"(Onde se esncontra todas as dependências do projeto) o mesmo precisa estar na pasta ".m2":
 - Procurar Time de Qualidade para suporte (Adelar, Dimi, Guilherme, Alex, Willy):</br> 

- [JDK versão 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [Intellij](https://www.jetbrains.com/idea/download/#section=windows)
- [Git Bash](https://git-scm.com/downloads)
- [Maven](https://maven.apache.org/download.cgi)

## Como Baixar
- Criar uma pasta local no computador.

Exemplo:
````
Diretório C: para baixar os arquivos do projeto
````
- Acessar o git Bash, ir até a pasta criada.
- Realizar o clone do projeto https://git.sicredi.net/siebel-qa/siebel-web usando o comando Git Clone e a URL
- Garantir que as dependências como: TestNg, Selenium, tenham sido baixadas caso não, realizar o import das bibliotecas do Maven

## Como Rodar
- Abrir o Intellij, ir em File -> Open projeto.

- Para executar todos os testes basta ir até o caminho: src->test->resources->suites-> botão direito no arquivo SuiteSiebelWeb.xml na opção "Run"

[//Acho que poderiamos dar uma enfase na palavras chaves "SRC, Test, Resources..."]:#
[//O que é o arquivo Suite? Para que ele serve?"]:#
## Padrões

### Metodos  

1. Nome dos métodos Deve seguir o padrão "camelCase". 
2. Os métodos dos testes, deve indicar o que de fato precisa ser feito.
   
Exemplos:
````
@Test
public void deveSalvarComMesMaiorQueAtual()

@Test
public void naoDeveSalvarComMesMenorQueAtual()
````

### Campos E Botões

[//Campos e botoes de onde? talve precise de um pouco mais de detalhes. ]:#
1. No momento de mapear os elementos, os nomes precisam indicar a natureza do elemento.
Exemplo:
````
WebElement textDataRenda;
WebElement botaoRetornarFila;
````


