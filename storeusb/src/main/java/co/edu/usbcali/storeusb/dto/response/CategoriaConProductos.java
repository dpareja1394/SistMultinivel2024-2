package co.edu.usbcali.storeusb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaConProductos {
    private String nombre;
    private String descripcion;
    private String estado;
    private List<ProductoResponseCategoriaConProductos> productos;


}
