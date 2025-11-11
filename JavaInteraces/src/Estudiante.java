import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {

    private List<Curso> cursosEstudiante;
    private RegistroNotas notasEstudiante;
    private List<Tarea> deberes;
    private int contadorTareaCalificada;

    public void guardarCurso(Curso curso) {
        cursosEstudiante.add(curso);
    }

    public Estudiante(String id, String nombre, String correo, String contrasenia) {
        super(id, nombre, correo, contrasenia, false);
        this.contadorTareaCalificada = 0;
        this.cursosEstudiante = new ArrayList<>();
        this.deberes = new ArrayList<>();
        this.notasEstudiante = new RegistroNotas();
    }

    public List<Curso> getCursosEstudiante() {
        return cursosEstudiante;
    }

    public void setCursosEstudiante(List<Curso> cursosEstudiante) {
        this.cursosEstudiante = cursosEstudiante;
    }

    public RegistroNotas getNotasEstudiante() {
        return notasEstudiante;
    }

    public void setNotasEstudiante(RegistroNotas notasEstudiante) {
        this.notasEstudiante = notasEstudiante;
    }

    public List<Tarea> getDeberes() {
        return deberes;
    }

    public void setDeberes(List<Tarea> deberes) {
        this.deberes = deberes;
    }

    public int getContadorTareaCalificada() {
        return contadorTareaCalificada;
    }

    public void setContadorTareaCalificada(int contadorTareaCalificada) {
        this.contadorTareaCalificada = contadorTareaCalificada;
    }

}