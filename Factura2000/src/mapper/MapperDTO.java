package mapper;

import java.util.ArrayList;
import java.util.List;

import dtos.*;
import model.*;

public class MapperDTO {
    
    public ProveedorDTO toProveedorDTO(Proveedor source) {
        ProveedorDTO dto = new ProveedorDTO();

        dto.setId(source.getId());
        dto.setCuit(source.getCuit());
        dto.setIva(source.getIva());
        dto.setRazonSocial(source.getRazonSocial());
        dto.setNombreFantasia(source.getNombreFantasia());
        dto.setDireccion(source.getDireccion());
        dto.setTelefono(source.getTelefono());
        dto.setCorreoElectronico(source.getCorreoElectronico());
        dto.setIngresosBrutos(source.getIngresosBrutos());
        dto.setInicioActividades(source.getInicioActividades());
        dto.setRubros(source.getRubros());

        return dto;
    }

    public ProductoDTO toProductoDTO(Producto source) {
        ProductoDTO dto = new ProductoDTO();

        dto.setId(source.getId());
        dto.setProveedor(source.getProveedor());
        dto.setNombre(source.getNombre());
        dto.setTipoUnidad(source.getTipoUnidad());
        dto.setPrecioUnitario(source.getPrecioUnitario());
        dto.setTipoIva(source.getTipoIva());

        return dto;
    }

    public OrdenCompraDTO toOrdenCompraDTO(OrdenCompra source) {
        OrdenCompraDTO dto = new OrdenCompraDTO();

        dto.setNroOrden(source.getNroOrden());
        List<ItemProductoDTO> items = new ArrayList<>();
        for (ItemProducto item : source.getItems()) {
            items.add(toItemProductoDTO(item));
        }
        dto.setItems(items);
        dto.setImporte(source.getImporte());

        return dto;
    }

    public ItemProductoDTO toItemProductoDTO(ItemProducto source) {
        ItemProductoDTO dto = new ItemProductoDTO();

        dto.setProducto(source.getProducto());
        dto.setCantidad(source.getCantidad());
        dto.setPrecio(source.getPrecio());

        return dto;
    }

    public CuentaCorrienteDTO toCuentaCorrienteDTO(CuentaCorriente source) {
        CuentaCorrienteDTO dto = new CuentaCorrienteDTO();

        dto.setProveedor(toProveedorDTO(source.getProveedor()));
        List<OrdenCompraDTO> compras = new ArrayList<>();
        for (OrdenCompra compra : source.getCompras()) {
            compras.add(toOrdenCompraDTO(compra));
        }
        dto.setCompras(compras);
        List<OrdenPagoDTO> pagos = new ArrayList<>();
        for (OrdenPago pago : source.getPagos()) {
            pagos.add(toOrdenPagoDTO(pago));
        }
        dto.setPagos(pagos);
        dto.setSaldo(source.getSaldo());
        List<DocumentoDTO> docs = new ArrayList<>();
        for (Documento doc : source.getDocumentos()) {
            docs.add(toDocumentoDTO(doc));
        }
        dto.setDocumentos(docs);

        return dto;
    }

    public OrdenPagoDTO toOrdenPagoDTO(OrdenPago source) {
        OrdenPagoDTO dto = new OrdenPagoDTO();

        dto.setNroOrden(source.getNroOrden());
        dto.setTotalPagar(source.getTotalPagar());
        dto.setFormaPago(toFormaPagoDTO(source.getFormaPago()));
        dto.setTotalRetenciones(source.getTotalRetenciones());
        dto.setTipoDocumento(toDocumentoDTO(source.getTipoDocumento()));

        return dto;
    }

    public FormaPagoDTO toFormaPagoDTO(FormaPago source) {
        FormaPagoDTO dto = new FormaPagoDTO();

        dto.setImporte(source.getImporte());
        if (Cheque.class.equals(source.getClass())) {
            dto.setNroCheque(((Cheque) source).getNroCheque());
            dto.setEmision(((Cheque) source).getEmision());
            dto.setVencimiento(((Cheque) source).getVencimiento());
            dto.setFirmante(((Cheque) source).getFirmante());
        }

        return dto;
    }

    public DocumentoDTO toDocumentoDTO(Documento source) {
        DocumentoDTO dto = new DocumentoDTO();

        dto.setProveedor(toProveedorDTO(source.getProveedor()));
        if (Factura.class.equals(source.getClass())) {
            dto.setNroFactura(((Factura) source).getNroFactura());
            dto.setOrdenCompra(toOrdenCompraDTO(((Factura) source).getOrdenCompra()));
            List<ItemProductoDTO> items = new ArrayList<>();
            for (ItemProducto item : ((Factura) source).getItems()) {
                items.add(toItemProductoDTO(item));
            }
            dto.setItems(items);
        }
        if (NotaCredito.class.equals(source.getClass())) {
            dto.setNroNotaCredito(((NotaCredito) source).getNroNotaCredito());
            List<ProductoDTO> productos = new ArrayList<>();
            for (Producto producto : ((NotaCredito) source).getProductos()) {
                productos.add(toProductoDTO(producto));
            }
            dto.setProductos(productos);
            dto.setFechaEmision(((NotaCredito) source).getFechaEmision());
            dto.setImporte(((NotaCredito) source).getImporte());
        }
        if (NotaDebito.class.equals(source.getClass())) {
            dto.setNroNotaDebito(((NotaDebito) source).getNroNotaDebito());
            List<ProductoDTO> productos = new ArrayList<>();
            for (Producto producto : ((NotaDebito) source).getProductos()) {
                productos.add(toProductoDTO(producto));
            }
            dto.setProductos(productos);
            dto.setFechaEmision(((NotaDebito) source).getFechaEmision());
            dto.setImporte(((NotaDebito) source).getImporte());
        }

        return dto;
    }
}
