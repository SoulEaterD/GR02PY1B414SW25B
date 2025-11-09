import java.util.List;

public class Estudiante {

    private String nombreEstudiante;
    private int idEstudiante;
    private String correoEstudiante;
    private String contraseniaEstudiante;
    private boolean permisosEstudiante;
    private List<Curso> cursosEstudiante;

    public Estudiante(String nombreEstudiante, int idEstudiante, String correoEstudiante, String contraseniaEstudiante, List<Curso> cursosEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        this.idEstudiante = idEstudiante;
        this.correoEstudiante = correoEstudiante;
        this.contraseniaEstudiante = contraseniaEstudiante;
        this.permisosEstudiante = false;
        this.cursosEstudiante = cursosEstudiante;
    }
    
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCorreoEstudiante() {
        return correoEstudiante;
    }

    public void setCorreoEstudiante(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }

    public String getContraseniaEstudiante() {
        return contraseniaEstudiante;
    }

    public void setContraseniaEstudiante(String contraseniaEstudiante) {
        this.contraseniaEstudiante = contraseniaEstudiante;
    }

    public boolean isPermisosEstudiante() {
        return permisosEstudiante;
    }

    public List<Curso> getCursosEstudiante() {
        return cursosEstudiante;
    }

    public void setPermisosEstudiante(boolean permisosEstudiante) {
        this.permisosEstudiante = permisosEstudiante;
    }

    public void setCursosEstudiante(List<Curso> cursosEstudiante) {
        this.cursosEstudiante = cursosEstudiante;
    }
        
}
