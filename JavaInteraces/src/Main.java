import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    private CardLayout layout;
    private JPanel contenedor;
    private JLabel lblTitulo, lblUsuario, lblContrasena;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private Estudiante estudiante1;

    public Main() {

        estudiante1 = new Estudiante("Juan", 1, "juan@suarez", "1234", null);

        //Configuracion general
        setTitle("AULA VIRTUAL");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        layout = new CardLayout();
        contenedor = new JPanel(layout);
    
        //Tarjeta
        JPanel panelSesion = new JPanel(new GridBagLayout());
        panelSesion.setBackground(new Color(74, 85, 110));
        panelSesion.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));
        panelSesion.setPreferredSize(new Dimension(500, 280));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        //Titulo
        lblTitulo = new JLabel("INICIO DE SESIÓN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelSesion.add(lblTitulo, gbc);

        //Usuario
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUsuario.setForeground(new Color(211, 215, 231));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelSesion.add(lblUsuario, gbc);

        txtUsuario = new JTextField();
        txtUsuario.setPreferredSize(new Dimension(180, 30)); 
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelSesion.add(txtUsuario, gbc);

        //Contraseña
        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblContrasena.setForeground(new Color(211, 215, 231));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelSesion.add(lblContrasena, gbc);

        txtContrasena = new JPasswordField();
        txtContrasena.setPreferredSize(new Dimension(180, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelSesion.add(txtContrasena, gbc);

        //Boton ingresar
        btnIngresar = new JButton("INGRESAR");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setBackground(new Color(237, 87, 97));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelSesion.add(btnIngresar, gbc);

        //Panel fondo
        JPanel fondo = new JPanel(new GridBagLayout());
        fondo.setBackground(new Color(45, 55, 72));
        fondo.add(panelSesion);

        contenedor.add(fondo, "panelSesion");
        layout.show(contenedor, "panelSesion");

        //Panel 
        
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contrasena = new String(txtContrasena.getPassword());

                if (usuario.equals(estudiante1.getNombreEstudiante()) &&
                        contrasena.equals(estudiante1.getContraseniaEstudiante())) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        add(contenedor);
    }

    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
