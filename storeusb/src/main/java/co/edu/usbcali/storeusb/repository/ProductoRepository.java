package co.edu.usbcali.storeusb.repository;

import co.edu.usbcali.storeusb.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findAllByCategoriaId(Integer idCategoria);

}
