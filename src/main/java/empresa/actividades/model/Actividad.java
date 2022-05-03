package empresa.actividades.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actividades")
@Setter
@Getter
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado")
    public String estado;

    @Column(name = "fecha")
    public String fecha;

    @Column(name = "dias_retraso")
    public int diasRetraso;

    @ManyToOne
    @JoinColumn(name = "id_empleado_asignado")
    public Empleado empleadoAsignado;

}
