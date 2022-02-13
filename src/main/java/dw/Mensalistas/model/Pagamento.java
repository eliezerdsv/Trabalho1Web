package dw.Mensalistas.model;

import javax.persistence.*;

//Importação de Pacote e Biblioteca

@Entity
@Table(name= "pagamento")   //Cria uma tabela pagamento
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     
    private int cod_pagamento;      //Geração automática de um ID para o pagamento
    @Column
    private short ano;      //Variável ano, que será uma das colunas da tabela pagamento
    @Column
    private short mes;      //Variável mes, que será uma das colunas da tabela pagamento
    @Column
    private double valor;   //Variável valor, que será uma das colunas da tabela pagamento
    
    @ManyToOne()    //Cada jogador pode possuir vários pagamentos
    @JoinColumn(name="idjogador",referencedColumnName="cod_jogador")    //Coloca o ID do jogador
    private Jogador mJogador;       //Cria uma variavel mJogador do tipo jogador
    
  

    public Pagamento(short ano, short mes, double valor, Jogador mJogador) {    //Construtor da classe pagamento com os atributos de ano, mes e valor, além do jogador
        this.ano = ano;     //Atribuição de ano
        this.mes = mes;     //Atribuição de mes
        this.valor = valor; //Atribuição de valor
        this.mJogador = mJogador;   //Atribuição de jogador
    }
    
    public Pagamento(){     //Construtor vazio da classe pagamento

    }
    
    public Pagamento(short ano, short mes, double valor) {      //Construtor da classe pagamento com os atributos de ano, mes e valor
        this.ano = ano;     //Atribuição de ano
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
        this.cod_pagamento = cod_pagamento;     //Atribuição de ID
        this.ano = ano;     //Atribuição de ano
        this.mes = mes;     //Atribuição de mes
        this.valor = valor;     //Atribuição de valor
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
    }

  

   
   




}
