import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {

    private CardLayout layout;
    private JPanel contenedor;

    String usuario;

    private Docente docente = new Docente("1", "docente@docente.com", "123");
    private Estudiante e1 = new Estudiante("1", "juan@patito.com", "123");
    private Estudiante e2 = new Estudiante("2", "maria@patito.com", "123");
    private AulaVirtual aulaVirtual = new AulaVirtual(docente);
    
    public Main() {

        super("Aula Virtual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        contenedor = new JPanel(layout);
        aulaVirtual.getEstudiantesRegistrados().add(e1);
        aulaVirtual.getEstudiantesRegistrados().add(e2);

        JPanel pantallaLogin = crearPantallaLogin();
        JPanel pantallaAulaDocente = crearPantallaAulaDocente();

        contenedor.add(pantallaLogin, "login");
        contenedor.add(pantallaAulaDocente, "aulaDocente");

        add(contenedor);
        setVisible(true);
    }

    // LOGIN
    private JPanel crearPantallaLogin() {

        JPanel panelSesion = new JPanel(new GridBagLayout());
        panelSesion.setBackground(new Color(74, 85, 110));
        panelSesion.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));
        panelSesion.setPreferredSize(new Dimension(500, 280));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
        panelSesion.add(txtContrasena, gbc);

        JButton btnIngresar = new JButton("Iniciar sesión");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setBackground(new Color(237, 87, 97));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelSesion.add(btnIngresar, gbc);

        JPanel fondo = new JPanel(new GridBagLayout());
        fondo.setBackground(new Color(45, 55, 72));
        fondo.add(panelSesion);

        btnIngresar.addActionListener(e -> {

            usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());
            boolean encontrado = false;

            if(usuario.equals(docente.getCorreo()) && contrasena.equals(docente.getContrasenia())) {
                layout.show(contenedor, "aulaDocente");
                encontrado = true;
            } else {
                for(int i = 0; i < aulaVirtual.estudiantesRegistrados.size(); i++) {
                    if(usuario.equals(aulaVirtual.estudiantesRegistrados.get(i).getCorreo()) && contrasena.equals(aulaVirtual.estudiantesRegistrados.get(i).getContrasenia())) {
                        JPanel pantallaEstudiante = crearPantallaAulaEstudiante(aulaVirtual.estudiantesRegistrados.get(i));
                        contenedor.add(pantallaEstudiante, "aulaEstudiante");
                        layout.show(contenedor, "aulaEstudiante");
                        encontrado = true;
                        break;
                    }
                }
            }

            if(!encontrado) {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        });

        return fondo;
    }

    // AULA DOCENTE
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
        panelCursos.setBackground(new Color(45, 55, 72));
        panelCursos.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 200));

        JScrollPane scroll = new JScrollPane(panelCursos);
        scroll.setBorder(null);
        panelAula.add(scroll, BorderLayout.CENTER);

        btnCrearCurso.addActionListener(e -> {

            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del curso:");
            if (nombre != null && !nombre.trim().isEmpty()) {

                Curso nuevoCurso = aulaVirtual.crearCurso(aulaVirtual.getCursosDisponibles().size() + 1, nombre, "", docente);

                for(Estudiante registrado : aulaVirtual.getEstudiantesRegistrados()) {
                    registrado.guardarCurso(nuevoCurso);
                }

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

    // AULA ESTUDIANTE
    private JPanel crearPantallaAulaEstudiante(Estudiante estudiante) {

        JPanel panelEstudiante = new JPanel(new BorderLayout());
        panelEstudiante.setBackground(new Color(45, 55, 72));

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

        JPanel panelCursos = new JPanel();
        panelCursos.setLayout(new BoxLayout(panelCursos, BoxLayout.Y_AXIS));
        panelCursos.setBackground(new Color(45, 55, 72));
        panelCursos.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 200));

        for (Curso curso : estudiante.getCursosEstudiante()) {

            JButton btnCurso = new JButton(curso.getNombreCurso());
            btnCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnCurso.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
            btnCurso.setFont(new Font("Segoe UI", Font.BOLD, 18));
            btnCurso.setBackground(new Color(96, 107, 134));
            btnCurso.setForeground(Color.WHITE);
            btnCurso.setFocusPainted(false);

            btnCurso.addActionListener(ev -> mostrarPaginaCurso(curso));

            panelCursos.add(Box.createVerticalStrut(15));
            panelCursos.add(btnCurso);
        }

        JScrollPane scroll = new JScrollPane(panelCursos);
        scroll.setBorder(null);
        scroll.setBackground(new Color(45, 55, 72));
        scroll.getViewport().setBackground(new Color(45, 55, 72));

        panelEstudiante.add(barra, BorderLayout.NORTH);
        panelEstudiante.add(scroll, BorderLayout.CENTER);

        return panelEstudiante;
    }

    // PAGINA DEL CURSO
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
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addActionListener(ev -> {
            if (opcion.equals("Materiales")) {
                mostrarPanelMateriales(curso, true);
            } else if (opcion.equals("Evaluaciones")) {
                JOptionPane.showMessageDialog(this, "Sección de Evaluaciones (en construcción)");
            } else if (opcion.equals("Registro de Notas")) {
                JOptionPane.showMessageDialog(this, "Sección de Registro de Notas (en construcción)");
            }
        });

            panelOpciones.add(btn);
        }

        panelCurso.add(panelOpciones, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(237, 87, 97));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(e -> {
            if (usuario.equals(docente.getCorreo())) layout.show(contenedor, "aulaDocente");
            else layout.show(contenedor, "aulaEstudiante");
        });

        panelCurso.add(btnVolver, BorderLayout.SOUTH);

        contenedor.add(panelCurso, "paginaCurso_" + curso.getIdCurso());
        layout.show(contenedor, "paginaCurso_" + curso.getIdCurso());
    }

    // PANEL DE MATERIALES
    private void mostrarPanelMateriales(Curso curso, boolean esDocente) {

        JPanel panelMateriales = new JPanel(new BorderLayout());
        panelMateriales.setBackground(new Color(45, 55, 72));

        JLabel lblTitulo = new JLabel("Materiales del curso: " + curso.getNombreCurso(), SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panelMateriales.add(lblTitulo, BorderLayout.NORTH);

        JPanel listaPanel = new JPanel();
        listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));
        listaPanel.setBackground(new Color(45, 55, 72));

        JScrollPane scroll = new JScrollPane(listaPanel);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(45, 55, 72));
        panelMateriales.add(scroll, BorderLayout.CENTER);

        Runnable refrescarLista = () -> {
            listaPanel.removeAll();
            if (curso.getMaterial() != null && !curso.getMaterial().isEmpty()) {
                for (Material m : curso.getMaterial()) {
                    JPanel item = new JPanel(new BorderLayout());
                    item.setBackground(new Color(74, 85, 110));
                    item.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

                    JLabel lblMat = new JLabel("<html><b>" + m.getTitulo() + "</b> (" + m.getTipo() + ")<br><font color='#CCCCCC'>" + m.getUrl() + "</font></html>");
                    lblMat.setForeground(Color.WHITE);
                    item.add(lblMat, BorderLayout.CENTER);

                    listaPanel.add(Box.createVerticalStrut(10));
                    listaPanel.add(item);
                }
            } else {
                JLabel lblVacio = new JLabel("No hay materiales disponibles.", SwingConstants.CENTER);
                lblVacio.setForeground(Color.LIGHT_GRAY);
                lblVacio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                listaPanel.add(lblVacio);
            }
            listaPanel.revalidate();
            listaPanel.repaint();
        };
        refrescarLista.run();

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelBotones.setBackground(new Color(45, 55, 72));

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(237, 87, 97));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(e -> layout.show(contenedor, "paginaCurso_" + curso.getIdCurso()));
        panelBotones.add(btnVolver);

        if (esDocente) {
            JButton btnAgregar = new JButton("Crear material");
            btnAgregar.setBackground(new Color(96, 107, 134));
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
            btnAgregar.setFocusPainted(false);

            btnAgregar.addActionListener(e -> {
                String titulo = JOptionPane.showInputDialog(this, "Título del material:");
                String tipo = JOptionPane.showInputDialog(this, "Tipo (PDF, Video, Link, etc):");
                String url = JOptionPane.showInputDialog(this, "URL o ruta del material:");
                if (titulo != null && tipo != null && url != null && !titulo.trim().isEmpty()) {
                    if (curso.getMaterial() == null) curso.setMaterial(new ArrayList<>());
                    curso.getMaterial().add(new Material(curso.getMaterial().size() + 1, titulo, tipo, url));
                    refrescarLista.run();
                }
        });

        panelBotones.add(btnAgregar);
    }

    panelMateriales.add(panelBotones, BorderLayout.SOUTH);

    contenedor.add(panelMateriales, "materiales_" + curso.getIdCurso());
    layout.show(contenedor, "materiales_" + curso.getIdCurso());
}

    private JPanel crearPanelEvaluacionesDocente(Curso curso) {
    JPanel panelEvaluaciones = new JPanel(new BorderLayout());
    panelEvaluaciones.setBackground(new Color(30, 40, 60));

    JLabel lblTitulo = new JLabel("Evaluaciones de " + curso.getNombreCurso(), SwingConstants.CENTER);
    lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
    lblTitulo.setForeground(Color.WHITE);
    lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    panelEvaluaciones.add(lblTitulo, BorderLayout.NORTH);

    JPanel listaEvaluaciones = new JPanel();
    listaEvaluaciones.setLayout(new BoxLayout(listaEvaluaciones, BoxLayout.PAGE_AXIS));
    listaEvaluaciones.setBackground(new Color(30, 40, 60));

    JScrollPane scroll = new JScrollPane(listaEvaluaciones);
    scroll.setBorder(null);
    scroll.getViewport().setBackground(new Color(30, 40, 60));
    panelEvaluaciones.add(scroll, BorderLayout.CENTER);

    JButton btnCrearEvaluacion = new JButton("Crear Evaluación");
    btnCrearEvaluacion.setBackground(new Color(60, 90, 150));
    btnCrearEvaluacion.setForeground(Color.WHITE);
    btnCrearEvaluacion.setFont(new Font("Segoe UI", Font.BOLD, 14));
    btnCrearEvaluacion.setFocusPainted(false);
    btnCrearEvaluacion.setCursor(new Cursor(Cursor.HAND_CURSOR));

    JPanel barraInferior = new JPanel(new BorderLayout());
    barraInferior.setBackground(new Color(30, 40, 60));
    barraInferior.add(btnCrearEvaluacion, BorderLayout.EAST);
    barraInferior.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    panelEvaluaciones.add(barraInferior, BorderLayout.SOUTH);

    btnCrearEvaluacion.addActionListener(e -> {
        List<Pregunta> preguntasTemp = new ArrayList<>();

        JPanel panelCrearEval = new JPanel(new BorderLayout());
        panelCrearEval.setPreferredSize(new Dimension(700, 500));
        panelCrearEval.setBackground(new Color(45, 60, 90));
        panelCrearEval.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblNuevaEval = new JLabel("Nueva Evaluación", SwingConstants.CENTER);
        lblNuevaEval.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblNuevaEval.setForeground(Color.WHITE);
        panelCrearEval.add(lblNuevaEval, BorderLayout.NORTH);

        JPanel panelPreguntas = new JPanel();
        panelPreguntas.setLayout(new BoxLayout(panelPreguntas, BoxLayout.Y_AXIS));
        panelPreguntas.setBackground(new Color(45, 60, 90));

        JScrollPane scrollPreguntas = new JScrollPane(panelPreguntas);
        scrollPreguntas.setBorder(null);
        panelCrearEval.add(scrollPreguntas, BorderLayout.CENTER);

        JPanel barraBotones = new JPanel(new BorderLayout());
        barraBotones.setBackground(new Color(45, 60, 90));

        JButton btnAnadirPregunta = new JButton("Añadir Pregunta");
        btnAnadirPregunta.setBackground(new Color(70, 110, 190));
        btnAnadirPregunta.setForeground(Color.WHITE);
        btnAnadirPregunta.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton btnGuardarEval = new JButton("Guardar Evaluación");
        btnGuardarEval.setBackground(new Color(60, 160, 90));
        btnGuardarEval.setForeground(Color.WHITE);
        btnGuardarEval.setFont(new Font("Segoe UI", Font.BOLD, 14));

        barraBotones.add(btnGuardarEval, BorderLayout.WEST);
        barraBotones.add(btnAnadirPregunta, BorderLayout.EAST);
        panelCrearEval.add(barraBotones, BorderLayout.SOUTH);

        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(panelEvaluaciones), "Crear Evaluación", true);
        dialog.getContentPane().add(panelCrearEval);
        dialog.pack();
        dialog.setLocationRelativeTo(panelEvaluaciones);

        btnAnadirPregunta.addActionListener(ev -> {
            JPanel tarjeta = new JPanel();
            tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
            tarjeta.setBackground(new Color(60, 80, 120));
            tarjeta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JTextField txtPregunta = new JTextField("Escribe la pregunta aquí...");
            txtPregunta.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            tarjeta.add(txtPregunta);

            JPanel opcionesPanel = new JPanel();
            opcionesPanel.setLayout(new BoxLayout(opcionesPanel, BoxLayout.Y_AXIS));
            opcionesPanel.setBackground(new Color(60, 80, 120));

            List<JTextField> camposOpciones = new ArrayList<>();
            ButtonGroup grupo = new ButtonGroup();

            for (int i = 0; i < 4; i++) {
                JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT));
                fila.setBackground(new Color(60, 80, 120));
                JRadioButton rb = new JRadioButton();
                rb.setBackground(new Color(60, 80, 120));
                rb.setForeground(Color.WHITE);
                JTextField txtOpcion = new JTextField("Opción " + (i + 1), 20);
                grupo.add(rb);
                camposOpciones.add(txtOpcion);
                fila.add(rb);
                fila.add(txtOpcion);
                opcionesPanel.add(fila);
            }

            tarjeta.add(opcionesPanel);

            JButton btnGuardarPregunta = new JButton("Guardar Pregunta");
            btnGuardarPregunta.setBackground(new Color(100, 180, 100));
            btnGuardarPregunta.setForeground(Color.WHITE);
            btnGuardarPregunta.setFont(new Font("Segoe UI", Font.BOLD, 12));
            tarjeta.add(btnGuardarPregunta);

            panelPreguntas.add(tarjeta);
            panelPreguntas.add(Box.createVerticalStrut(10));
            panelPreguntas.revalidate();
            panelPreguntas.repaint();

            btnGuardarPregunta.addActionListener(ev2 -> {
                String enunciado = txtPregunta.getText();
                List<String> opciones = new ArrayList<>();
                String respuestaCorrecta = null;

                for (int i = 0; i < camposOpciones.size(); i++) {
                    String texto = camposOpciones.get(i).getText();
                    opciones.add(texto);
                    JPanel fila = (JPanel) opcionesPanel.getComponent(i);
                    JRadioButton rb = (JRadioButton) fila.getComponent(0);
                    if (rb.isSelected()) respuestaCorrecta = texto;
                }

                if (respuestaCorrecta == null) {
                    JOptionPane.showMessageDialog(panelCrearEval, "Selecciona una respuesta correcta.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                preguntasTemp.add(new Pregunta(preguntasTemp.size() + 1, enunciado, respuestaCorrecta, opciones));
                JOptionPane.showMessageDialog(panelCrearEval, "Pregunta guardada correctamente.");
            });
        });

        btnGuardarEval.addActionListener(ev -> {
            if (preguntasTemp.isEmpty()) {
                JOptionPane.showMessageDialog(panelCrearEval, "Debes añadir al menos una pregunta.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String tituloEval = JOptionPane.showInputDialog(panelCrearEval, "Título de la evaluación:");
            if (tituloEval == null || tituloEval.trim().isEmpty()) return;

            Evaluacion nuevaEval = curso.crearEvaluacion(tituloEval, preguntasTemp);

            JPanel tarjetaEval = new JPanel(new BorderLayout());
            tarjetaEval.setBackground(new Color(70, 90, 140));
            tarjetaEval.setPreferredSize(new Dimension(220, 120));
            tarjetaEval.setMaximumSize(new Dimension(220,120));
            tarjetaEval.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel lblNombreEval = new JLabel(nuevaEval.getTitulo());
            lblNombreEval.setForeground(Color.WHITE);
            lblNombreEval.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tarjetaEval.add(lblNombreEval, BorderLayout.CENTER);
            tarjetaEval.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            /*tarjetaEval.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    StringBuilder sb = new StringBuilder("Preguntas de " + nuevaEval.getTitulo() + ":\n\n");
                    for (Pregunta p : nuevaEval.getPreguntas()) {
                        sb.append(p.getIdPregunta()).append(". ").append(p.getEnunciado()).append("\n");
                    }
                    JOptionPane.showMessageDialog(panelEvaluaciones, sb.toString(), "Evaluación", JOptionPane.INFORMATION_MESSAGE);
                }
            }); */ //POR REVISAR

            listaEvaluaciones.add(Box.createVerticalStrut(10));
            listaEvaluaciones.add(tarjetaEval);
            listaEvaluaciones.revalidate();
            listaEvaluaciones.repaint();

            dialog.dispose();
            JOptionPane.showMessageDialog(panelEvaluaciones, "Evaluación guardada exitosamente.");
        });

        dialog.setVisible(true);
    });

    return panelEvaluaciones;
}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

