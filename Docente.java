import java.util.ArrayList;
import java.util.List;

public class Docente extends Usuario {
    
    private List<Curso> cursosDocente;

    public Docente(String id, String correo, String contrasenia) {
        super(id, correo, contrasenia, true);
        this.cursosDocente = new ArrayList<>();
    }

    public List<Curso> getCursos() {
        return cursosDocente;
    }

    public void setCursos(List<Curso> cursosDocente) {
        this.cursosDocente = cursosDocente;
    }

}