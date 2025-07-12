// Define o pacote onde essa classe está localizada no projeto
package com.deliverytech.delivery.model;

// Importações necessárias
import jakarta.persistence.*;         // Anotações JPA para mapeamento da entidade
import lombok.Data;                  // Lombok para geração automática de métodos
import java.math.BigDecimal;         // Tipo usado para valores monetários com precisão

@Entity // Indica que esta classe será mapeada como uma tabela no banco de dados
@Data   // Gera automaticamente os métodos getters, setters, toString, equals e hashCode
public class ItemPedido {

    @Id // Define que este campo será a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Estratégia de auto incremento do ID no banco
    private Long id;

    private int quantidade;           // Quantidade do produto nesse item do pedido
    private BigDecimal precoUnitario; // Preço de cada unidade do produto
    private BigDecimal subtotal;      // Resultado de precoUnitario * quantidade

    @ManyToOne // Muitos itens podem estar ligados a um único pedido
    @JoinColumn(name = "pedido_id") // Nome da coluna de chave estrangeira no banco
    private Pedido pedido; // Pedido ao qual este item pertence

    @ManyToOne // Muitos itens podem conter o mesmo produto
    @JoinColumn(name = "produto_id") // Nome da coluna de chave estrangeira no banco
    private Produto produto; // Produto relacionado a este item
}
