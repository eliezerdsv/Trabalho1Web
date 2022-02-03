package dw.Mensalistas.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name= "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod_jogador;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private Date datanasc;
    
    @OneToMany(mappedBy = "mJogador", cascade = CascadeType.ALL)
  
    private Set<Pagamento> listaPagamento;

    
    public Set<Pagamento> getListaPagamento() {
        return listaPagamento;
    }

    public void setListaPagamento(Set<Pagamento> listaPagamento) {
        this.listaPagamento = listaPagamento;
    }

    public Jogador(){

    }

    public Jogador(String nome, String email, Date datanasc) {
        this.nome = nome;
        this.email = email;
        this.datanasc = datanasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public int getCod_jogador() {
        return cod_jogador;
    }

    public void setCod_jogador(int cod_jogador) {
        this.cod_jogador = cod_jogador;
    }
    
}
