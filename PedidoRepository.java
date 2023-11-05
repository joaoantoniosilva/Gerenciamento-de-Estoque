package Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entidades.Pedido;
import ch.qos.logback.core.status.Status;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Método de busca por cliente
    List<Pedido> findByClienteId(Long clienteId);

    // Método de busca por status
    List<Pedido> findByStatus(Status status);

  
}
