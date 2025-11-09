public class Estudiante {
    private String nombre;
    private int idEstudiante;
    private String correo;
    private String contrasenia;
    private boolean permisos;

    public Estudiante(String nombre, int idEstudiante, String correo, String contrasenia) {
        this.nombre = nombre;
        this.idEstudiante = idEstudiante;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.permisos = false;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public boolean isPermisos() {
        return permisos;
    }
}
