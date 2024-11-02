package co.edu.usbcali.storeusb.mapper;

import co.edu.usbcali.storeusb.domain.TipoDocumento;
import co.edu.usbcali.storeusb.dto.TipoDocumentoDTO;

import java.util.List;

public class TipoDocumentoMapper {

    public static TipoDocumentoDTO domainToDTO(TipoDocumento tipoDocumento) {
        return TipoDocumentoDTO.builder()
                .id(tipoDocumento.getId())
                .descripcion(tipoDocumento.getDescripcion())
                .build();
    }

    public static TipoDocumento dTOToDomain(TipoDocumentoDTO tipoDocumentoDTO) {
        return TipoDocumento.builder()
                .id(tipoDocumentoDTO.getId())
                .descripcion(tipoDocumentoDTO.getDescripcion())
                .build();
    }

    public static List<TipoDocumentoDTO> domainToDTOList(List<TipoDocumento> tipoDocumentos) {
        return tipoDocumentos.stream().map(TipoDocumentoMapper::domainToDTO).toList();
    }

    public static List<TipoDocumento> dTOToDomainList(List<TipoDocumentoDTO> tipoDocumentosDTO) {
        return tipoDocumentosDTO.stream().map(TipoDocumentoMapper::dTOToDomain).toList();
    }
}
