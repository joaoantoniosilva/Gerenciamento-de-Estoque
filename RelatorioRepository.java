package Repositorios;



import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entidades.Relatorio;


@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {

    // Método de busca por nome do relatório
    List<Relatorio> findByNome(String nome);

    // Método de busca por data de criação do relatório
    List<Relatorio> findByDataCriacaoBetween(Date dataInicial, Date dataFinal);

    // Método de busca por descrição do relatório
    List<Relatorio> findByDescricaoContaining(String descricao);

    // Método de busca por nome e descrição
    List<Relatorio> findByNomeAndDescricao(String nome, String descricao);

    // Método de busca por nome ou descrição
    List<Relatorio> findByNomeOrDescricao(String nome, String descricao);

   
}