package model;

import java.util.List;

public class Factura extends Documento {

    private static Long contador = 0L;
    private Long nroFactura;
    private OrdenCompra ordenCompra;
    private List<ItemProducto> items;

    public Factura(OrdenCompra ordenCompra, List<ItemProducto> items) {
        contador++;
        nroFactura = contador;
        this.ordenCompra = ordenCompra;
        this.items = items;
    }

    public Long getNroFactura() {
        return nroFactura;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public List<ItemProducto> getItems() {
        return items;
    }

    public void setItems(List<ItemProducto> items) {
        this.items = items;
    }
    
}
