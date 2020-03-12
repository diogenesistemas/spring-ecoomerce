package br.com.rd.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {


    private Integer codigo;
    private BigDecimal vlProduto;
    private BigDecimal vlFrete;
    private Integer quantidade;
    private Integer codProduto;
    private Integer codPedido;

}
