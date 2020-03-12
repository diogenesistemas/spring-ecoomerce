package br.com.rd.ecommerce.model.dto;

//Data Transfer Object

import br.com.rd.ecommerce.model.Categoria;
import br.com.rd.ecommerce.model.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer codigo;
    private Date dtPedido;
    private Integer idCliente;
    private BigDecimal vlPedido;
    private BigDecimal vlFrete;
    private String dsFormaPagto;
    private List<ItemPedidoDTO> items;

}
