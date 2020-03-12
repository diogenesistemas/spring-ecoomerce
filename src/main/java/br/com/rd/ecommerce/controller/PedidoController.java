package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Pedido;
import br.com.rd.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    @Autowired
    PedidoService service;

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok().body(service.salvar(pedido));
    }
}
