

package dw.Mensalistas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dw.Mensalistas.model.Pagamento;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
  List<Pagamento> findAll();

}