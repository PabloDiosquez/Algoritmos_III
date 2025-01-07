import java.util.ArrayList;

public class Fiuba {
    private ArrayList<Carrera> carreras;
    private ArrayList<Alumno> alumnos;

    public Fiuba(){
        carreras = new ArrayList<>();
        alumnos = new ArrayList<>();
    }

    public void crearCarrera(Carrera carrera){
        carreras.add(carrera);
    }

    public void crearAlumno(int codigo, String nomYApell){
        Alumno alumno = new Alumno(codigo, nomYApell);
        
    }

    public void anotarAlumno(Alumno alumno, Carrera carrera){
        carrera.agregarAlumno(alumno);
        alumno.agregarCarrera(carrera);
        alumnos.add(alumno);
    }

    public void aprobarMateria(Alumno alumno, Materia materia){
        alumno.agregarMateriaAprobada(materia);
    }
}
