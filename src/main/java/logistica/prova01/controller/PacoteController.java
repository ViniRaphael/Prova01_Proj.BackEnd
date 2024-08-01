package logistica.prova01.controller;

import logistica.prova01.model.Pacote;
import logistica.prova01.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @GetMapping
    public ResponseEntity<Iterable<Pacote>> listarPacotes() {
        return ResponseEntity.ok(pacoteService.listarPacotes());
    }

    @PostMapping
    public ResponseEntity<Pacote> adicionarPacote(@RequestBody Pacote pacote) {
        Pacote pacoteSalvo = pacoteService.salvarPacote(pacote);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacoteSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacote> obterPacote(@PathVariable String id) {
        Optional<Pacote> pacote = pacoteService.obterPacote(id);
        return pacote.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pacote> atualizarPacote(@PathVariable String id, @RequestBody Pacote pacote) {
        Optional<Pacote> pacoteExistente = pacoteService.obterPacote(id);
        if (pacoteExistente.isPresent()) {
            pacote.setId(id);
            Pacote pacoteAtualizado = pacoteService.salvarPacote(pacote);
            return ResponseEntity.ok(pacoteAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPacote(@PathVariable String id) {
        if (pacoteService.obterPacote(id).isPresent()) {
            pacoteService.removerPacote(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
