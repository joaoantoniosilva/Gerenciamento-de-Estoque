package Repositorios;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entidades.MovimentacaoEstoque;
import Entidades.Produto;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {
    List<MovimentacaoEstoque> findByProduto(Produto produto);
    
    // Método de busca por tipo de movimentação (entrada ou saída)
    List<MovimentacaoEstoque> findByTipoMovimentacao(String tipoMovimentacao);
    
    // Método de busca por data de movimentação
    List<MovimentacaoEstoque> findByDataHoraMovimentacaoBetween(Date startDate, Date endDate);
    
    // Método de busca por quantidade maior que um valor
    List<MovimentacaoEstoque> findByQuantidadeGreaterThan(int quantidade);
    
    // Método de busca por quantidade entre um intervalo
    List<MovimentacaoEstoque> findByQuantidadeBetween(int minQuantity, int maxQuantity);
    
    // Método de busca por produtos com nível de estoque mínimo atingido
    List<MovimentacaoEstoque> findByProdutoNivelEstoqueMinimoReached(Produto produto);

	List<MovimentacaoEstoque> findByTipoMovimentacaoAndDataHoraMovimentacaoBetween(String tipoMovimentacao,
			java.util.Date dataInicial, java.util.Date dataFinal);

	List<MovimentacaoEstoque> findByProdutoIdAndQuantidadeGreaterThan(Long produtoId, int quantidadeMinima);
}
