package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.Jparepository;

import dw.Mensalistas.model.Jogador;

import java.util.List;

<<<<<<< HEAD
public interface JogadorRepository extends JpaRepository<Jogador, Integer>{
    
=======
public interface Jogadorrepository extends Jparepository<Jogador, Integer>{
    //List<Jogador> findByPublicado(boolean publicado);
    //Jogador> findByCodJogador(int cod_jogador);
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    List<Jogador> findByNomeContaining(String nome);

}