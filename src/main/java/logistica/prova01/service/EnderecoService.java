package logistica.prova01.service;

import logistica.prova01.model.Endereco;
import logistica.prova01.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> obterEndereco(String cep) {
        return enderecoRepository.findById(cep);
    }

    public Iterable<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }
    
}

