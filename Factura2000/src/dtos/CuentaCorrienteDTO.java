package dtos;

import java.util.List;

public class CuentaCorrienteDTO {
    
    private ProveedorDTO proveedor;
    private List<OrdenCompraDTO> compras;
    private List<OrdenPagoDTO> pagos;
    private double saldo;
    private List<DocumentoDTO> documentos;
    
    public CuentaCorrienteDTO() {
    }
    public ProveedorDTO getProveedor() {
        return proveedor;
    }
    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }
    public List<OrdenCompraDTO> getCompras() {
        return compras;
    }
    public void setCompras(List<OrdenCompraDTO> compras) {
        this.compras = compras;
    }
    public List<OrdenPagoDTO> getPagos() {
        return pagos;
    }
    public void setPagos(List<OrdenPagoDTO> pagos) {
        this.pagos = pagos;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public List<DocumentoDTO> getDocumentos() {
        return documentos;
    }
    public void setDocumentos(List<DocumentoDTO> documentos) {
        this.documentos = documentos;
    }
}
