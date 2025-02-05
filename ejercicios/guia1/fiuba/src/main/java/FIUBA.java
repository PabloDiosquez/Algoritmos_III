import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Builder
public class FIUBA {
    @Builder.Default
    private List<Carrera> carreras = new ArrayList<>();

    @Builder.Default
    private List<Alumno> alumnos = new ArrayList<>();

    // ------------------- CARRERAS -------------------

    public Boolean crearCarrera(Integer codigo, String nombre){
        if(buscarCarrera(codigo) == null){
            Carrera carrera = Carrera.builder()
                    .codigo(codigo)
                    .nombre(nombre)
                    .build();
            return true;
        }
        return false;
    }

    public Boolean quitarCarrera(Integer codigo){
        Carrera carrera = buscarCarrera(codigo);
        if(carrera == null){
            return false;
        }
        carreras.remove(carrera);
        return true;
    }

    // PRE: El legajo y el código corresponden a un alumno y a una carrera existentes respecticvamente.
    public Boolean inscribirACarrera(Integer legajo, Integer codigo){
        Carrera carrera = buscarCarrera(codigo);
        return buscarAlumno(legajo).agregarCarrera(carrera);
    }

    // TODO: Hacer que la dependecia del buscador sea explicita...
    private Carrera buscarCarrera(Integer codigo){
        return new Buscador<Carrera>(carrera -> carrera.getCodigo().equals(codigo))
                .buscar(carreras);
    }

    private Materia buscarMateria(Carrera carrera, Integer codigo){
        return carrera.buscarMateria(codigo);
    }

    // ------------------- ALUMNOS -------------------

    public Boolean crearAlumno(Integer legajo, String nombre){
        if(buscarAlumno(legajo) == null){
            Alumno alumno = Alumno.builder()
                    .legajo(legajo)
                    .nombre(nombre)
                    .build();
            return true;
        }
        return false;
    }
    public Boolean quitarAlumno(Integer legajo){
        Alumno alumno = buscarAlumno(legajo);
        if(alumno == null){
            return false;
        }
        alumnos.remove(alumno);
        return false;
    }

    public String consultarEstadoCarrera(Integer legajo, Integer codigo){
        Carrera carrera = buscarCarrera(codigo);
        return buscarAlumno(legajo).consultarEstado(carrera);
    }

    public Boolean marcarMateriaComoAprobada(Integer legajo, Integer codigoCarrera,
                                             Integer codigoMateria){
        Alumno alumno = buscarAlumno(legajo);
        Carrera carrera = buscarCarrera(codigoCarrera);
        return alumno.aprobarMateria(codigoCarrera, carrera.buscarMateria(codigoMateria));
    }

    private Alumno buscarAlumno(Integer legajo){
        return new Buscador<Alumno>(alumno -> alumno.getLegajo().equals(legajo))
                .buscar(alumnos);
    }
}