package co.edu.usbcali.storeusb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoPedidoDTO {
    private Integer id;
    private String descripcion;
}
