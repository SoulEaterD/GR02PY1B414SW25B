import java.util.ArrayList;
import java.util.List;

public class Pregunta {

    private int idPregunta;
    private String enunciado;
    private String respuestaCorrecta;
    private List<String> opciones;
    
    public List<String> crearOpciones() {
        if (opciones == null) {
            opciones = new ArrayList<>(); 
        }
        for (int i = 0; i < 4; i++) {
            opciones.add((char)('A' + i)+ "opcion");
        }
        return opciones;
    }
    public Pregunta(int idPregunta, String enunciado, String respuestaCorrecta, List<String> opciones) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.opciones = opciones;
    }
    
    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public List<String> getOpciones() {
        return opciones;
    }
    
    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }
    public Object getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
