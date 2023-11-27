package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dtos.*;
import mapper.*;
import model.*;

public class Controller {

    // Listas donde persistira la informacion
    private List<Proveedor> proveedores;
    private List<Producto> productos;
    private List<OrdenCompra> ordenesCompra;
    private List<OrdenPago> ordenesPago;
    private List<Factura> facturas;
    private List<NotaCredito> notasCredito;
    private List<NotaDebito> notasDebito;
    private List<CuentaCorriente> cuentaCorrientes;

    // dtoMapper para pasar de la entidad a dto
    private MapperDTO dtoMapper;
    
    public ProveedorDTO createProveedor(String cuit, CondicionIVA iva, String razonSocial, String nombreFantasia, 
            String direccion, String telefono, String correoElectronico, double iibb, LocalDate inicioActividades) {

        Proveedor proveedor = new Proveedor(cuit, iva, razonSocial, nombreFantasia, direccion, telefono, correoElectronico, iibb, inicioActividades);

        proveedores.add(proveedor);

        return dtoMapper.toProveedorDTO(proveedor);
    }

    public Proveedor getProveedor(String cuit) {
        for (Proveedor p : proveedores) {
            if (p.getCuit().equals(cuit)) {
                return p;
            }
        }
        return null;
    }

    public List<ProveedorDTO> getAllProveedores() {
        List<ProveedorDTO> proveedoresDto = new ArrayList<>();
        for (Proveedor p : proveedores) {
            proveedoresDto.add(dtoMapper.toProveedorDTO(p));
        }
        return proveedoresDto;
    }

    public ProductoDTO createProducto(Proveedor proveedor, String nombre,TipoUnidad tipoUnidad,
            double precioUnitario, TipoIVA iva) {
        
        Producto producto = new Producto(proveedor, nombre, tipoUnidad, precioUnitario, iva);

        productos.add(producto);

        return dtoMapper.toProductoDTO(producto);
    }

    public ProductoDTO getProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return dtoMapper.toProductoDTO(producto);
            }
        }
        return null;
    }

    public List<ProductoDTO> getAllProductos() {
        List<ProductoDTO> productosDto = new ArrayList<>();
        for (Producto producto : productos) {
            productosDto.add(dtoMapper.toProductoDTO(producto));
        }
        return productosDto;
    }

    public OrdenCompraDTO generarOrdenCompra(String cuit) {
        OrdenCompra ordenCompra = new OrdenCompra();
        List<ItemProducto> items = new ArrayList<>();

        ordenCompra.setItems(items);
        ordenCompra.addItem(null, 0, 0, null);
        ordenesCompra.add(ordenCompra);
        ordenCompra.setImporte(ordenCompra.calcularTotal(items));

        Proveedor proveedor = getProveedor(cuit);
        CuentaCorriente cc = getCuentaCorrienteByProveedor(proveedor);
        if (cc != null) {
            cc.cargarCompra(ordenCompra);
        }

        return dtoMapper.toOrdenCompraDTO(ordenCompra);
    }

    public OrdenCompraDTO getOrdenCompra(Long nroOrden) {
        for (OrdenCompra orden : ordenesCompra) {
            if (orden.getNroOrden().equals(nroOrden)) {
                return dtoMapper.toOrdenCompraDTO(orden);
            }
        }
        return null;
    }

    public List<OrdenCompraDTO> getAllOrdenesCompra() {
        List<OrdenCompraDTO> ordenesDto = new ArrayList<>();
        for (OrdenCompra orden : ordenesCompra) {
            ordenesDto.add(dtoMapper.toOrdenCompraDTO(orden));
        }
        return ordenesDto;
    }

    public Factura generarFactura(OrdenCompra compra) {
        Factura factura = new Factura(compra, compra.getItems());
        facturas.add(factura);
        return factura;
    }

    public List<Factura> getAllFacturas() {
        return facturas;
    }

    public Factura getFacturaByNro(Long nroFactura) {
        for (Factura f : facturas) {
            if (f.getNroFactura().equals(nroFactura)) {
                return f;
            }
        }
        return null;
    }

    public NotaCredito generarNotaCredito(List<Producto> productos, LocalDate fechaEmision, double importe) {
        NotaCredito nota = new NotaCredito(productos, fechaEmision, importe);
        notasCredito.add(nota);
        return nota;
    }

    public List<NotaCredito> getAllNotasCredito() {
        return notasCredito;
    }

    public NotaCredito getNotaCreditoByNro(Long nroNota) {
        for (NotaCredito nc : notasCredito) {
            if (nc.getNroNotaCredito().equals(nroNota)) {
                return nc;
            }
        }
        return null;
    }

    public NotaDebito generarNotaDebito(List<Producto> productos, LocalDate fechaEmision, double importe) {
        NotaDebito nota = new NotaDebito(productos, fechaEmision, importe);
        notasDebito.add(nota);
        return nota;
    }

    public List<NotaDebito> getAllNotasDebito() {
        return notasDebito;
    }

    public NotaDebito getNotaDebitoByNro(Long nroNota) {
        for (NotaDebito nd : notasDebito) {
            if (nd.getNroNotaDebito().equals(nroNota)) {
                return nd;
            }
        }
        return null;
    }

    public CuentaCorrienteDTO crearCuentaCorriente(Proveedor proveedor, List<OrdenCompra> compras,
            List<OrdenPago> pagos, double saldo) {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(proveedor, compras, pagos, saldo);
        cuentaCorrientes.add(cuentaCorriente);
        return dtoMapper.toCuentaCorrienteDTO(cuentaCorriente);
    }

    public CuentaCorriente getCuentaCorrienteByProveedor(Proveedor proveedor) {
        for (CuentaCorriente cc : cuentaCorrientes) {
            if (cc.getProveedor().equals(proveedor)) {
                return cc;
            }
        }
        return null;
    }

    public OrdenPagoDTO crearOrdenPago(Proveedor proveedor, double importe, FormaPago formaPago,
            double totalRetenciones, Documento tipoDocumento) {
        OrdenPago ordenPago = new OrdenPago(importe, formaPago, totalRetenciones, tipoDocumento);

        ordenesPago.add(ordenPago);

        CuentaCorriente cc = getCuentaCorrienteByProveedor(proveedor);

        if (cc != null) {
            cc.cargarPago(ordenPago);
        }
        
        return dtoMapper.toOrdenPagoDTO(ordenPago);
    }

}