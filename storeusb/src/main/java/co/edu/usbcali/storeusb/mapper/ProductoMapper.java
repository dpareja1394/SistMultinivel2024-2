package co.edu.usbcali.storeusb.mapper;

import java.util.List;

import co.edu.usbcali.storeusb.domain.Producto;
import co.edu.usbcali.storeusb.dto.ProductoDTO;
import co.edu.usbcali.storeusb.dto.request.CreateProductoRequest;
import co.edu.usbcali.storeusb.utils.Constants;

public class ProductoMapper {
    public static ProductoDTO domainToDTO(Producto producto) {
        return ProductoDTO.builder()
        .id(producto.getId())
        .categoriaId(producto.getCategoria() == null ? null :
            producto.getCategoria().getId())
        .referencia(producto.getReferencia())
        .nombre(producto.getNombre())
        .descripcion(producto.getDescripcion())
        .precioUnitario(producto.getPrecioUnitario())
        .unidadesDisponibles(producto.getUnidadesDisponibles())
        .estado(producto.getEstado())
        .build();
    }

    public static Producto dTOToDomain(ProductoDTO productoDTO) {
        return Producto.builder()
        .id(productoDTO.getId())
        .referencia(productoDTO.getReferencia())
        .nombre(productoDTO.getNombre())
        .descripcion(productoDTO.getDescripcion())
        .precioUnitario(productoDTO.getPrecioUnitario())
        .unidadesDisponibles(productoDTO.getUnidadesDisponibles())
        .estado(productoDTO.getEstado())
        .build();
    }

    public static List<ProductoDTO> domainToDTOList(List<Producto> productos) {
        return productos.stream().map(ProductoMapper::domainToDTO).toList();
    }

    public static List<Producto> dTOToDomainList(List<ProductoDTO> productosDTO) {
        return productosDTO.stream().map(ProductoMapper::dTOToDomain).toList();
    }

    public static Producto createProductoRequestToDomain(CreateProductoRequest createProductoRequest) {
        return Producto.builder()
                .referencia(createProductoRequest.getReferencia())
                .nombre(createProductoRequest.getNombre())
                .descripcion(createProductoRequest.getDescripcion())
                .precioUnitario(createProductoRequest.getPrecioUnitario())
                .unidadesDisponibles(createProductoRequest.getUnidadesDisponibles())
                .estado(Constants.ESTADO_ACTIVO)
                .build();
    }
}
