import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
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

    public void agregarCarrera(Carrera carrera){
        if(carrera != null){
            carreras.add(carrera);
        }
    }

    public boolean quitarCarrera(Carrera carrera){
        return carreras.remove(carrera);
    }
}