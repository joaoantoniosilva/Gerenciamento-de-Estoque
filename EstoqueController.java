package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entidades.MovimentacaoEstoque;
import Entidades.Produto;
import Service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    // Endpoints adicionais

    @GetMapping("/produtos/com-nivel-minimo")
    public ResponseEntity<List<Produto>> listarProdutosComNivelMinimoAtingido() {
        List<Produto> produtos = estoqueService.listarProdutosComNivelMinimoAtingido();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping("/movimentacoes/entrada")
    public ResponseEntity<MovimentacaoEstoque> registrarEntradaEstoque(@RequestParam Long produtoId, @RequestParam int quantidade) {
        MovimentacaoEstoque movimentacao = estoqueService.registrarEntradaEstoque(produtoId, quantidade);
        if (movimentacao != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/movimentacoes/saida")
    public ResponseEntity<MovimentacaoEstoque> registrarSaidaEstoque(@RequestParam Long produtoId, @RequestParam int quantidade) {
        MovimentacaoEstoque movimentacao = estoqueService.registrarSaidaEstoque(produtoId, quantidade);
        if (movimentacao != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
 
}
