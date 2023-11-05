package Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Status;

@Entity
public class Pedido {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String cliente;
	  private String pedido;
	  
	  // getters e setters
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public void setStatus(ch.qos.logback.core.status.Status statusPedido) {

		
	}
	  
	  
}
