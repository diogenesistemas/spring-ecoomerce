package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pedido")
    private Integer codPedido;


    @Column(name = "dt_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtualizacao;


    @Column(name = "dt_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPedido;

    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "vl_pedido")
    private BigDecimal vlPedido;
    @Column(name = "vl_frete")
    private BigDecimal vlFrete;
    @Column(name = "ds_forma_pagto")
    private String dsFormaPagto;

    //    @OneToMany(mappedBy = "pedido")
    @OneToMany(cascade = CascadeType.ALL)
    //    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_pedido")
    private List<ItemPedido> itensPedido;

}
