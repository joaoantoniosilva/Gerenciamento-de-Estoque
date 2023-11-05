package Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nome;
	    private String descricao;
	    private double preco;
	    private String unidadeMedida;
	    private int nivelEstoqueAtual;
	    private int nivelEstoqueMinimo;
	    
	 // Getters e setters
	    
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		public String getUnidadeMedida() {
			return unidadeMedida;
		}
		public void setUnidadeMedida(String unidadeMedida) {
			this.unidadeMedida = unidadeMedida;
		}
		public int getNivelEstoqueAtual() {
			return nivelEstoqueAtual;
		}
		public void setNivelEstoqueAtual(int nivelEstoqueAtual) {
			this.nivelEstoqueAtual = nivelEstoqueAtual;
		}
		public int getNivelEstoqueMinimo() {
			return nivelEstoqueMinimo;
		}
		public void setNivelEstoqueMinimo(int nivelEstoqueMinimo) {
			this.nivelEstoqueMinimo = nivelEstoqueMinimo;
		}
	    
}
