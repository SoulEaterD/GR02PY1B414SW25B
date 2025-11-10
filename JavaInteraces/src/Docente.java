import java.util.List;

public class Docente {
    
    private String idDocente;
    private String nombreDocente;
    private String correoDocente;
    private String contraseniaDocente;
    private boolean permisosDocente;
    private List<Curso> cursosDocente;

    //los metodos se van a implementar conjuntamente la interfaz 

    public Docente(String nombreDocente, String idDocente, String correoDocente, String contraseniaDocente, boolean permisosDocente, List<Curso> cursosDocente) {
        this.nombreDocente = nombreDocente;
        this.idDocente = idDocente;
        this.correoDocente = correoDocente;
        this.contraseniaDocente = contraseniaDocente;
        this.permisosDocente = permisosDocente;
        this.cursosDocente = cursosDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombre) {
        this.nombreDocente = nombre;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public String getCorreoDocente() {
        return correoDocente;
    }

    public void setCorreoDocente(String correo) {
        this.correoDocente = correo;
    }

    public String getContraseniaDocente() {
        return contraseniaDocente;
    }

    public void setContraseniaDocente(String contrasenia) {
        this.contraseniaDocente = contrasenia;
    }
    
    public boolean isPermisosDocente() {
        return permisosDocente;
    }

    public void setPermisosDocente(boolean permisos) {
        this.permisosDocente = permisos;
    }

    public List<Curso> getCursos() {
        return cursosDocente;
    }

    public void setCursos(List<Curso> cursosDocente) {
        this.cursosDocente = cursosDocente;
    }

}