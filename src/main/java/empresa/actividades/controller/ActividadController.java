package empresa.actividades.controller;

import empresa.actividades.model.Actividad;
import empresa.actividades.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    ActividadService actividadService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Actividad>> get() {
        List<Actividad> actividades = actividadService.buscarTodas();
        return new ResponseEntity<List<Actividad>>(actividades, HttpStatus.OK);
    }

    @RequestMapping("/guardar")
    public ResponseEntity<Actividad> save(@RequestBody Actividad actividad) {

        Actividad actividadGuardar = actividadService.guardar(actividad);
        return new ResponseEntity<Actividad>(actividadGuardar, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Actividad> get(@PathVariable("id") Long id) {
        Actividad actividad = actividadService.buscarPorId(id);
        return new ResponseEntity<Actividad>(actividad, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Actividad> put(@PathVariable("id") Long id, @RequestBody Actividad actividad) {
        Actividad actividadActualizada = actividadService.actualizar(id, actividad);
        return new ResponseEntity<Actividad>(actividadActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        actividadService.eliminar(id);
        return new ResponseEntity<String>("Actividad eliminada", HttpStatus.OK);
    }
}
