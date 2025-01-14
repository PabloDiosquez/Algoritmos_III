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
    private HashMap<Integer, List<Materia>> materiasAprobadas = new HashMap<>();

    public Boolean agregarCarrera(Carrera carrera){
        return carreras.add(carrera);
    }

    public Boolean aprobarMateria(Integer codigoCarrera, Materia materia){
        if(materiasAprobadas.containsKey(codigoCarrera)){
            materiasAprobadas.get(codigoCarrera).add(materia);
            return true;
        }
        return false;
    }


    public String consultarEstado(Carrera carrera) {
        StringBuilder sb = new StringBuilder();
        sb.append(carrera.getNombre());
        for (Materia materia: materiasAprobadas.get(carrera.getCodigo())) {
            sb.append(materia.getNombre());
        }
        return sb.toString();
    }
}