package co.edu.usbcali.storeusb.mapper;

import co.edu.usbcali.storeusb.domain.Categoria;
import co.edu.usbcali.storeusb.dto.CategoriaDTO;

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


}
