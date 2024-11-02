package co.edu.usbcali.storeusb.mapper;

import co.edu.usbcali.storeusb.domain.DetallePedido;
import co.edu.usbcali.storeusb.dto.DetallePedidoDTO;

import java.util.List;

public class DetallePedidoMapper {
    public static DetallePedidoDTO domainToDTO(DetallePedido detallePedido) {
        return DetallePedidoDTO.builder()
                .id(detallePedido.getId())
                .pedidoId(detallePedido.getPedido() == null ? null :
                        detallePedido.getPedido().getId())
                .productoId(detallePedido.getProducto() == null ? null:
                        detallePedido.getProducto().getId())
                .cantidad(detallePedido.getCantidad())
                .valor(detallePedido.getValor())
                .estado(detallePedido.getEstado())
                .build();
    }

    public static DetallePedido dTOToDomain(DetallePedidoDTO detallePedidoDTO) {
        return DetallePedido.builder()
                .id(detallePedidoDTO.getId())
                .cantidad(detallePedidoDTO.getCantidad())
                .valor(detallePedidoDTO.getValor())
                .estado(detallePedidoDTO.getEstado())
                .build();
    }

    public static List<DetallePedidoDTO> domainToDTOList(List<DetallePedido> detallePedidos) {
        return detallePedidos.stream().map(DetallePedidoMapper::domainToDTO).toList();
    }

    public static List<DetallePedido> dTOToDomainList(List<DetallePedidoDTO> detallePedidosDTO) {
        return detallePedidosDTO.stream().map(DetallePedidoMapper::dTOToDomain).toList();
    }

}
