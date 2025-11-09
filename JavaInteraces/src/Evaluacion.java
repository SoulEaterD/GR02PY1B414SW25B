import java.util.List;

public class Evaluacion {
    
    private String titulo;
    private List<Pregunta> preguntas;
    private double calificacion;

    public Evaluacion(String titulo, List<Pregunta> preguntas, double calificacion) {
        this.titulo = titulo;
        this.preguntas = preguntas;
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
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
