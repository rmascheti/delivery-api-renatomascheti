// Pacote onde essa classe está localizada
package com.deliverytech.delivery.model;

// Importação de classes utilitárias
import java.math.BigDecimal;          // Para valores monetários com precisão
import java.time.LocalDateTime;       // Para armazenar data e hora

// import com.deliverytech.enums.StatusPedido; 
// (Comentado por enquanto — usado se o enum estiver em outro pacote)

// Importação de anotações do JPA e do Lombok
import jakarta.persistence.*;
import lombok.Data;

@Entity // Informa que esta classe será mapeada como uma tabela no banco de dados
@Data   // Gera automaticamente getters, setters, toString, equals e hashCode
public class Pedido {

    @Id // Define que o campo será a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente (auto incremento)
    private Long id;

    private LocalDateTime dataPedido; // Data e hora em que o pedido foi realizado

    private String enderecoEntrega;   // Endereço onde o pedido será entregue

    private BigDecimal subtotal;      // Valor total dos itens do pedido, sem taxa
    private BigDecimal taxaEntrega;   // Valor cobrado pela entrega (frete)
    private BigDecimal valorTotal;    // Soma do subtotal com a taxa de entrega

    @Enumerated(EnumType.STRING) // Salva o valor do enum como texto no banco (ex: "NOVO")
    private StatusPedido status; // Representa o status atual do pedido (ex: NOVO, CANCELADO)

    @ManyToOne // Relação: muitos pedidos para um cliente
    @JoinColumn(name = "cliente_id") // Nome da coluna de chave estrangeira no banco
    private Cliente cliente; // Cliente que fez o pedido

    @ManyToOne // Relação: muitos pedidos para um restaurante
    @JoinColumn(name = "restaurante_id") // Nome da coluna de chave estrangeira no banco
    private Restaurante restaurante; // Restaurante que está atendendo o pedido

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    // Relação: um pedido pode ter vários itens
    // mappedBy = "pedido" → campo pedido está na classe ItemPedido
    // cascade = ALL → ao salvar/excluir o pedido, os itens são salvos/excluídos também
    private List<ItemPedido> itens; // Lista de produtos que fazem parte do pedido
}
