package co.edu.usbcali.storeusb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String estado;
}
