package Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entidades.MovimentacaoEstoque;
import Entidades.Produto;
import Repositorios.MovimentacaoEstoqueRepository;
import Repositorios.ProdutoRepository;

@Service
public class EstoqueService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

	private Produto produto;

    // Métodos adicionais de serviço

    public List<Produto> listarProdutosComNivelMinimoAtingido() {
		return produtoRepository.findByNivelEstoqueMinimoLessThan(produto.getNivelEstoqueMinimo());
    }
    
    public MovimentacaoEstoque registrarEntradaEstoque(Long produtoId, int quantidade) {
        Produto produto = produtoRepository.findById(produtoId).orElse(null);
        if (produto != null) {
            int estoqueAtual = produto.getNivelEstoqueAtual();
            produto.setNivelEstoqueAtual(estoqueAtual + quantidade);
            produtoRepository.save(produto);
            
            MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
            movimentacao.setProduto(produto);
            movimentacao.setTipoMovimentacao("ENTRADA");
            movimentacao.setQuantidade(quantidade);
            movimentacao.setDataHoraMovimentacao(new Date());
            return movimentacaoEstoqueRepository.save(movimentacao);
        }
        return null;
    }
    
    public MovimentacaoEstoque registrarSaidaEstoque(Long produtoId, int quantidade) {
        Produto produto = produtoRepository.findById(produtoId).orElse(null);
        if (produto != null) {
            int estoqueAtual = produto.getNivelEstoqueAtual();
            if (estoqueAtual >= quantidade) {
                produto.setNivelEstoqueAtual(estoqueAtual - quantidade);
                produtoRepository.save(produto);
                
                MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
                movimentacao.setProduto(produto);
                movimentacao.setTipoMovimentacao("SAIDA");
                movimentacao.setQuantidade(quantidade);
                movimentacao.setDataHoraMovimentacao(new Date());
                return movimentacaoEstoqueRepository.save(movimentacao);
            }
        }
		return null;
      
    }

   
}