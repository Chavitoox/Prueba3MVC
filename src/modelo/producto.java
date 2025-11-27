/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Informatica
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String descripcionGeneral;
    private String descripcionDetallada;
    private double porcentajeCobertura;

    public Producto() {
    }

    public Producto(int id, String nombre, String descripcionGeneral, String descripcionDetallada, double porcentajeCobertura) {
        this.id = id;
        this.nombre = nombre;
        this.descripcionGeneral = descripcionGeneral;
        this.descripcionDetallada = descripcionDetallada;
        this.porcentajeCobertura = porcentajeCobertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
    }

    public double getPorcentajeCobertura() {
        return porcentajeCobertura;
    }

    public void setPorcentajeCobertura(double porcentajeCobertura) {
        this.porcentajeCobertura = porcentajeCobertura;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcionGeneral=" + descripcionGeneral + ", descripcionDetallada=" + descripcionDetallada + ", porcentajeCobertura=" + porcentajeCobertura + '}';
    }    
    
}
