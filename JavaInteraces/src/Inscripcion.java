public class Inscripcion {
    private int idInscripcion;
    private String fechaInscripcion;
    private Estudiante estudiante;
    private Curso curso;
    public Inscripcion(int idInscripcion, String fechaInscripcion, Estudiante estudiante, Curso curso) {
        this.idInscripcion = idInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.estudiante = estudiante;
        this.curso = curso;
    }
    public int getIdInscripcion() {
        return idInscripcion;
    }
    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }
    public String getFechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
