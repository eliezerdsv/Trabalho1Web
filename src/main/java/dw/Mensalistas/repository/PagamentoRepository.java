
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.Jparepository;

import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface Pagamentorepository extends Jparepository<Pagamento, Long>{
    List<Pagamento> findByAno(short ano);

    //List<Pagamento> findByNomeContain(String nome);

} */
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a

package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.Jparepository;
import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface Pagamentorepository extends Jparepository<Pagamento, Integer> {
  List<Pagamento> findAll();

}