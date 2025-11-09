import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    // Layout y contenedor principal
    private CardLayout layout;
    private JPanel contenedor;

    public Main() {
        // Define ventana
        super("Aula virtual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Esta funcion devuelve el tamanio de cada computadora y eso se lo asigna
        // despues
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(pantalla);
        setLocationRelativeTo(null); // Centrar ventana
        setResizable(true);
        // Inicializar CardLayout
        layout = new CardLayout();
        contenedor = new JPanel(layout);

        // Crear las pantallas
        JPanel pantallaLogin = crearPantallaLogin();
        JPanel pantallaMenu = crearPantallaMenu();
        JPanel pantallaConfig = crearPantallaConfig();

        // Agregar las pantallas al contenedor
        contenedor.add(pantallaLogin, "login");
        contenedor.add(pantallaMenu, "menu");
        contenedor.add(pantallaConfig, "config");

        add(contenedor);
        setVisible(true);
    }

    private JPanel crearPantallaLogin() {
        // Panel principal con dos columnas
        JPanel panel = new JPanel(new GridLayout(1, 2));
        // Se define la imagen y abajo el tamanio
        ImageIcon imagenIzquierda = new ImageIcon(getClass().getResource("/img/poli.jpeg"));
        // Escalar la imagen al tamaño del panel
        Image imgEscalada = imagenIzquierda.getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);
        // Se usa el contenedor de la izquierda
        JLabel lblIzquierda = new JLabel(new ImageIcon(imgEscalada));
        lblIzquierda.setHorizontalAlignment(SwingConstants.CENTER);
        lblIzquierda.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(lblIzquierda);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBackground(Color.WHITE); // fondo blanco
        panel.add(panelDerecho);

        // Logo arriba
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.WHITE);
        ImageIcon logo = new ImageIcon(getClass().getResource("/img/LOGO_EPN.jpg"));
        Image logoEscalado = logo.getImage().getScaledInstance(200, 125, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(logoEscalado));
        panelLogo.add(lblLogo);
        panelDerecho.add(panelLogo, BorderLayout.NORTH);

        // Formulario en el centro
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUsuario = new JLabel("Usuario:");
        JTextField txtUsuario = new JTextField(15);
        JLabel lblClave = new JLabel("Contraseña:");
        JPasswordField txtClave = new JPasswordField(15);
        JButton btnIngresar = new JButton("Ingresar");

        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        lblClave.setFont(new Font("Arial", Font.PLAIN, 16));

        btnIngresar.setBackground(new Color(30, 144, 255));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 16));

        // Posicionar campos
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(lblUsuario, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(lblClave, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtClave, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelFormulario.add(btnIngresar, gbc);

        panelDerecho.add(panelFormulario, BorderLayout.CENTER);

        // Acción del botón
        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String clave = new String(txtClave.getPassword());
            if (usuario.equals("admin") && clave.equals("123")) {
                layout.show(contenedor, "menu");
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        });

        return panel;
    }

    // -------------------------
    // PANTALLA DE MENÚ PRINCIPAL
    // -------------------------
    private JPanel crearPantallaMenu() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Menú principal", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        JButton btnConfig = new JButton("Ir a Configuración");
        JButton btnSalir = new JButton("Cerrar sesión");

        btnConfig.addActionListener(e -> layout.show(contenedor, "config"));
        btnSalir.addActionListener(e -> layout.show(contenedor, "login"));

        JPanel botones = new JPanel();
        botones.add(btnConfig);
        botones.add(btnSalir);

        panel.add(botones, BorderLayout.CENTER);
        return panel;
    }

    // -------------------------
    // PANTALLA DE CONFIGURACIÓN
    // -------------------------
    private JPanel crearPantallaConfig() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Configuración del sistema", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(e -> layout.show(contenedor, "menu"));

        JPanel centro = new JPanel();
        centro.add(new JLabel("Aquí puedes poner tus opciones de configuración"));
        panel.add(centro, BorderLayout.CENTER);
        panel.add(btnVolver, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
