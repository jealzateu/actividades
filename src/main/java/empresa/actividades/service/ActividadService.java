package empresa.actividades.service;

import empresa.actividades.model.Actividad;

import java.util.List;

public interface ActividadService {

    List<Actividad> buscarTodas();

    Actividad guardar(Actividad actividad);

    Actividad buscarPorId(Long id);

    Actividad actualizar(Long id, Actividad actividad);

    void eliminar(Long id);
}
