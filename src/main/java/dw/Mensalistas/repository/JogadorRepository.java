package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.Jparepository;

import dw.Mensalistas.model.Jogador;

import java.util.List;

public interface Jogadorrepository extends Jparepository<Jogador, Integer>{
    //List<Jogador> findByPublicado(boolean publicado);
    //Jogador> findByCodJogador(int cod_jogador);
    List<Jogador> findByNomeContaining(String nome);

}