package co.edu.usbcali.storeusb.mapper;

import java.util.List;

import co.edu.usbcali.storeusb.domain.Cliente;
import co.edu.usbcali.storeusb.dto.ClienteDTO;

public class ClienteMapper {
    public static ClienteDTO domainToDTO(Cliente cliente) {
        return ClienteDTO.builder()
        .id(cliente.getId())
        .nombres(cliente.getNombres())
        .apellidos(cliente.getApellidos())
        .documento(cliente.getDocumento())
        .estado(cliente.getEstado())
        .tipoDocumentoId(cliente.getTipoDocumento() == null ?
            null : cliente.getTipoDocumento().getId())
        .build();
    }

    public static Cliente dTOToDomain(ClienteDTO clienteDTO) {
        return Cliente.builder()
        .id(clienteDTO.getId())
        .nombres(clienteDTO.getNombres())
        .apellidos(clienteDTO.getApellidos())
        .documento(clienteDTO.getDocumento())
        .estado(clienteDTO.getEstado())
        .build();
    }

    public static List<ClienteDTO> domainToDTOList(List<Cliente> clientes) {
        return clientes.stream().map(ClienteMapper::domainToDTO).toList();
    }

    public static List<Cliente> dTOToDomainList(List<ClienteDTO> clientesDTO) {
        return clientesDTO.stream().map(ClienteMapper::dTOToDomain).toList();
    }
}
