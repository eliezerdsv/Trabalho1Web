package dw.Mensalistas.model;

import javax.persistence.*;



@Entity
@Table(name= "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod_pagamento;
    @Column
    private short ano;
    @Column
    private short mes;
    @Column
    private double valor;
    
    @ManyToOne()
    @JoinColumn(name="idjogador",referencedColumnName="cod_jogador")
    private Jogador mJogador;
    
  
    public Pagamento(){

    }
    
    public Pagamento(short ano, short mes, double valor) {
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
       
    }
    public Pagamento(int cod_pagamento, short ano, short mes, double valor) {
        this.cod_pagamento = cod_pagamento;
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
       
    }

    public int getCod_pagamento() {
        return cod_pagamento;
    }
    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }
    public short getAno() {
        return ano;
    }
    public void setAno(short ano) {
        this.ano = ano;
    }
    public short getMes() {
        return mes;
    }
    public void setMes(short mes) {
        this.mes = mes;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

  

   
   




}
