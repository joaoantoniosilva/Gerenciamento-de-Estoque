package Entidades;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MovimentacaoEstoque {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    private Produto produto;
	    private String tipoMovimentacao; // "ENTRADA" ou "SAIDA"
	    private int quantidade;
	    private Date dataHoraMovimentacao;
	    
	 // Getters e setters
	    
		public String getTipoMovimentacao() {
			return tipoMovimentacao;
		}
		public void setTipoMovimentacao(String tipoMovimentacao) {
			this.tipoMovimentacao = tipoMovimentacao;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		public Date getDataHoraMovimentacao() {
			return dataHoraMovimentacao;
		}
		public void setDataHoraMovimentacao(java.util.Date date) {
			this.dataHoraMovimentacao = (Date) date;
		}
		public void setProduto(Produto produto2) {
		
			
		}

}
