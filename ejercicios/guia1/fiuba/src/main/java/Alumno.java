import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Builder
@ToString
public class Alumno {
    @Getter
    private @NonNull int legajo;

    @Getter
    private @NonNull String nombre;

    @Getter
    private @NonNull String apellido;

    @Builder.Default
    private List<Carrera> carreras = new ArrayList<>();

    @Builder.Default
    private HashMap<String, List<Materia>> materiasAprobadas = new HashMap<>();

    public void agregarCarrera(Carrera carrera){
        carreras.add(carrera);
    }

    public void aprobarMateria(String carrera, Materia materia){
        materiasAprobadas.get(carrera).add(materia);
    }

    public boolean esAlumnoCarrera(String nombreCarrera){
        for (Carrera carrera: carreras) {
            if(carrera.getNombre().equals(nombreCarrera)){
                return true;
            }
        }
        return false;
    }
}