import java.util.List;

public class Evaluacion {
    
    private String titulo;
    private List<Pregunta> preguntas;
    private Calificacion calificacion;

    public Evaluacion(String titulo, List<Pregunta> preguntas, Calificacion calificacion) {
        this.titulo = titulo;
        this.preguntas = preguntas;
        this.calificacion = calificacion;
    }
    public Calificacion getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
