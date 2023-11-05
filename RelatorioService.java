package Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entidades.MovimentacaoEstoque;
import Entidades.Produto;
import Entidades.Relatorio;
import Repositorios.MovimentacaoEstoqueRepository;
import Repositorios.ProdutoRepository;

@Service
public class RelatorioService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

	private Produto produto;

    // Métodos adicionais de serviço

    public List<MovimentacaoEstoque> buscarMovimentacoesPorTipoEData(String tipoMovimentacao, Date dataInicial, Date dataFinal) {
        return movimentacaoEstoqueRepository.findByTipoMovimentacaoAndDataHoraMovimentacaoBetween(tipoMovimentacao, dataInicial, dataFinal);
    }
    
    public List<Produto> buscarProdutosComDescricaoContendo(String descricao) {
        return produtoRepository.findByDescricaoContaining(descricao);
    }
    
    public List<Produto> buscarProdutosComNivelMinimoAtingido() {
        produto = null;
		return produtoRepository.findByNivelEstoqueMinimoLessThan(produto.getNivelEstoqueMinimo());
    }
    
    public List<MovimentacaoEstoque> buscarMovimentacoesPorProdutoEQuantidade(Long produtoId, int quantidadeMinima) {
        return movimentacaoEstoqueRepository.findByProdutoIdAndQuantidadeGreaterThan(produtoId, quantidadeMinima);
    }

	public Relatorio criarRelatorio(Relatorio relatorio) {
		return null;
	}

	public List<Relatorio> listarRelatorios() {
		return null;
	}

	public List<Relatorio> buscarRelatorioPorId(Long id) {
		return null;
	}

	public List<Relatorio> buscarRelatoriosPorIntervaloDataCriacao(java.sql.Date dataInicial, java.sql.Date dataFinal) {
		return null;
	}

}