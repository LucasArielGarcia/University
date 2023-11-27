package dtos;

public class OrdenPagoDTO {

    private Long nroOrden;
    private double totalPagar;
    private FormaPagoDTO formaPago;
    private double totalRetenciones;
    
    public OrdenPagoDTO() {
    }
    public Long getNroOrden() {
        return nroOrden;
    }
    public void setNroOrden(Long nroOrden) {
        this.nroOrden = nroOrden;
    }
    public double getTotalPagar() {
        return totalPagar;
    }
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    public FormaPagoDTO getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(FormaPagoDTO formaPago) {
        this.formaPago = formaPago;
    }
    public double getTotalRetenciones() {
        return totalRetenciones;
    }
    public void setTotalRetenciones(double totalRetenciones) {
        this.totalRetenciones = totalRetenciones;
    }
    public DocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(DocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    private DocumentoDTO tipoDocumento;

}
