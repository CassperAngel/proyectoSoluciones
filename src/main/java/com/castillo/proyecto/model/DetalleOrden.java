package com.castillo.proyecto.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Table(name="detalles")
@Entity
public class DetalleOrden implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="detalleo_id")
    private Integer id;
    @Column(name="detalleo_nom")
    private String nombre;
    @Column(name="detalleo_cantidad")
    private double cantidad;
    @Column(name="detalleo_precio")
    private double precio;
    @Column(name="detalleo_total")
    private double total;

    @OneToOne
    private Orden orden; 

    //aca tbm se creara un atributo de tipo producto
    @ManyToOne
    private Producto producto; // es una ralcion que tiene directamente con producto
    //pero que en producto no es necesario el detalle de la orden por eso en producto no se coloco un detalle orden
    //Y la visivilidad solo sera desde detalle orden 

    public DetalleOrden() {
    }

    public DetalleOrden(Integer id, String nombre, double cantidad, double precio, double total) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleOrden [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
                + ", total=" + total + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getCantidad()="
                + getCantidad() + ", getPrecio()=" + getPrecio() + ", getTotal()=" + getTotal() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    

    
}
