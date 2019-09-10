# prospect-front
@guilherme_mattos, @dimitrius_santana, @adelar_vieira

PoC - Projeto de Automação de Testes para Front-End do Portal Siebel

Projeto - 2441 Atualização cadastrais em canais

[//Esta parte de cima precisa?]:#

[![pipeline status](https://git.sicredi.net/siebel-qa/siebel-web/badges/master/pipeline.svg)](https://git.sicredi.net/siebel-qa/siebel-web/commits/master)

## Backlog 
* [Itens Passiveis de Melhorias](src/test/resources/backlog_do_projeto/TODOLIST.md)


## Descrição
Objetivo desse projeto, é Automatizar os testes funcionais do Front-End do sistemas Siebel.

[//Quantos sistemas siebel existem no sicredi?]:#

## Pré-requisito
- Ter instalado na maquina JDK, Intellij, Git Bash.

[//Qual versao do JDK? Seria legal ter o link para baixar estas ferramentas. da para usar que nem "Itens passiveis de melhoria" ]:#

## Como Baixar
- Criar uma pasta local no computador.

[//Algum lugar recomentado? Exemplo? ]:#

- Acessar o git Bash, navegar até a pasta criada.
- Realizar o clone do projeto no repositório: https://git.sicredi.net/siebel-qa/siebel-web usando o comando git clone e a URL
- Garantir que as dependências como: Maven, NgTest, selenium, tenham sido baixadas caso não, realizar a importação do site: https://mvnrepository.com

[//Será que não precisava comentar algo sobre o settings do Sicredi? ]:#

## Como Rodar
- Abrir o Intellij, ir em file -> open abrir o projeto.
- Para executar todos os testes basta navegar até o caminho: src->test->resources->suites-> botão direito no arquivo SuiteSiebelWeb.xml na opção "Run"


## Padrões
Metodos : 

1)Nome dos métodos Deve seguir o seguinte padrão: Letra minúscula na primeira letra,  caso for nome compasto, a inicial da segunda palavra com letra maiúscula. 

[//Este padrão de letra minuscula e letra maiscula é chamado de camel Case na traduçao seria letra camelo por causa do animal ]:#
[//Cuidar as quebras de linhas para ficar mais legivel o texto. ]:#
2)Os métodos deve indicar o que de fato precisa ser feito.

[//SHOWWWW!!! Só nesse caso vc estava se referindo aos métodos de com a anotaçao @test correto?]:#
   
Exemplo:
````
public void deveSalarComMesMaiorQueAtual()
public void naoDeveSalvarComMesMaiorQueAtual()
````

[//Acho que no primeiro vc digitou errado depois ajusta, este exemplo ficou muito bom. Parabéns. ]:#
- Campos E botões:

[//Campos e botoes de onde? talve precise de um pouco mais de detalhes. ]:#
1)No momento de mapear os elementos, os nomes precisam indicar a natureza do elemento.
Exemplo:
````
WebElement textDataRenda;
WebElement botaoRetornarFila;
````


