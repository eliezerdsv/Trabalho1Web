/* package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    List<Pagamento> findByAno(short ano);

    //List<Pagamento> findByNomeContain(String nome);

} */

package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
  List<Pagamento> findAll();

  //nao necessario
  //List<Pagamento> findById(int id);
}