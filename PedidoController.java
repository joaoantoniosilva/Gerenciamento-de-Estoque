package Controller;

import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entidades.Pedido;
import Service.PedidoService;
import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Endpoints adicionais

    @GetMapping("/{clienteId}")
    public ResponseEntity<java.util.List<Pedido>> listarPedidosPorCliente(@PathVariable Long clienteId) {
        java.util.List<Pedido> pedidos = pedidoService.listarPedidosPorCliente(clienteId);
        return ResponseEntity.ok(pedidos);
    }

    @PatchMapping("/{pedidoId}/status")
    public ResponseEntity<Pedido> atualizarStatusPedido(@PathVariable Long pedidoId, @RequestParam String novoStatus) {
        Status statusPedido = statusPedido.valueOf(novoStatus); // Converta a string em um enum
        Pedido pedido = pedidoService.atualizarStatusPedido(pedidoId, statusPedido);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    
}