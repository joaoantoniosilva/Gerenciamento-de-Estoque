package Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entidades.Relatorio;
import Service.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    // Endpoint para criar um novo relatório
    @PostMapping
    public ResponseEntity<Relatorio> criarRelatorio(@RequestBody Relatorio relatorio) {
        Relatorio novoRelatorio = relatorioService.criarRelatorio(relatorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRelatorio);
    }

    // Endpoint para listar todos os relatórios
    @GetMapping
    public ResponseEntity<List<Relatorio>> listarRelatorios() {
        List<Relatorio> relatorios = relatorioService.listarRelatorios();
        return ResponseEntity.ok(relatorios);
    }

    // Endpoint para buscar um relatório por ID
    @GetMapping("/{id}")
    public ResponseEntity<Relatorio> buscarRelatorioPorId(@PathVariable Long id) {
        Relatorio relatorio = (Relatorio) relatorioService.buscarRelatorioPorId(id);
        if (relatorio != null) {
            return ResponseEntity.ok(relatorio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para buscar relatórios por nome
    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Relatorio>> buscarRelatoriosPorNome(@RequestParam List<Relatorio> nome) {
        List<Relatorio> buscarRelatorioPorId = (nome);
		List<Relatorio> relatorios = buscarRelatorioPorId;
        return ResponseEntity.ok(relatorios);
    }

 

	// Endpoint para buscar relatórios por nome
    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Relatorio>> buscarRelatoriosPorNome1(@RequestParam Long nome) {
        List<Relatorio> relatorios = relatorioService.buscarRelatorioPorId(nome);
        return ResponseEntity.ok(relatorios);
    }

    // Endpoint para buscar relatórios por intervalo de datas de criação
    @GetMapping("/buscarPorDataCriacao")
    public ResponseEntity<List<Relatorio>> buscarRelatoriosPorIntervaloDataCriacao(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataFinal) {
        List<Relatorio> relatorios = relatorioService.buscarRelatoriosPorIntervaloDataCriacao(dataInicial, dataFinal);
        return ResponseEntity.ok(relatorios);
    }

  
}