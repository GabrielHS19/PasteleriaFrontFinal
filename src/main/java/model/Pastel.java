/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabhs
 */
public class Pastel {
    private Long id;
    private String nombre;
    private Long costo;

    public Pastel() {
    }

    public Pastel(Long id, String nombre, Long costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo = costo;
    }
    
    
}
