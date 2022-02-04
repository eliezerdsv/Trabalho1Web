package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dw.Mensalistas.model.Jogador;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Integer>{
    //List<Jogador> findByPublicado(boolean publicado);
    //Jogador> findByCodJogador(int cod_jogador);
    List<Jogador> findByNomeContaining(String nome);

}