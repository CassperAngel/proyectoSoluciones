package com.castillo.proyecto.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="usuarios")
@Entity
public class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usu_id")
    private Integer id;

    @Column(name="usu_nom")
    private String nombre;

    @Column(name="usu_username")
    private String username;

    @Column(name="usu_email")
    private String email;

    @Column(name="usu_direccion")
    private String direccion;

    @Column(name="usu_telefono")
    private String telefono;

    @Column(name="usu_tipo")
    private String tipo;

    @Column(name="usu_password")
    private String password;

    //como tendremos la parte de rol entonces tenemos que hacer q el rol de admin sea al que le tengan q devolvert una lista de productos para poder añadir o quitar
    //SE VA A NECESITAR UNA LISTA DE PRODUCTOS PARA UN USUARIO
    @OneToMany(mappedBy = "usuario") //especificamos que es relacion de 1 a  muchos Y QUE ESTA MAPEADA por que el campo que se llama usuario (el que se creo en producto )
    private List <Producto> productos;
    //se creara un constructor con los datos y luego sin los datos

    @OneToMany(mappedBy = "usuario")
    private List <Orden> ordenes;





    public Usuario(Integer id, String nombre, String username, String email, String direccion, String telefono,
            String tipo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.password = password;
    }

    public Usuario() {
    }

    
    //Se crearon los get and set de cada uno de los atributos de la tabla
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }


    //SE CREA UN TO STRING
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email
                + ", direccion=" + direccion + ", telefono=" + telefono + ", tipo=" + tipo + ", password=" + password
                + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getUsername()=" + getUsername()
                + ", getEmail()=" + getEmail() + ", getDireccion()=" + getDireccion() + ", getTelefono()="
                + getTelefono() + ", getTipo()=" + getTipo() + ", getPassword()=" + getPassword() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
    
    


}
