package co.edu.usbcali.storeusb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductoRequest {
    private Integer categoriaId;
    private String referencia;
    private String nombre;
    private String descripcion;
    private BigDecimal precioUnitario;
    private BigDecimal unidadesDisponibles;
}
