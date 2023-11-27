package dtos;

import model.Producto;

public class ItemProductoDTO {

    private Producto producto;
    private double cantidad;
    private double precio;
    
    public ItemProductoDTO() {
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
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

}
