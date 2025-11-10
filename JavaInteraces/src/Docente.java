import java.util.List;

public class Docente {
    
    private int idDocente;
    private String nombreDocente;
    private String correoDocente;
    private String contraseniaDocente;
    private boolean permisosDocente;
    private List<Curso> cursosDocente;

    //los metodos se van a implementar conjuntamente la interfaz 
    private List<Curso> cursosCreados;
    public void CrearCurso(int idCurso,  String nombreCurso, String descripcionCurso, Docente docente, List<Inscripcion> inscripcion, List<Estudiante> estudiantes, List<Material> material, List<Evaluacion> evaluacion){
        Curso c1 = new Curso(idCurso, nombreCurso, descripcionCurso, docente, inscripcion, estudiantes, material, evaluacion);
        cursosCreados.add(c1);
    }

    public Curso seleccionarCurso(Estudiante estudiante){
        Curso c1 = cursosCreados.get(0);
        c1.solicitarInscripcion(estudiante);
        return c1;
    }

    public List<Curso> getCursosCreados() {
        return cursosCreados;
    }

    public void setCursosCreados(List<Curso> cursosCreados) {
        this.cursosCreados = cursosCreados;
    }

    public Docente(String nombreDocente, int idDocente, String correoDocente, String contraseniaDocente, boolean permisosDocente, List<Curso> cursosDocente) {
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

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
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
