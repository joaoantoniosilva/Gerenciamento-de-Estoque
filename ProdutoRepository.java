package Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entidades.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);
    
    List<Produto> findByNivelEstoqueMinimoLessThan(int nivelEstoqueMinimo);
    
    // Método de busca por descrição (pesquisa parcial)
    List<Produto> findByDescricaoContaining(String descricao);
    
    // Método de busca por preço menor que um valor
    List<Produto> findByPrecoLessThan(double preco);
    
    // Método de busca por preço entre um intervalo
    List<Produto> findByPrecoBetween(double minPrice, double maxPrice);
    
    // Método de busca por unidades de medida
    List<Produto> findByUnidadeMedida(String unidadeMedida);
    
    // Método de busca por nome e unidade de medida
    List<Produto> findByNomeAndUnidadeMedida(String nome, String unidadeMedida);
}