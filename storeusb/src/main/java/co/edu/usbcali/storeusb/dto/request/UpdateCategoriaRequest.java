package co.edu.usbcali.storeusb.dto.request;

import co.edu.usbcali.storeusb.utils.validation.CategoriaMessage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoriaRequest {
    @NotNull(message = CategoriaMessage.NOMBRE_NO_NULO)
    @NotEmpty(message = CategoriaMessage.NOMBRE_NO_VACIO)
    @Size(max = 10, min = 3, message = CategoriaMessage.VALIDACION_NOMBRE_CARACTERES)
    private String nombre;

    @Size(max = 255, message = CategoriaMessage.VALIDACION_DESCRIPCION_CARACTERES)
    private String descripcion;

}
