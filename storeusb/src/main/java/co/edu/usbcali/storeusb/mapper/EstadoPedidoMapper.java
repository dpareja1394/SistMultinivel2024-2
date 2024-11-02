package co.edu.usbcali.storeusb.mapper;

import co.edu.usbcali.storeusb.domain.EstadoPedido;
import co.edu.usbcali.storeusb.dto.EstadoPedidoDTO;

import java.util.List;

public class EstadoPedidoMapper {

    public static EstadoPedidoDTO domainToDTO(EstadoPedido estadoPedido) {
        return EstadoPedidoDTO.builder()
                .id(estadoPedido.getId())
                .descripcion(estadoPedido.getDescripcion())
                .build();
    }

    public static EstadoPedido dTOToDomain(EstadoPedidoDTO estadoPedidoDTO) {
        return EstadoPedido.builder()
                .id(estadoPedidoDTO.getId())
                .descripcion(estadoPedidoDTO.getDescripcion())
                .build();
    }

    public static List<EstadoPedidoDTO> domainToDTOList(List<EstadoPedido> estadoPedidos) {
        return estadoPedidos.stream().map(EstadoPedidoMapper::domainToDTO).toList();
    }

    public static List<EstadoPedido> dTOToDomainList(List<EstadoPedidoDTO> estadoPedidosDTO) {
        return estadoPedidosDTO.stream().map(EstadoPedidoMapper::dTOToDomain).toList();
    }
}
