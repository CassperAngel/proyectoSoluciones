package com.castillo.proyecto.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="prod_id")
    private Integer id;
    @Column(name="prod_nom")
    private String nombre;
    @Column(name="prod_descripcion")
    private String descripcion;
    @Column(name="prod_imagen")
    private String imagen;
    @Column(name="prod_precio")
    private String precio;
    @Column(name="prod_cantidad")
    private String cantidad;

    //se crea un atributo usuario PARA VER QUE USUARIO AÑADIO O COMPRO UN PRODUCTO 
    @ManyToOne // lo mapeamos para que tenga relacion con el anterior
    //lo que hace el framework es crear un campo en la tabla productos para el id del usuario como objeto y que se mapeedirectamente a esa clase
    //un usario puede obtener los productos y un producto se peude hacer de que usauraio fue registrado 
    private Usuario usuario;


    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, String imagen, String precio, String cantidad,
            Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.usuario = usuario;
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


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getImagen() {
        return imagen;
    }


    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public String getPrecio() {
        return precio;
    }


    public void setPrecio(String precio) {
        this.precio = precio;
    }


    public String getCantidad() {
        return cantidad;
    }


    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //se crea el tostring : retorna todo los campos de la clase como 1 solo string

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
                + ", precio=" + precio + ", cantidad=" + cantidad + ", getId()=" + getId() + ", getNombre()="
                + getNombre() + ", getDescripcion()=" + getDescripcion() + ", getImagen()=" + getImagen()
                + ", getPrecio()=" + getPrecio() + ", getCantidad()=" + getCantidad() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
    

}
