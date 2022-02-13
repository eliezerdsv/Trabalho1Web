package dw.Mensalistas.model;

import javax.persistence.*;

//Importação de Pacote e Biblioteca
<<<<<<< HEAD
=======

>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a

@Entity
@Table(name= "pagamento")   //Cria uma tabela pagamento
public class Pagamento {
    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)     
    private int cod_pagamento;      //Geração automática de um ID para o pagamento
    @Column
    private short ano;      //Variável ano, que será uma das colunas da tabela pagamento
    @Column
    private short mes;      //Variável mes, que será uma das colunas da tabela pagamento
=======
    @GeneratedValue(strategy = GenerationType.AUTO)     //Geração automática de um ID para o pagamento
    private int cod_pagamento;  
    @Column
    private short ano;  //Variável ano, que será uma das colunas da tabela pagamento
    @Column
    private short mes;  //Variável mes, que será uma das colunas da tabela pagamento
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    @Column
    private double valor;   //Variável valor, que será uma das colunas da tabela pagamento
    
    @ManyToOne()    //Cada jogador pode possuir vários pagamentos
    @JoinColumn(name="idjogador",referencedColumnName="cod_jogador")    //Coloca o ID do jogador
<<<<<<< HEAD
    private Jogador mJogador;       //Cria uma variavel mJogador do tipo jogador
    
  

    public Pagamento(short ano, short mes, double valor, Jogador mJogador) {    //Construtor da classe pagamento com os atributos de ano, mes e valor, além do jogador
        this.ano = ano;     //Atribuição de ano
        this.mes = mes;     //Atribuição de mes
        this.valor = valor; //Atribuição de valor
        this.mJogador = mJogador;   //Atribuição de jogador
=======
    private Jogador mJogador;   //Cria uma variavel mJogador do tipo jogador
    
  
    public Jogador getmJogador() {
        return mJogador;    //Retorna mJogador
    }

    public void setmJogador(Jogador mJogador) {     //Faz o set de mJogador
        this.mJogador = mJogador;
    }

    public Pagamento(short ano, short mes, double valor, Jogador mJogador) {     //Construtor da classe pagamento com os atributos de ano, mes e valor, além do jogador
        this.ano = ano;     //Atribuição de ano
        this.mes = mes;     //Atribuição de mes
        this.valor = valor;     //Atribuição de valor
        this.mJogador = mJogador;      //Atribuição de jogador
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    }
    
    public Pagamento(){     //Construtor vazio da classe pagamento

    }
    
    public Pagamento(short ano, short mes, double valor) {      //Construtor da classe pagamento com os atributos de ano, mes e valor
        this.ano = ano;     //Atribuição de ano
<<<<<<< HEAD
        this.mes = mes;      //Atribuição de mes
        this.valor = valor;     //Atribuição de valor
       
    }
    public Pagamento(int cod_pagamento, short ano, short mes, double valor) {   //Construtor da classe pagamento com os atributos de Id, ano, mes e valor
        this.cod_pagamento = cod_pagamento;     //Atribuição de ID
        this.ano = ano;     //Atribuição de ano
        this.mes = mes;     //Atribuição de mes
        this.valor = valor;     //Atribuição de valor
       
    }
    public Pagamento(int cod_pagamento, short ano, short mes, double valor, Jogador j) {    //Construtor da classe pagamento com os atributos de Id, ano, mes e valor, além do do jogador
=======
        this.mes = mes;     //Atribuição de mes
        this.valor = valor;     //Atribuição de valor
       
    }
    public Pagamento(int cod_pagamento, short ano, short mes, double valor) {
        this.cod_pagamento = cod_pagamento;     //Atribuição de ID
        this.ano = ano;     //Atribuição de ano
        this.mes = mes;     //Atribuição de mes
        this.valor = valor; //Atribuição de valor
       
    }
    public Pagamento(int cod_pagamento, short ano, short mes, double valor, Jogador j) {         //Construtor da classe pagamento com os atributos de ano, mes, Id do pagamento e do Jogador
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
        this.cod_pagamento = cod_pagamento;     //Atribuição de ID
        this.ano = ano;     //Atribuição de ano
        this.mes = mes;     //Atribuição de mes
        this.valor = valor;     //Atribuição de valor
<<<<<<< HEAD
        this.mJogador = j;      //Atribuição de Jogador
       
    }
    public int getCod_pagamento() {     //Retorna o ID do pagamento
        return cod_pagamento;
    }
    public void setCod_pagamento(int cod_pagamento) {        //Faz o set do ID do pagamento
        this.cod_pagamento = cod_pagamento;
    }
    public short getAno() {     //Retorna o ano do pagamento
        return ano;
    }
    public void setAno(short ano) {     //Faz o set do ano do pagamento
        this.ano = ano;
    }
    public short getMes() {     //Retorna o mês do pagamento
        return mes;
    }
    public void setMes(short mes) {     //Faz o set do mês do pagamento
        this.mes = mes;
    }
    public double getValor() {      //Retorna o valor do pagamento
        return valor;
    }
    public void setValor(double valor) {        //Faz o set do valor do pagamento
        this.valor = valor;
=======
        this.mJogador = j;      //Atribuição de jogador
       
    }
    public int getCod_pagamento() {
        return cod_pagamento;   //Retorna o ID do pagamento
    }
    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;     //Faz o set do ID do pagamento
    }
    public short getAno() {
        return ano;     //Retorna o ano do pagamento
    }
    public void setAno(short ano) {
        this.ano = ano;     //Faz o set do ano do pagamento
    }
    public short getMes() {
        return mes;     //Retorna o mês do pagamento
    }
    public void setMes(short mes) {
        this.mes = mes;     //Faz o set do mês do pagamento
    }
    public double getValor() {
        return valor;   //Retorna o valor do pagamento
    }
    public void setValor(double valor) {
        this.valor = valor;     //Faz o set do valor do pagamento
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    }

  

   
   




}
