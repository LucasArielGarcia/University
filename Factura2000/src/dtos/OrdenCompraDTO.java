package dtos;

import java.util.List;

public class OrdenCompraDTO {
    
    private Long nroOrden;
    private List<ItemProductoDTO> items;
    private double importe;
    
    public OrdenCompraDTO() {
    }
    public Long getNroOrden() {
        return nroOrden;
    }
    public void setNroOrden(Long nroOrden) {
        this.nroOrden = nroOrden;
    }
    public List<ItemProductoDTO> getItems() {
        return items;
    }
    public void setItems(List<ItemProductoDTO> items) {
        this.items = items;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }

}
