import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Builder
public class FIUBA {
    @Builder.Default
    private List<Carrera> carreras = new ArrayList<>();

    @Builder.Default
    private List<Alumno> alumnos = new ArrayList<>();


    private Carrera buscarCarrera(Predicate<Carrera> criterio){
        for (Carrera carrera: carreras) {
            if(criterio.test(carrera)){
                return carrera;
            }
        }
        return null;
    }

    private boolean esAlumno(Predicate<Alumno> criterio){
        for (Alumno alumno: alumnos) {
            if(criterio.test(alumno)){
                return true;
            }
        }
        return false;
    }

    private Alumno buscarAlumno(Predicate<Alumno> criterio){
        for (Alumno alumno: alumnos) {
            if(criterio.test(alumno)){
                return alumno;
            }
        }
        return null;
    }
}
