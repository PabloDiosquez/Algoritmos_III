import java.util.ArrayList;

public class Fiuba {

    private ArrayList<Carrera> carreras;
    private ArrayList<Alumno> alumnos;

    public Fiuba(){
        carreras = new ArrayList<>();
        alumnos = new ArrayList<>();
    }

    public void crearCarrera(int codigo, String nombre, int creditosTotales){
        Carrera carrera = new Carrera(codigo, nombre, creditosTotales);
        carreras.add(carrera);
    }

    public Alumno crearAlumno(int codigo, String nomYApell){
        Alumno alumno = new Alumno(codigo, nomYApell);
        this.alumnos.add(alumno);
        return alumno;
    }

    public boolean inscribirAlumno(int legajo, String nomYAPell, int codigo){
        Alumno alumno = this.crearAlumno(legajo, nomYAPell);
        Carrera carrera = this.buscarCarrera(codigo);
        if (carrera != null){
            carrera.agregarAlumno(alumno);
            alumno.agregarCarrera(carrera);
            alumnos.add(alumno);
            return true;
        }
        return false;
    }

    public Carrera buscarCarrera(int codigo){
        for (Carrera carrera: carreras) {
            if (carrera.getCodigo() == codigo) {
                return carrera;
            }
        }
        return null;
    }

    public Alumno buscarAlumno(int legajo){
        for (Alumno alumno: alumnos) {
            if(alumno.getLegajo() == legajo){
                return alumno;
            }
        }
        return null;
    }

    public boolean aprobarMateria(int legajo, int codCarrera, int codMateria){
        Alumno alumno = buscarAlumno(legajo);
        if(alumno == null){
            return false;
        }
        Materia materia = alumno.buscarMateria(codCarrera, codMateria);
        if (materia != null){
            alumno.getAprobadas().add(materia);
            return true;
        }
        return false;
    }
}
