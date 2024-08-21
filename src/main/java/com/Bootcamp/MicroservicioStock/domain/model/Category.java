package com.Bootcamp.MicroservicioStock.domain.model;

public class Category {

    private Long id;
    private String name;
    private String descripcion;


    public Category(Long id, String name, String descripcion) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
