package co.edu.usbcali.storeusb.mapper;

import co.edu.usbcali.storeusb.domain.Categoria;
import co.edu.usbcali.storeusb.dto.CategoriaDTO;
import co.edu.usbcali.storeusb.dto.request.CreateCategoriaRequest;
import co.edu.usbcali.storeusb.dto.request.UpdateCategoriaRequest;
import co.edu.usbcali.storeusb.dto.response.CategoriaConProductos;
import co.edu.usbcali.storeusb.dto.response.ProductoResponseCategoriaConProductos;
import co.edu.usbcali.storeusb.utils.Constants;

import java.util.List;

public class CategoriaMapper {

    public static CategoriaDTO domainToDTO(Categoria categoria) {
        return CategoriaDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .estado(categoria.getEstado())
                .build();

    }

    public static Categoria dTOToDomain(CategoriaDTO categoriaDTO) {
        return Categoria.builder()
                .id(categoriaDTO.getId())
                .nombre(categoriaDTO.getNombre())
                .descripcion(categoriaDTO.getDescripcion())
                .estado(categoriaDTO.getEstado())
                .build();
    }

    public static List<CategoriaDTO> domainToDTOList(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaMapper::domainToDTO).toList();
    }

    public static List<Categoria> dTOToDomainList(List<CategoriaDTO> categoriasDTO) {
        return categoriasDTO.stream().map(CategoriaMapper::dTOToDomain).toList();
    }

    public static Categoria createCategoriaRequestToDomain(CreateCategoriaRequest createCategoriaRequest) {
        return Categoria.builder()
                .nombre(createCategoriaRequest.getNombre().toUpperCase())
                .descripcion(createCategoriaRequest.getDescripcion())
                .estado(Constants.ESTADO_ACTIVO)
                .build();
    }

    public static CategoriaConProductos domainToCategoriaConProductos(Categoria categoria, List<ProductoResponseCategoriaConProductos> productos) {
        return CategoriaConProductos.builder()
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .estado(categoria.getEstado())
                .productos(productos)
                .build();
    }

    public static Categoria updateCategoriaRequestToDomain(Categoria categoria, UpdateCategoriaRequest updateCategoriaRequest) {
        categoria.setNombre(updateCategoriaRequest.getNombre().toUpperCase());
        categoria.setDescripcion(updateCategoriaRequest.getDescripcion());
        return categoria;
    }


}
