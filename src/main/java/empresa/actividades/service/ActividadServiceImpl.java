package empresa.actividades.service;

import empresa.actividades.model.Actividad;
import empresa.actividades.model.Empleado;
import empresa.actividades.repository.ActividadRepository;
import empresa.actividades.repository.EmpleadoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    ActividadRepository actividadRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;


    @Override
    public List<Actividad> buscarTodas() {
        return actividadRepository.findAll();
    }

    @Override
    public Actividad guardar(Actividad actividad) {
        actividadRepository.save(actividad);
        return actividad;
    }

    @Override
    public Actividad buscarPorId(Long id) {
        if (actividadRepository.findById(id).isPresent()) {
            return actividadRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Actividad actualizar(Long id, Actividad actividad) {
        Optional<Actividad> actividadActual = actividadRepository.findById(id);
        if (actividadActual.isEmpty()) {
            return null;
        }
        actividadActual.get().setEstado(actividad.getEstado());
        actividadActual.get().setFecha(actividad.getFecha());
        actividadActual.get().setDiasRetraso(actividad.getDiasRetraso());
        Empleado empleado = empleadoRepository.getById(actividad.getEmpleadoAsignado().getId());
        actividadActual.get().setEmpleadoAsignado(empleado);
        log.info("fecha {}",actividad.getFecha());
        actividadRepository.save(actividadActual.get());
        return actividadActual.get();
    }

    @Override
    public void eliminar(Long id) {
        Actividad actividad = buscarPorId(id);
        actividadRepository.delete(actividad);
    }
}
