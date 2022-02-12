/* package dw.Mensalistas.jrepository;

import org.springframework.data.jpa.jrepository.Jpajrepository;

import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface Pagamentojrepository extends Jpajrepository<Pagamento, Long>{
    List<Pagamento> findByAno(short ano);

    //List<Pagamento> findByNomeContain(String nome);

} */

package dw.Mensalistas.jrepository;

import org.springframework.data.jpa.jrepository.Jpajrepository;
import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface Pagamentojrepository extends Jpajrepository<Pagamento, Integer> {
  List<Pagamento> findAll();

  //nao necessario
  //List<Pagamento> findById(int id);
}