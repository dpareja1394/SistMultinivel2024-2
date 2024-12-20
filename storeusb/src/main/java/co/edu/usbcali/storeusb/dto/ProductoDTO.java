package co.edu.usbcali.storeusb.dto;

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
public class ProductoDTO {
    private Integer id;

    @JsonProperty("categoria_id")
    private Integer categoriaId;
    private String referencia;
    private String nombre;
    private String descripcion;

    @JsonProperty("precio_unitario")
    private BigDecimal precioUnitario;

    @JsonProperty("unidades_disponibles")
    private BigDecimal unidadesDisponibles;
    private String estado;

    @JsonProperty("categoria_nombre")
    private String categoriaNombre;
}
