package co.edu.usbcali.storeusb.domain;


import java.math.BigDecimal;
import java.time.Instant;

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
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "clie_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "espe_id", referencedColumnName = "id")
    private EstadoPedido estadoPedido;

    @Column(nullable = false)
    private Instant fecha;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal total;
}
