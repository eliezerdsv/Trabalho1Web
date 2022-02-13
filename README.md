<<<<<<< HEAD
# TrabalhoDesenvolvimentoWEB
Trabalho1DesenvolvimentoWeb
=======
# Desenvolvimento Web: Trabalho 1
Alunos: Eliézer da Silva Vaz e Guilherme Müller 

A classe Jogador possui os atributos: cod_jogador, que representa o ID do jogador, nome, email e datanasc. Também possui métodos get e set para recuperar e atualizar esses atributos. Além disso, a classe jogador conta com dois construtores: (utilizando o princípio de Overload de Programação Orientada a Objetos) um vazio e outro que faz o set dos atributos de nome, email e datanasc. Além disso essa classe cria uma tabela no banco de dados, em que as colunas são os atributos da classse.


A classe Pagamento possui os atributos: cod_pagamento, que representa o ID do pagamento, ano, mes e também o valor do pagamento. Além de possuir os métodos get e set para cada um desses atributos. Além disso essa classe cria uma tabela no banco de dados, em que as colunas são os atributos da classse. Pagamento possui um relacionamento de n,1 com a classe jogador, ou seja, um jogador pode possuir vários pagamentos, porém um pagamento só pode pertencer à um jogador. A classe pagamento também conta com dois construtores: um que inicaliza os atributos de ano, mês, valor e de ID do pagamento enquanto outro inicaliza os atributos de ano, mês, valor e de ID do pagamento e atribui esse pagamento a um jogador; 

 Através de seus controllers, ambas as classes possuem os seguintes métodos que atendem na URL: http://localhost:8080/api:


  -Criação de um novo objeto;

  -Atualização dos atributos de um dos objetos instanciados atarvés de um ID;
  
  -Deletar todos os objetos instanciados;

  -Deletar um dos objetos instanciados através de um ID;
  
  -Retornar todos os objetos instanciados e seus dados;
  
  -Retornar os dados de um objeto instanciado atarvés de um ID;
  

Para o teste de comandos foi utilizado o software Insomnia pela praticidade de poder guardar os comandos para futuros testes. Podem ser vistos os resultados dos testes na pasta de Screenshots.

>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
