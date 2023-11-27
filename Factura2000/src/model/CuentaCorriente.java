package model;

import java.util.List;

public class CuentaCorriente {
    
    private Proveedor proveedor;
    private List<OrdenCompra> compras;
    private List<OrdenPago> pagos;
    private double saldo;
    private List<Documento> documentos;

    public CuentaCorriente(Proveedor proveedor, List<OrdenCompra> compras, List<OrdenPago> pagos, 
        double saldo) {
        this.proveedor = proveedor;
        this.compras = compras;
        this.pagos = pagos;
        this.saldo = saldo;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public CuentaCorriente() {
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<OrdenCompra> getCompras() {
        return compras;
    }

    public void setCompras(List<OrdenCompra> compras) {
        this.compras = compras;
    }

    public List<OrdenPago> getPagos() {
        return pagos;
    }

    public void setPagos(List<OrdenPago> pagos) {
        this.pagos = pagos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double cargarCompra(OrdenCompra ordenCompra) {
        compras.add(ordenCompra);
        double saldo = getSaldo() + ordenCompra.getImporte();
        return saldo;
    }

    public double cargarPago(OrdenPago ordenPago) {
        pagos.add(ordenPago);
        double saldo = getSaldo() - ordenPago.getTotalPagar();
        return saldo;
    }
    
}
