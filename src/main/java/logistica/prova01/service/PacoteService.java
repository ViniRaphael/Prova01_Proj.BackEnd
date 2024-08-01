package logistica.prova01.service;

import logistica.prova01.model.Pacote;
import logistica.prova01.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public Pacote salvarPacote(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Optional<Pacote> obterPacote(String id) {
        return pacoteRepository.findById(id);
    }

    public void removerPacote(String id) {
        pacoteRepository.deleteById(id);
    }

    public Iterable<Pacote> listarPacotes() {
        return pacoteRepository.findAll();
    }
    
}

