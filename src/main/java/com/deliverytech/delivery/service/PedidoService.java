package com.deliverytech.delivery.service;

import com.deliverytech.delivery.model.Pedido;
import com.deliverytech.delivery.model.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    
    // === OPERAÇÕES BÁSICAS ===
    Pedido criar(Pedido pedido);
    Optional<Pedido> buscarPorId(Long id);
    
    // === BUSCAS ESPECÍFICAS ===
    List<Pedido> buscarPorCliente(Long clienteId);         
    List<Pedido> buscarPorRestaurante(Long restauranteId);  
    List<Pedido> buscarPorStatus(StatusPedido status);     
    
    // === GESTÃO DE STATUS ===
    Pedido atualizarStatus(Long id, StatusPedido status); 
    Pedido confirmar(Long id);                             
    void cancelar(Long id);                                
    
    // === GESTÃO DE ITENS ===
    Pedido adicionarItem(Long pedidoId, Long produtoId, Integer quantidade);
    
    // === CÁLCULOS ===
    BigDecimal calcularTotal(Pedido pedido);                
    
    // === RELATÓRIOS ===
    List<Pedido> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim);
    
}