package com.castillo.proyecto.model;

public class CarritoItem {

    private Producto producto;
    private int cantidad;

    public CarritoItem(Producto producto) {
        this.producto = producto;
        this.cantidad = 1;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void aumentar() {
        this.cantidad++;
    }

    public void disminuir() {
        if (this.cantidad > 1) {
            this.cantidad--;
        }
    }

    public double getSubtotal() {
        return Double.parseDouble(producto.getPrecio()) * cantidad;
    }
}
