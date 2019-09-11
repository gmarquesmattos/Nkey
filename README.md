[![pipeline status](https://git.sicredi.net/siebel-qa/siebel-web/badges/master/pipeline.svg)](https://git.sicredi.net/siebel-qa/siebel-web/commits/master)

## Backlog 
* [Itens Passiveis de Melhorias](src/test/resources/backlog_do_projeto/TODOLIST.md)


## Descrição
Objetivo desse projeto, é Automatizar os testes funcionais do Front-End do sistema *Siebel*.

## Pré-requisito
 - Ter instalado  na máquina Git , Arquivo "settings"(Onde se esncontra todas as configurações do Artifactory) o mesmo precisa estar na pasta ".m2":
 - Procurar Time de Qualidade para suporte (Adelar, Dimi, Guilherme):</br><br>
 -As dependências do Maven estão no arquivo "pom.xml" 

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
<<<<<<< HEAD
- Garantir que as dependências como: TestNg, Selenium, tenham sido baixadas caso não, realizar o import das bibliotecas do Maven
=======
- Garantir que as dependências tenham sido baixadas.
>>>>>>> a85dcc1025a348ced6e67d6ff12055dbe01724b1

## Como Rodar
- Abrir o Intellij, ir em **File -> Open projeto.**

<<<<<<< HEAD
- Para executar todos os testes basta ir até o caminho: SRC->Test->Resources->Suites-> botão direito no arquivo SuiteSiebelWeb.xml na opção "Run"
- Suite é um arquivo que agrupa todos os cenários de testes.
## Padrões
- Para cada página terá um PageObjects com seus respectivos métodos criados.
- Exemplo: HomePO.java
###Classes
=======
- Para executar todos os testes basta ir até o caminho: **SRC->Test->Resources->Suites**-> botão direito no arquivo SuiteSiebelWeb.xml na opção "Run"
- [Suite] é um arquivo que agrupa todos os cenários de testes. (https://testng.org/doc/documentation-main.html#testng-xml)
## Padrões
- Para cada página terá um PageObjects com seus respectivos métodos criados.
- Exemplo: **HomePage.java**

## Classes  
As classes do pacote PageObject, ter ao final do seu nome, a as letras **Page**, que representa uma pageObject.
E ter o nome do Página [PageObjects](https://github.com/SeleniumHQ/selenium/wiki/PageObjects)
Exemplos: 
````
public class DadosBasicosPage{}
public class SolucoesFinanceirasPage{}
```` 
As classes do pacote testecases, a conotação **Test** ao final do nome, seguindo o mesmo empacotamento 
da classe deve ser escrita.
Exemplos:
  ````
 public class DadosBasicosTest{}
 public class SolucoesFinanceirasTest{}
 ```` 
>>>>>>> a85dcc1025a348ced6e67d6ff12055dbe01724b1
 
### Metodos  

1. Nome dos métodos Deve seguir o padrão "camelCase". 
2. Os métodos dos testes, deve indicar o que de fato precisa ser feito (ação do objeto).
   
Exemplos:
````
@Test
public void deveSalvarComMesMaiorQueAtual()

@Test
public void naoDeveSalvarComMesMenorQueAtual()
````

### Campos E Botões
<<<<<<< HEAD

[//Campos e botoes de onde? talve precise de um pouco mais de detalhes. ]:#
1. No momento de mapear os elementos, os nomes precisam indicar a natureza do elemento.
Exemplo:
=======
1. Os nomes dos WebElements devem seguir o seguinte padrão:

>>>>>>> a85dcc1025a348ced6e67d6ff12055dbe01724b1
````
WebElement textDataRenda; // Para campos de texto
WebElement botaoRetornarFila; // Para botões
WebElement selectTipoPessoa; // Para seletores
WebElement alerta; // Para seletores
````


