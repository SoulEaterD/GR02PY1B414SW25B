import java.util.ArrayList;
import java.util.List;

public class Evaluacion {

    private String titulo;
    private List<Pregunta> preguntas;
    private double calificacion;


    public Evaluacion rendirEvaluacion() {
        int respuestasCorrectas = 0;
        for (Pregunta pregunta : preguntas) {
            String respuestaEstudiante = "Opción D"; // Simulación de respuesta
            if (respuestaEstudiante.equals(pregunta.getRespuestaCorrecta())) {
                respuestasCorrectas++;
            }
        }
        calificacion = ((double) respuestasCorrectas / preguntas.size()) * 100;
        System.out.println("Calificación obtenida: " + calificacion);
        return this;
    }

    public Evaluacion(String titulo, List<Pregunta> preguntas, double calificacion) {
        this.titulo = titulo;
        this.preguntas = preguntas;
        this.calificacion = calificacion;
    }

    public List<Pregunta> crearPreguntas(int numeroPreguntas) {
        if (preguntas == null) {
            preguntas = new ArrayList<>(); 
        }

        for (int i = 0; i < numeroPreguntas; i++) {
            Pregunta pregunta = new Pregunta(i + 1, null, null, null);
            String enunciado = "Pregunta " + (i + 1);
            List<String> opciones = pregunta.crearOpciones();
            String respuestaCorrecta = "Opción D";
            pregunta.setEnunciado(enunciado);
            pregunta.setRespuestaCorrecta(respuestaCorrecta);
            pregunta.setOpciones(opciones);
            preguntas.add(pregunta);
        }
        return preguntas;
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
