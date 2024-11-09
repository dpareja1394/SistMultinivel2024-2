package co.edu.usbcali.storeusb.repository;

import co.edu.usbcali.storeusb.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Boolean existsByNombreAndEstado(String nombre, String estado);

    Boolean existsByIdNotAndNombre(Integer id, String nombre);

}
