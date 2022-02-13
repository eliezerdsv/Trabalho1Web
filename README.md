# Desenvolvimento Web: Trabalho 1
Alunos: Eliézer da Silva Vaz e Guilherme Müller 

A classe Jogador possui os atributos: cod_jogador, que representa o ID do jogador, nome, email e datanasc. Também possui métodos get e set para recuperar e atualizar esses atributos. Além disso, a classe jogador conta com dois construtores: (utilizando o princípio de Overload de Programação Orientada a Objetos) um vazio e outro que faz o set dos atributos de nome, email e datanasc. Além disso essa classe cria uma tabela no banco de dados, em que as colunas são os atributos da classse.


A classe Pagamento possui os atributos: cod_pagamento, que representa o ID do pagamento, ano, mes e também o valor do pagamento. Além de possuir os métodos get e set para cada um desses atributos. Além disso essa classe cria uma tabela no banco de dados, em que as colunas são os atributos da classse. Pagamaneto possui um relacionamento de 1,n com a classe jogador, ou seja, um jogador pode possuir vários pagamentos, porém um pagamento só pode pertencer à um jogador. A classe pagamento também conta com cinco construtores: 

  -Construtor vazio;

  -Construtor que inicializa os atributos de ano, mês e valor;

  -Construtor que inicaliza os atributos de ano, mês, valor e de ID do pagamento; 

  -Construtor que inicaliza os atributos de ano, mês, valor e atribui esse pagamento a um jogador;

  -Construtor que inicaliza os atributos de ano, mês, valor e de ID do pagamento e atribui esse pagamento a um jogador; 

Através de seus controllers, ambas as classes possuem os seguintes métodos:

  -Criação de um novo objeto;

  -Atualização dos atributos de um dos objetos instanciados atarvés de um ID;
  
  -Deletar todos os objetos instanciados;

  -Deletar um dos objetos instanciados através de um ID;
  
  -Retornar todos os objetos instanciados e seus dados;
  
  -Retornar os dados de um objeto instanciado atarvés de um ID;

