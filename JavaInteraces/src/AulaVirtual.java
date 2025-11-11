import java.util.ArrayList;
import java.util.List;

public class AulaVirtual {

    List<Curso> cursosDisponibles;
    Docente docenteCurso;
    List<Estudiante> estudiantesRegistrados;

    public AulaVirtual(Docente docenteCurso) {
        this.cursosDisponibles = new ArrayList<>();
        this.docenteCurso = docenteCurso;
        this.estudiantesRegistrados = new ArrayList<>();
    }

    public List<Material> getMaterial(Curso curso) {
        return curso.getMaterial();
    }

    public List<Estudiante> getEstudianteCurso(Curso curso) {
        return curso.getEstudiantes();
    }

    public Curso crearCurso(int idCurso, String nombreCurso, String descripcionCurso, Docente docente) {
        Curso c1 = new Curso(idCurso, nombreCurso, descripcionCurso, docente);
        cursosDisponibles.add(c1);
        return c1;
    }

    public List<Curso> getCursosDisponibles() {
        return cursosDisponibles;
    }

    public void setCursosDisponibles(List<Curso> cursosDisponibles) {
        this.cursosDisponibles = cursosDisponibles;
    }

    public Docente getDocentesDisponibles() {
        return docenteCurso;
    }

    public void setDocentesDisponibles(Docente docenteCurso) {
        this.docenteCurso = docenteCurso;
    }

    public List<Estudiante> getEstudiantesRegistrados() {
        return estudiantesRegistrados;
    }

    public void setEstudiantesRegistrados(List<Estudiante> estudiantesRegistrados) {
        this.estudiantesRegistrados = estudiantesRegistrados;
    }

}
