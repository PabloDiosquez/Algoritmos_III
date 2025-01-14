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

    @Getter
    private @NonNull String apellido;

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

    public boolean esAlumnoCarrera(String codCarrera){
        for (Carrera carrera: carreras) {
            if(carrera.getNombre().equals(codCarrera)){
                return true;
            }
        }
        return false;
    }

    public String estadoCarrera(String codigo) {
        if(!esAlumnoCarrera(codigo)){
            return "No es alumno de la carrera";
        }
        StringBuilder sb = new StringBuilder();
        int creditosAct = 0;
        sb.append("Materias aprobadas:");
        for (Materia materia: materiasAprobadas.get(codigo)) {
            sb.append(materia.getNombre());
            creditosAct += materia.getCreditos();
        }
        sb.append(String.format("Créditos actuales: %d", creditosAct));
        return sb.toString();
    }
}