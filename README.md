[//Esta parte de cima precisa?]:#

[![pipeline status](https://git.sicredi.net/siebel-qa/siebel-web/badges/master/pipeline.svg)](https://git.sicredi.net/siebel-qa/siebel-web/commits/master)

## Backlog 
* [Itens Passiveis de Melhorias](src/test/resources/backlog_do_projeto/TODOLIST.md)


## Descrição
Objetivo desse projeto, é Automatizar os testes funcionais do Front-End do sistema *Siebel*.

## Pré-requisito
Ter instalado na maquina Git Bash, Arquivo "settings" o mesmo precisa estar na pasta ".m2":

[//Sobre o settings, acho que tem que orientar a pessoa a procurar alguém, e informar que o Settings do Sicredi. ]:#
- [JDK versão 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [Intellij](https://www.jetbrains.com/idea/download/#section=windows)
- [Git Bash](https://git-scm.com/downloads)
- [Maven](https://maven.apache.org/download.cgi)

## Como Baixar
- Criar uma pasta local no computador.

[//Sobre criar a pasta seria legal informar, exemplo: "Criar uma pasta para baixar os arquivos do projeto e talvez não precise desse exemplo"]:#
Exemplo:
````
Se possivel criar a mesma no diretório c:
````
- Acessar o git Bash, navegar até a pasta criada.

[//Ao invés de navegar da para usar a para "ir"]:#
- Realizar o clone do projeto no repositório: https://git.sicredi.net/siebel-qa/siebel-web usando o comando git clone e a URL

[//Acho que as palavras "no repositório" não são necessárias ]:#
- Garantir que as dependências como: TestNg, Selenium, tenham sido baixadas caso não, realizar a importação do site: https://mvnrepository.com

[//Acho que podemos mudar para algo como "Realizar o import das bibliotecas do Maven"]:#
## Como Rodar
- Abrir o Intellij, ir em file -> open abrir o projeto.

[//Acho que poderiamos dar uma enfase na palavras chaves "IntelliJ, File, Open"]:#
- Para executar todos os testes basta navegar até o caminho: src->test->resources->suites-> botão direito no arquivo SuiteSiebelWeb.xml na opção "Run"

[//Ao invés de navegar da para usar a para "ir"]:#
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


