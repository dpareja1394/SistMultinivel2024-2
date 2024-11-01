package co.edu.usbcali.storeusb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Integer id;
    private Integer clienteId;
    private Integer estadoPedidoId;
    private Instant fecha;
    private BigDecimal total;
}
