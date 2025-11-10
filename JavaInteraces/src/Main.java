import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    private CardLayout layout;
    private JPanel contenedor;
    private List<Curso> cursos = new ArrayList<>();

    public Main() {
        super("Aula Virtual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        contenedor = new JPanel(layout);

        JPanel pantallaLogin = crearPantallaLogin();
        JPanel pantallaAulaDocente = crearPantallaAulaDocente();

        contenedor.add(pantallaLogin, "login");
        contenedor.add(pantallaAulaDocente, "aulaDocente");

        add(contenedor);
        setVisible(true);
    }

    // --------------------------
    // PANTALLA LOGIN
    // --------------------------
    private JPanel crearPantallaLogin() {
        JPanel panelSesion = new JPanel(new GridBagLayout());
        panelSesion.setBackground(new Color(74, 85, 110));
        panelSesion.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));
        panelSesion.setPreferredSize(new Dimension(500, 280));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelSesion.add(lblTitulo, gbc);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblUsuario.setForeground(new Color(220, 225, 240));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelSesion.add(lblUsuario, gbc);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setPreferredSize(new Dimension(220, 35));
        txtUsuario.setBackground(new Color(96, 107, 134));
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setCaretColor(Color.WHITE);
        txtUsuario.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelSesion.add(txtUsuario, gbc);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblContrasena.setForeground(new Color(220, 225, 240));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelSesion.add(lblContrasena, gbc);

        JPasswordField txtContrasena = new JPasswordField();
        txtContrasena.setPreferredSize(new Dimension(220, 35));
        txtContrasena.setBackground(new Color(96, 107, 134));
        txtContrasena.setForeground(Color.WHITE);
        txtContrasena.setCaretColor(Color.WHITE);
        txtContrasena.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelSesion.add(txtContrasena, gbc);

        JButton btnIngresar = new JButton("Iniciar sesión");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setBackground(new Color(237, 87, 97));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelSesion.add(btnIngresar, gbc);

        JPanel fondo = new JPanel(new GridBagLayout());
        fondo.setBackground(new Color(45, 55, 72));
        fondo.add(panelSesion);

        btnIngresar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            if (usuario.equals("Jorge") && contrasena.equals("123")) {
                layout.show(contenedor, "aulaDocente");
            } else if (usuario.equals("Guille") && contrasena.equals("123")) {
                JPanel pantallaEstudiante = crearPantallaAulaEstudiante();
                contenedor.add(pantallaEstudiante, "aulaEstudiante");
                layout.show(contenedor, "aulaEstudiante");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        });

        return fondo;
    }

    // -------------------------------
    // AULA DOCENTE
    // -------------------------------
    private JPanel crearPantallaAulaDocente() {
        JPanel panelAula = new JPanel(new BorderLayout());
        panelAula.setBackground(new Color(45, 55, 72));

        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(74, 85, 110));
        barra.setPreferredSize(new Dimension(0, 60));

        JLabel lblTitulo = new JLabel("Aula Virtual del Docente");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        JButton btnCrearCurso = new JButton("Crear Curso");
        btnCrearCurso.setBackground(new Color(237, 87, 97));
        btnCrearCurso.setForeground(Color.WHITE);
        btnCrearCurso.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCrearCurso.setFocusPainted(false);

        JButton btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setBackground(new Color(96, 107, 134));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.addActionListener(e -> layout.show(contenedor, "login"));

        JPanel contBotones = new JPanel();
        contBotones.setOpaque(false);
        contBotones.add(btnCrearCurso);
        contBotones.add(btnCerrarSesion);

        barra.add(lblTitulo, BorderLayout.WEST);
        barra.add(contBotones, BorderLayout.EAST);
        panelAula.add(barra, BorderLayout.NORTH);

        JPanel panelCursos = new JPanel();
        panelCursos.setLayout(new BoxLayout(panelCursos, BoxLayout.Y_AXIS));
        panelCursos.setBackground(new Color(74, 85, 110));
        panelCursos.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 200));

        JScrollPane scroll = new JScrollPane(panelCursos);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        panelAula.add(scroll, BorderLayout.CENTER);

        btnCrearCurso.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del curso:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                Curso nuevoCurso = new Curso(cursos.size() + 1, nombre, "", null, null, null, null, null);
                cursos.add(nuevoCurso);

                JButton btnCurso = new JButton(nombre);
                btnCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
                btnCurso.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
                btnCurso.setFont(new Font("Segoe UI", Font.BOLD, 18));
                btnCurso.setBackground(new Color(96, 107, 134));
                btnCurso.setForeground(Color.WHITE);
                btnCurso.setFocusPainted(false);

                btnCurso.addActionListener(ev -> mostrarPaginaCurso(nuevoCurso));

                panelCursos.add(Box.createVerticalStrut(15));
                panelCursos.add(btnCurso);
                panelCursos.revalidate();
                panelCursos.repaint();
            }
        });

        return panelAula;
    }

    // -------------------------------
    // AULA ESTUDIANTE
    // -------------------------------
    private JPanel crearPantallaAulaEstudiante() {
    JPanel panelEstudiante = new JPanel(new BorderLayout());
    panelEstudiante.setBackground(new Color(45, 55, 72));

    // 🔹 Barra superior
    JPanel barra = new JPanel(new BorderLayout());
    barra.setBackground(new Color(74, 85, 110));
    barra.setPreferredSize(new Dimension(0, 60));

    JLabel lblTitulo = new JLabel("Aula Virtual del Estudiante");
    lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
    lblTitulo.setForeground(Color.WHITE);
    lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

    JButton btnCerrarSesion = new JButton("Cerrar sesión");
    btnCerrarSesion.setBackground(new Color(96, 107, 134));
    btnCerrarSesion.setForeground(Color.WHITE);
    btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
    btnCerrarSesion.setFocusPainted(false);
    btnCerrarSesion.addActionListener(e -> layout.show(contenedor, "login"));

    JPanel contBotones = new JPanel();
    contBotones.setOpaque(false);
    contBotones.add(btnCerrarSesion);

    barra.add(lblTitulo, BorderLayout.CENTER);
    barra.add(contBotones, BorderLayout.EAST);

    // 🔹 Panel de cursos
    JPanel panelCursos = new JPanel();
    panelCursos.setBackground(new Color(45, 55, 72));
    panelCursos.setLayout(new BoxLayout(panelCursos, BoxLayout.Y_AXIS));

    for (Curso curso : cursos) {
        JButton btnCurso = new JButton(curso.getNombreCurso());
        btnCurso.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnCurso.setForeground(Color.WHITE);
        btnCurso.setBackground(new Color(20, 20, 55));
        btnCurso.setFocusPainted(false);
        btnCurso.setBorder(BorderFactory.createLineBorder(new Color(20, 20, 55), 2, true));
        btnCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCurso.setMaximumSize(new Dimension(600, 60));
        btnCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelCursos.add(Box.createVerticalStrut(15));
        panelCursos.add(btnCurso);
    }

    JScrollPane scroll = new JScrollPane(panelCursos);
    scroll.setBorder(null);
    scroll.setBackground(new Color(45, 55, 72));
    scroll.getViewport().setBackground(new Color(45, 55, 72));

    // 🔹 Agregamos la barra y el contenido principal
    panelEstudiante.add(barra, BorderLayout.NORTH);
    panelEstudiante.add(scroll, BorderLayout.CENTER);

    return panelEstudiante;
    }

    // -------------------------------
    // PÁGINA DEL CURSO
    // -------------------------------
    private void mostrarPaginaCurso(Curso curso) {
        JPanel panelCurso = new JPanel(new BorderLayout());
        panelCurso.setBackground(new Color(45, 55, 72));

        JLabel lblCurso = new JLabel(curso.getNombreCurso(), SwingConstants.CENTER);
        lblCurso.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblCurso.setForeground(Color.WHITE);
        lblCurso.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        panelCurso.add(lblCurso, BorderLayout.NORTH);

        JPanel panelOpciones = new JPanel(new GridLayout(1, 3, 90, 50));
        panelOpciones.setBackground(new Color(45, 55, 72));
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(220, 220, 220, 220));

        String[] opciones = {"Materiales", "Evaluaciones", "Registro de Notas"};
        for (String opcion : opciones) {
            JButton btn = new JButton(opcion);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 20));
            btn.setForeground(Color.WHITE);
            btn.setBackground(new Color(237, 87, 97));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
            panelOpciones.add(btn);
        }

        panelCurso.add(panelOpciones, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(237, 87, 97));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(e -> layout.show(contenedor, "aulaDocente"));
        panelCurso.add(btnVolver, BorderLayout.SOUTH);

        contenedor.add(panelCurso, "paginaCurso_" + curso.getIdCurso());
        layout.show(contenedor, "paginaCurso_" + curso.getIdCurso());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
