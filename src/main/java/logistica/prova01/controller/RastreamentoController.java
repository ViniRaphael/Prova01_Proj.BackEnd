package logistica.prova01.controller;

import logistica.prova01.model.Rastreamento;
import logistica.prova01.service.RastreamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @PostMapping
    public ResponseEntity<Rastreamento> adicionarRastreamento(@RequestBody Rastreamento rastreamento) {
        Rastreamento rastreamentoSalvo = rastreamentoService.salvarRastreamento(rastreamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(rastreamentoSalvo);
    }

    @GetMapping("/{pacoteId}")
    public ResponseEntity<List<Rastreamento>> obterRastreamentos(@PathVariable Long pacoteId) {
        List<Rastreamento> rastreamentos = rastreamentoService.obterRastreamentos(pacoteId);
        if (rastreamentos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rastreamentos);
    }
}

