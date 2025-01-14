import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
public class Carrera {

    @Getter
    private @NonNull Integer codigo;

    @Getter
    private @NonNull String nombre;

    @Builder.Default
    @ToString.Exclude
    private List<Materia> materias = new ArrayList<>();

    public void agregarMateria(Materia materia){
        materias.add(materia);
    }
    public int obtenerCreditosTotales(){
        int creditosTotales = 0;
        for (Materia materia: materias) {
            creditosTotales += materia.getCreditos();
        }
        return creditosTotales;
    }

    public Materia buscarMateria(Integer codigo){
        return new Buscador<Materia>(materia -> materia.getCodigo().equals(codigo))
                .buscar(materias);
    }
}
