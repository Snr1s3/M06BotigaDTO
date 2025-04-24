package com.accesadades.botiga.Model;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String company;

    @Column
    private Long price;

    @Column
    private Long units;

    @Column(name = "creation_at")
    private LocalDateTime creationDate;

    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    private Subcategoria subcategory;
}