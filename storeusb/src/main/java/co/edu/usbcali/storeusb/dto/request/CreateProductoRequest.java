package co.edu.usbcali.storeusb.dto.request;

import co.edu.usbcali.storeusb.utils.validation.ProductoMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @JsonProperty("categoria_id")
    @NotNull(message = ProductoMessage.CATEGORIA_ID_NO_NULA)
    private Integer categoriaId;

    @NotNull(message = ProductoMessage.REFERENCIA_NO_NULA)
    @Size(max = 10, min = 3, message = ProductoMessage.VALIDACION_REFERENCIA_CARACTERES)
    private String referencia;

    @NotNull(message = ProductoMessage.NOMBRE_NO_NULO)
    @Size(max = 50, min = 3, message = ProductoMessage.VALIDACION_NOMBRE_CARACTERES)
    private String nombre;

    @Size(max = 255, message = ProductoMessage.VALIDACION_DESCRIPCION_CARACTERES)
    private String descripcion;

    @JsonProperty("precio_unitario")
    @NotNull(message = ProductoMessage.PRECIO_UNITARIO_NO_NULO)
    private BigDecimal precioUnitario;

    @JsonProperty("unidades_disponibles")
    @NotNull(message = ProductoMessage.UNIDADES_DISPONIBLES_NO_NULA)
    private BigDecimal unidadesDisponibles;
}
