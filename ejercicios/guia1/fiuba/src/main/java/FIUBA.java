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
                    .codigo(generarNumero())
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

    private Carrera buscarCarrera(Integer codigo){
        return new Buscador<Carrera>(carrera -> carrera.getCodigo() == codigo)
                .buscar(carreras);
    }

    private Materia buscarMateria(Carrera carrera, Integer codigo){
        return carrera.buscarMateria(codigo);
    }

    // ------------------- ALUMNOS -------------------

    private Alumno buscarAlumno(Integer legajo){
        return new Buscador<Alumno>(alumno -> alumno.getLegajo() == legajo)
                .buscar(alumnos);
    }

    // ----------------- AUXILIARES -------------------


    private static int generarNumero(){
        return new Random().nextInt(1000);
    }

}