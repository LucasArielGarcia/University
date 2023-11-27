package model;

public class OrdenPago {

    private static Long contador = 0L;
    private Long nroOrden;
    private double totalPagar;
    private FormaPago formaPago;
    private double totalRetenciones;
    private Documento tipoDocumento;

    public OrdenPago(double totalPagar, FormaPago formaPago, double totalRetenciones, Documento tipoDocumento) {
        contador++;
        nroOrden = contador;
        this.totalPagar = totalPagar;
        this.formaPago = formaPago;
        this.totalRetenciones = totalRetenciones;
        this.tipoDocumento = tipoDocumento;
    }

    public Documento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Documento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getNroOrden() {
        return nroOrden;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public double getTotalRetenciones() {
        return totalRetenciones;
    }

    public void setTotalRetenciones(double totalRetenciones) {
        this.totalRetenciones = totalRetenciones;
    }

}
