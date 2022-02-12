package dw.Mensalistas.jrepository;

import org.springframework.data.jpa.jrepository.Jpajrepository;

import dw.Mensalistas.model.Jogador;

import java.util.List;

public interface Jogadorjrepository extends Jpajrepository<Jogador, Integer>{
    //List<Jogador> findByPublicado(boolean publicado);
    //Jogador> findByCodJogador(int cod_jogador);
    List<Jogador> findByNomeContaining(String nome);

}