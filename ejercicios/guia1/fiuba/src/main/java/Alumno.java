import java.util.ArrayList;

public class Alumno {
    private int legajo;
    private String nomYAPell;
    private ArrayList<Carrera> carreras;
    private ArrayList<Materia> aprobadas;

    public Alumno(int legajo, String nomYAPell) {
        this.legajo = legajo;
        this.nomYAPell = nomYAPell;
        carreras = new ArrayList<>();
        aprobadas = new ArrayList<>();
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNomYAPell() {
        return nomYAPell;
    }

    public void setNomYAPell(String nomYAPell) {
        this.nomYAPell = nomYAPell;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public ArrayList<Materia> getAprobadas() {
        return aprobadas;
    }

    public void agregarCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }

    public void agregarMateriaAprobada(Materia materia){
        aprobadas.add(materia);
    }

    public Carrera buscarCarrera(int codigo){
        for (Carrera carrera: carreras) {
            if (carrera.getCodigo() == codigo){
                return carrera;
            }
        }
        return null;
    }

    public Materia buscarMateria(int codCarrera, int codMateria){
        Carrera carrera = buscarCarrera(codCarrera);
        if (carrera == null){
            return null;
        }
        for (Materia materia: carrera.getMaterias()) {
            if(materia.getCodigo() == codMateria){
                return materia;
            }
        }
        return null;
    }

    public String consultarEstado() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNomYAPell());
        if(getAprobadas().isEmpty()){
            sb.append("Aún no aprobó ninguna materia.");
            return sb.toString();
        }
        int total = 0;
        sb.append("\nMaterias aprobadas:\n");
        for (Materia materia : getAprobadas()) {
            sb.append(materia.getNombre()).append("\n");
            total += materia.getCreditos();
        }
        sb.append(String.format("Créditos totales: %d", total));
        return sb.toString();
    }
}