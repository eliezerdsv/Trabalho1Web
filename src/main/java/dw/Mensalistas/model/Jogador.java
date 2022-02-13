package dw.Mensalistas.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

//Importação das bibliotecas e pacaotes
<<<<<<< HEAD

@Entity
@Table(name= "jogador")//Cria uma tabela com o nome de jogador
public class Jogador {  //Classe jogador

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cod_jogador;    //Geração automática de um ID para o jogador
    @Column
    private String nome;    //Variável nome, que será uma das colunas da tabela jogador
    @Column
    private String email;   //Variável email, que será uma das colunas da tabela jogador
    @Column
    private Date datanasc;   //Variável Data de Nascimento, que será uma das colunas da tabela jogador
=======
@Entity
@Table(name= "jogador") //Cria uma tabela com o nome de jogador
public class Jogador {  //Classe jogador

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     
    private int cod_jogador;        //Geração automática de um ID para o jogador
    @Column
    private String nome;        //Variável nome, que será uma das colunas da tabela jogador
    @Column
    private String email;       //Variável email, que será uma das colunas da tabela jogador
    @Column
    private Date datanasc;      //Variável Data de Nascimento, que será uma das colunas da tabela jogador
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    
    @OneToMany(mappedBy = "mJogador", cascade = CascadeType.ALL)    
  
    private Set<Pagamento> listaPagamento;

    
    public Set<Pagamento> getListaPagamento() {
<<<<<<< HEAD
        return listaPagamento;  //Retorna um vetor com os pagamentos
=======
        return listaPagamento;      //Retorna um vetor com os pagamentos
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    }

    public void setListaPagamento(Set<Pagamento> listaPagamento) {
        this.listaPagamento = listaPagamento;   //Faz o set da lista de pagamaneto
    }

    public Jogador(){   //Construtor vazio da classe jogador

    }

    public Jogador(String nome, String email, Date datanasc) {      //Construtor de Jogador, que terá Nome, E-mail e Data de Nascimento
<<<<<<< HEAD
        this.nome = nome;        //Atribuição nome
        this.email = email;      //Atribuição do e-mail 
        this.datanasc = datanasc;   //Atribuição da data de nascimento
    }   

    public String getNome() {   //Retorna o nome do jogador
        return nome;
    }

    public void setNome(String nome) {   //Faz o set do nome do jogador
        this.nome = nome;
    }

    public String getEmail() {  //Retorna o e-mail do jogador
        return email;
    }

    public void setEmail(String email) {     //Faz o set do e-mail do jogador
        this.email = email;
    }

    public Date getDatanasc() {     //Retorna a data de nascimento do jogador
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {    //Faz o set da data de nascimento do jogador
        this.datanasc = datanasc;
    }

    public int getCod_jogador() {    //Retorna o ID do jogador
        return cod_jogador;
    }

    public void setCod_jogador(int cod_jogador) {    //Faz o set do código do jogador
        this.cod_jogador = cod_jogador;
=======
        this.nome = nome;       //Atribuição do nome
        this.email = email;     //Atribuição do e-mail
        this.datanasc = datanasc;   //Atribuição da data de nascimento
    }

    public String getNome() {   
        return nome;    //Retorna o nome do jogador
    }

    public void setNome(String nome) {
        this.nome = nome;       //Faz o set do nome do jogador
    }

    public String getEmail() {
        return email;       //Retorna o e-mail do jogador
    }

    public void setEmail(String email) {
        this.email = email;     //Faz o set do e-mail do jogador
    }

    public Date getDatanasc() {
        return datanasc;    //Retorna a data de nascimento do jogador
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;       //Faz o set da data de nascimento do jogador
    }

    public int getCod_jogador() {
        return cod_jogador;     //Retorna o ID do jogador
    }

    public void setCod_jogador(int cod_jogador) {
        this.cod_jogador = cod_jogador;      //Faz o set do código do jogador
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    }
    
}
