package empresa.actividades.controller;

import empresa.actividades.model.Empleado;
import empresa.actividades.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Empleado>> get() {
        List<Empleado> empleados = empleadoService.buscarTodos();
        return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
    }

}
