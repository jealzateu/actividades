package empresa.actividades.service;

import empresa.actividades.model.Empleado;
import empresa.actividades.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepository.findAll();
    }

}
