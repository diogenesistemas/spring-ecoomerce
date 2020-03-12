package br.com.rd.ecommerce.service;

import br.com.rd.ecommerce.model.ItemPedido;
import br.com.rd.ecommerce.model.Pedido;
import br.com.rd.ecommerce.model.dto.ItemPedidoDTO;
import br.com.rd.ecommerce.model.dto.PedidoDTO;
import br.com.rd.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("PedidoService")
public class PedidoService {

    @Autowired
    PedidoRepository repository;
    public ResponseEntity salvar(PedidoDTO pedidoDTO){

        //TODO incluir validações

        //Validações deveriam ser numa classe PedidoBO (BusinessObject)
        if(pedidoDTO==null || pedidoDTO.getIdCliente() == null)
            return ResponseEntity.badRequest().body(new Exception("Id Cliente não Encontrado"));
        if(pedidoDTO.getItems() == null)
            return ResponseEntity.badRequest().body(new Exception("Pedido não contém ítem"));

        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setDtPedido(pedidoDTO.getDtPedido());
        pedidoEntity.setIdCliente(pedidoDTO.getIdCliente());
        pedidoEntity.setVlPedido(pedidoDTO.getVlPedido());
        pedidoEntity.setVlFrete(pedidoDTO.getVlFrete());
        pedidoEntity.setDsFormaPagto(pedidoDTO.getDsFormaPagto());
        pedidoEntity.setDtAtualizacao(new Date());

        List<ItemPedido> listaDeItens = new ArrayList<>();

        for (ItemPedidoDTO itemPedido : pedidoDTO.getItems()){
            ItemPedido it = new ItemPedido();
            it.setVlProduto(itemPedido.getVlProduto());
            it.setQuantidade(itemPedido.getQuantidade());
            it.setCodProduto(itemPedido.getCodProduto());
            it.setVlFrete(itemPedido.getVlFrete());

            listaDeItens.add(it);
        }

        pedidoEntity.setItensPedido(listaDeItens);

        Pedido retornoEntity = repository.save(pedidoEntity);

//        PedidoDTO retornoDTO = new PedidoDTO();
//        retornoDTO.setCodigo(retornoEntity.getCodPedido());

        pedidoDTO.setCodigo(retornoEntity.getCodPedido());
        return ResponseEntity.ok().body(pedidoDTO);
    }

}
