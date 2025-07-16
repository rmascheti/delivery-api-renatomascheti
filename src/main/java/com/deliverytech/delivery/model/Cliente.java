package com.deliverytech.delivery.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
/* import java.util.List; */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Builder.Default
    private Boolean ativo = true;

    @Builder.Default
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public void setTelefone(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTelefone'");
    }

    public void setEndereco(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEndereco'");
    }
}