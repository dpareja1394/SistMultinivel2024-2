package co.edu.usbcali.storeusb.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponseCategoriaConProductos {
    private String referencia;
    private String nombre;

    @JsonProperty("precio_unitario")
    private BigDecimal precioUnitario;
}
