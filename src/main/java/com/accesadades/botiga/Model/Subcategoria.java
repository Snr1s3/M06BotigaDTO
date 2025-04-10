package com.accesadades.botiga.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import java.sql.Timestamp;
import java.util.List;
@Entity
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Subcategoria;

    private String desc_Subcategoria;   
    private String status_Subcategoria;

    @ManyToOne
    @JoinColumn(name = "id_Categoria")
    private Categoria categoria;

    private Timestamp creation_at;
    private Timestamp updated_at;

    @OneToMany(mappedBy = "categoria")
    private List<Subcategoria> subcategories;

    public Long getId_Subcategoria() {
        return id_Subcategoria;
    }

    public void setId_Subcategoria(Long id_Subcategoria) {
        this.id_Subcategoria = id_Subcategoria;
    }

    public String getDesc_Subcategoria() {
        return desc_Subcategoria;
    }

    public void setDesc_Subcategoria(String desc_Subcategoria) {
        this.desc_Subcategoria = desc_Subcategoria;
    }

    public String getStatus_Subcategoria() {
        return status_Subcategoria;
    }

    public void setStatus_Subcategoria(String status_Subcategoria) {
        this.status_Subcategoria = status_Subcategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Timestamp getCreation_at() {
        return creation_at;
    }

    public void setCreation_at(Timestamp creation_at) {
        this.creation_at = creation_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
