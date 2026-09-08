package dev.java10x.MagicStoreIA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "food_item")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    private LocalDateTime validade;

 @Enumerated(EnumType.STRING)
    private  Categoria categoria;

 @Enumerated(EnumType.STRING)
    private UnidadeMedia unidadeMedia;

 @Enumerated(EnumType.STRING)
    private Armazenamento armazenamento;

}
