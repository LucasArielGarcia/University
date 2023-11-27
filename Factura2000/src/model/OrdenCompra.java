package model;

import java.util.List;

public class OrdenCompra {

    private static Long contador = 0L;
    private Long nroOrden;
    private List<ItemProducto> items;
    private double importe;

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public OrdenCompra() {
        contador++;
        nroOrden = contador;
    }

    public Long getNroOrden() {
        return nroOrden;
    }

    public List<ItemProducto> getItems() {
        return items;
    }

    public void setItems(List<ItemProducto> items) {
        this.items = items;
    }

    public ItemProducto addItem(Producto producto, float cantidad, double precioUnitario, Long nroOrden) {
        ItemProducto item = new ItemProducto();

        item.setProducto(producto);
        item.setCantidad(cantidad);
        item.setPrecio(precioUnitario);
        
        getItems().add(item);

        return item;
    }

    public double calcularTotal(List<ItemProducto> items) {
        double total = 0;
        for (ItemProducto i : items) {
            double cantidad = i.getCantidad();
            double precioUnitario = i.getPrecio();
            total = total + (cantidad * precioUnitario);
        }
        return total;
    }

}
