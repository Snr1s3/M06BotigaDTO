package com.accesadades.botiga.Model;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
import java.io.Serializable;
>>>>>>> recuperar
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "subcategoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subcategoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "descripcion")
    private String descripcion;
=======
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String description;
>>>>>>> recuperar

    @ManyToOne
    @JoinColumn(name = "categoria_nombre")
    private Categoria categoria;
<<<<<<< HEAD
    public Subcategoria(String descripcion, Categoria categoria) {
        this.descripcion = descripcion;
        this.categoria = categoria;
    }
    public Long getCategoriaId() {
        return categoria != null ? categoria.getId() : null;
    }
=======
>>>>>>> recuperar
}
