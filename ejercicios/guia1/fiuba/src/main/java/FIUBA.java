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

    public String crearCarrera(String nombre) {
        if (buscarCarrera(c -> c.getNombre().equalsIgnoreCase(nombre)) != null) {
            return String.format("La carrera '%s' ya existe.", nombre);
        }

        Carrera carrera = Carrera.builder()
                .codigo(generarCodigo(5))
                .nombre(nombre.trim())
                .build();

        carreras.add(carrera);
        return String.format("Carrera Cod: %s creada exitosamente.", carrera.getCodigo());
    }

    public String quitarCarrera(String nombre) {
        Carrera carrera = buscarCarrera(c -> c.getNombre().equalsIgnoreCase(nombre));
        if (carrera == null) {
            return String.format("La carrera '%s' no existe en FIUBA.", nombre);
        }

        carreras.remove(carrera);
        return String.format("Carrera Cod: %s borrada exitosamente.", carrera.getCodigo());
    }


    private Carrera buscarCarrera(Predicate<Carrera> criterio){
        for (Carrera carrera: carreras) {
            if(criterio.test(carrera)){
                return carrera;
            }
        }
        return null;
    }

    // ------------------- ALUMNOS -------------------

    public String crearAlumno(String nombre, String apellido) {
        if (esAlumno(alumno -> alumno.getNombre().equalsIgnoreCase(nombre) &&
                alumno.getApellido().equalsIgnoreCase(apellido))) {
            return "El alumno ya está registrado.";
        }
        Alumno alumno = Alumno.builder()
                .legajo(generarLegajo())
                .nombre(nombre.trim())
                .apellido(apellido.trim())
                .build();
        alumnos.add(alumno);
        return String.format("Alumno '%s, %s' creado exitosamente.",
                alumno.getApellido(), alumno.getNombre());
    }

    public String quitarAlumno(String nombre, String apellido) {
        if (!esAlumno(alumno -> alumno.getNombre().equalsIgnoreCase(nombre) &&
                alumno.getApellido().equalsIgnoreCase(apellido))) {
            return String.format("El alumno '%s, %s' no está registrado.", apellido, nombre);
        }
        Alumno alumno = buscarAlumno(a -> a.getNombre().equalsIgnoreCase(nombre) &&
                a.getApellido().equalsIgnoreCase(apellido));
        alumnos.remove(alumno);
        return String.format("Alumno '%s, %s' removido exitosamente.", alumno.getApellido(), alumno.getNombre());
    }

    public String inscribirAlumno(String nombre, String apellido, String nombreCarrera) {
        if (!esAlumno(alumno -> alumno.getNombre().equalsIgnoreCase(nombre) &&
                alumno.getApellido().equalsIgnoreCase(apellido))) {
            return String.format("El alumno '%s, %s' no está registrado.", apellido, nombre);
        }

        Alumno alumno = buscarAlumno(a -> a.getNombre().equalsIgnoreCase(nombre) &&
                a.getApellido().equalsIgnoreCase(apellido));
        if (alumno == null) {
            return String.format("Hubo un problema al buscar al alumno '%s, %s'.", apellido, nombre);
        }

        Carrera carrera = buscarCarrera(c -> c.getNombre().equalsIgnoreCase(nombreCarrera));
        if (carrera == null) {
            return String.format("La carrera '%s' no está registrada.", nombreCarrera);
        }

        alumno.agregarCarrera(carrera);
        return String.format("Alumno '%s, %s' inscrito exitosamente en la carrera '%s'.",
                alumno.getApellido(), alumno.getNombre(), carrera.getNombre());
    }

    public String marcarMateriaAprobada(int legajoAlumno, String codCarrera, String codigoMateria) {
        if (!esAlumno(alumno -> alumno.getLegajo() == legajoAlumno)) {
            return String.format("El legajo %d no corresponde a un alumno registrado.", legajoAlumno);
        }

        Alumno alumno = buscarAlumno(a -> a.getLegajo() == legajoAlumno);
        Carrera carrera = buscarCarrera(c -> c.getNombre().equals(codCarrera));

        if (carrera == null) {
            return String.format("La carrera '%s' no forma parte de la oferta académica de FIUBA.", codCarrera);
        }

        if (!alumno.esAlumnoCarrera(codCarrera)) {
            return String.format("El alumno con legajo %d no está inscripto en la carrera '%s'.", legajoAlumno, codCarrera);
        }

        if (carrera.buscarMateria(codigoMateria) == null) {
            return String.format("La materia con código '%s' no se encuentra en la carrera '%s'.", codigoMateria, codCarrera);
        }

        alumno.aprobarMateria(carrera.getNombre(), carrera.buscarMateria(codigoMateria));
        return String.format("La materia con código '%s' ha sido marcada como aprobada para el alumno con legajo %d en la carrera '%s'.",
                codigoMateria, legajoAlumno, codCarrera);
    }

    public String consultarEstadoCarrera(int legajo, String codigo){
        Alumno alumno = buscarAlumno(a -> a.getLegajo() == legajo);
        return alumno.estadoCarrera(codigo);
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

    // ----------------- AUXILIARES -------------------


    private static String generarCodigo(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringAleatorio = new StringBuilder(longitud);
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            stringAleatorio.append(caracteres.charAt(indice));
        }

        return stringAleatorio.toString();
    }

    private static int generarLegajo(){
        return new Random().nextInt(1000);
    }

}
