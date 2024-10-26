package co.edu.usbcali.storeusb.domain;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    private Categoria categoria;

    @Column(nullable = false, length = 10)
    private String referencia;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column
    private String descripcion;

    @Column(nullable = false, precision = 19, scale = 2, name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 19, scale = 2, name = "unidades_disponibles")
    private BigDecimal unidadesDisponibles;

    @Column(nullable = false, length = 1)
    private String estado;
}
