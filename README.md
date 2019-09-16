[![pipeline status](https://git.sicredi.net/siebel-qa/siebel-web/badges/master/pipeline.svg)](https://git.sicredi.net/siebel-qa/siebel-web/commits/master)

## Backlog 
* [Itens Passiveis de Melhorias](src/test/resources/backlog_do_projeto/TODOLIST.md)


## Descrição
Objetivo desse projeto, é Automatizar os testes funcionais do Front-End do sistema *Siebel*.

## Pré-requisito
 - Ter o arquivo "settings" do Maven (Onde esncontram-se todas as configurações do Artifactory do Sicredi) o mesmo precisa estar na pasta ".m2":
 
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
- Garantir que as dependências tenham sido baixadas.


## Como Rodar

### Localmente
- Abrir o Intellij, ir em **File -> Open projeto.**
- Para executar todos os testes basta ir até o caminho: SRC->Test->Resources->Suites-> botão direito no arquivo SuiteSiebelWeb.xml na opção "Run"
- Suite é um arquivo que agrupa todos os cenários de testes.

### Remoto (CI)
- Acessar o repositorio https://git.sicredi.net/siebel-qa/siebel-web/pipelines 
- Clicar na botão **Run Pipeline**.
- No campo **Create for**, escolher a opção **Master**.
- Clicar no botão **Create Pipeline**. 

## Padrões
- Para cada página terá um PageObjects com seus respectivos métodos criados.
- Nomes das classes e métodos escritos em português. 

# Classes  
1. Nome das classes Deve seguir o padrão [CamelCase](https://google.github.io/styleguide/javaguide.html#s5.2.2-class-names). 
2. As classes do pacote PageObject, **devem** conter ao final do seu nome a palavra **Page**. 
[PageObjects](https://github.com/SeleniumHQ/selenium/wiki/PageObjects)  

- Exemplo: **HomePage.java**

- Para executar todos os testes basta ir até o caminho: **SRC->Test->Resources->Suites**-> botão direito no arquivo SuiteSiebelWeb.xml na opção "Run"
- [Suite] é um arquivo que agrupa todos os cenários de testes. (https://testng.org/doc/documentation-main.html#testng-xml)
## Padrões


Exemplos: 
````
public class DadosBasicosPage{}
public class SolucoesFinanceirasPage{}
```` 
As classes do pacote testecases, **devem** conter ao final do seu nome a palavra **Test**.  
Exemplos:
  ````
 public class DadosBasicosTest{}
 public class SolucoesFinanceirasTest{}
 ```` 
 
## Métodos 

1. Nome dos métodos **devem** seguir o padrão [camelCase](https://google.github.io/styleguide/javaguide.html#s5.2.3-method-names). 
2. Os métodos dos testes, **devem** indicar o que de fato precisa ser feito (ação do objeto).
   
Exemplos:
````
@Test
public void deveriaSalvarComMesMaiorQueAtual()

@Test
public void naoDeveriaSalvarComMesMenorQueAtual()
````

## Selenium
#### Campos E Botões

1. Os nomes dos WebElements devem seguir o seguinte padrão:

````
WebElement textoDataRenda; // Para campos de texto
WebElement botaoRetornarFila; // Para botões
WebElement selectTipoPessoa; // Para seletores
WebElement alerta; // Para alertas
WebElement menuRetaguarda; // Para Menus
````
## Git

## Padrões
1. A nomenclatura das branchs criadas devem ter o nome da funcionalidade. 
Exemplo: saldo_conta_pf

# Dúvidas
 Procurar Time de Qualidade para suporte (Adelar, Dimi, Guilherme):</br><br>
