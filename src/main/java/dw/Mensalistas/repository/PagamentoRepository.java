/* package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.Jparepository;

import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface Pagamentorepository extends Jparepository<Pagamento, Long>{
    List<Pagamento> findByAno(short ano);

    //List<Pagamento> findByNomeContain(String nome);

} */

package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.Jparepository;
import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface Pagamentorepository extends Jparepository<Pagamento, Integer> {
  List<Pagamento> findAll();

  //nao necessario
  //List<Pagamento> findById(int id);
}