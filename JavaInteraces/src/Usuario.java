public class Usuario {

    private String id;
    private String correo;
    private String contrasenia;
    private boolean permisos;

    public Usuario(String id, String correo, String contrasenia, boolean permisos) {
        this.id = id;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.permisos = permisos;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public void setPermisos(boolean permisos) {
        this.permisos = permisos;
    }
    

}
