package com.accesadades.botiga.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;



@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Categoria;

    private String desc_Categoria;
    private String status_Categoria;

    @OneToMany(mappedBy = "categoria")
    private List<Subcategoria> subcategories;

    private Timestamp creation_at;
    private Timestamp updated_at;

    public Long getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(Long id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getDesc_Categoria() {
        return desc_Categoria;
    }

    public void setDesc_Categoria(String desc_Categoria) {
        this.desc_Categoria = desc_Categoria;
    }

    public String getStatus_Categoria() {
        return status_Categoria;
    }

    public void setStatus_Categoria(String status_Categoria) {
        this.status_Categoria = status_Categoria;
    }

    public List<Subcategoria> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategoria> subcategories) {
        this.subcategories = subcategories;
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

