package logistica.prova01.service;

import logistica.prova01.model.Rastreamento;
import logistica.prova01.repository.RastreamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public Rastreamento salvarRastreamento(Rastreamento rastreamento) {
        return rastreamentoRepository.save(rastreamento);
    }

    public Iterable<Rastreamento> obterRastreamentos(Long pacoteId) {
        return rastreamentoRepository.findAll();
    }
}

