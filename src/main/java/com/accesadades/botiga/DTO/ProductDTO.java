package com.accesadades.botiga.DTO;

public class ProductDTO {
    private String name;
    private SubcategoryDTO subcategory;
    private String description;
    private String company;
    private float price;
    private long units;
    private CategoriaDTO categoria;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public SubcategoryDTO getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(SubcategoryDTO subcategory) {
        this.subcategory = subcategory;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public long getUnits() {
        return units;
    }
    public void setUnits(long units) {
        this.units = units;
    }
    public CategoriaDTO getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }
}
