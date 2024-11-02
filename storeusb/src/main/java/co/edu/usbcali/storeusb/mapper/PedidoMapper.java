package co.edu.usbcali.storeusb.mapper;

import co.edu.usbcali.storeusb.domain.Pedido;
import co.edu.usbcali.storeusb.dto.PedidoDTO;

import java.util.List;

public class PedidoMapper {

    public static PedidoDTO domainToDTO(Pedido pedido) {
        return PedidoDTO.builder()
                .id(pedido.getId())
                .clienteId(pedido.getCliente() == null ? null :
                        pedido.getCliente().getId())
                .estadoPedidoId(pedido.getEstadoPedido() == null ? null :
                        pedido.getEstadoPedido().getId())
                .fecha(pedido.getFecha())
                .total(pedido.getTotal())
                .build();
    }

    public static Pedido dTOToDomain(PedidoDTO pedidoDTO) {
        return Pedido.builder()
                .id(pedidoDTO.getId())
                .fecha(pedidoDTO.getFecha())
                .total(pedidoDTO.getTotal())
                .build();
    }

    public static List<PedidoDTO> domainToDTOList(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoMapper::domainToDTO).toList();
    }

    public static List<Pedido> dTOToDomainList(List<PedidoDTO> pedidosDTO) {
        return pedidosDTO.stream().map(PedidoMapper::dTOToDomain).toList();
    }


}
