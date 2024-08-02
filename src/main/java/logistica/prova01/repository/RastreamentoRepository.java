package logistica.prova01.repository;

import logistica.prova01.model.Rastreamento;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RastreamentoRepository extends CrudRepository<Rastreamento, Long> {
    List<Rastreamento> findByPacoteId(String pacoteId);
}
