package br.com.rd.ecommerce.service;

import br.com.rd.ecommerce.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PedidoService")
public class PedidoService {

    @Autowired
    PedidoRepository repository;
    public Pedido salvar(Pedido pedido){
        return repository.save(pedido);
    }

}
