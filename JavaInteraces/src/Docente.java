public class Docente {
    private String nombre;
    private int idDocente;
    private String correo;
    private String contrasenia;
    private String especialidad;
    private boolean permisos;

    public Docente(String nombre, int idDocente, String correo, String contrasenia, String especialidad,
            boolean permisos) {
        this.nombre = nombre;
        this.idDocente = idDocente;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.especialidad = especialidad;
        this.permisos = permisos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdDocente() {
        return idDocente;
    }
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
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
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public boolean isPermisos() {
        return permisos;
    }
    public void setPermisos(boolean permisos) {
        this.permisos = permisos;
    }
}
