package com.example.api.service;

import com.example.api.model.Pedido;
import com.example.api.repository.PedidoRepository;
import com.example.api.exception.ValidacaoPedidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        validarPedido(pedido);
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    private void validarPedido(Pedido pedido) {
        if (pedido.getClienteNome() == null || pedido.getClienteNome().trim().isEmpty()) {
            throw new ValidacaoPedidoException("O nome do cliente é obrigatório");
        }

        if (pedido.getValorTotal() == null || pedido.getValorTotal().doubleValue() < 0) {
            throw new ValidacaoPedidoException("O valor total do pedido não pode ser negativo");
        }
    }
}
