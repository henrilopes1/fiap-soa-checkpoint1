package com.example.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório")
    private String clienteNome;

    @PositiveOrZero(message = "O valor total não pode ser negativo")
    private BigDecimal valorTotal;

    private LocalDate dataPedido;

    public Pedido() {}

    public Pedido(Long id, String clienteNome, BigDecimal valorTotal, LocalDate dataPedido) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
    }

    @PrePersist
    public void preencherDataPedido() {
        this.dataPedido = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }
}
