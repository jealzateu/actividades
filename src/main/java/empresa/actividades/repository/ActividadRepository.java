package empresa.actividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import empresa.actividades.model.Actividad;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

}
