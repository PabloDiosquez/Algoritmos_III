import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.*;

@Builder
@ToString
public class Alumno {
    @Getter
    private @NonNull Integer legajo;

    @Getter
    private @NonNull String nombre;

    @Builder.Default
    private List<Carrera> carreras = new ArrayList<>();

    @Builder.Default
    private HashMap<String, List<Materia>> materiasAprobadas = new HashMap<>();

    public void agregarCarrera(Carrera carrera){
        carreras.add(carrera);
    }

    public void aprobarMateria(String codCarrera, Materia materia){
        materiasAprobadas.get(codCarrera).add(materia);
    }


}