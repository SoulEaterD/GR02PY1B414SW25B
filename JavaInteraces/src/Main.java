import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {

    private CardLayout layout;
    private JPanel contenedor;

    String usuario;
    private Docente docente = new Docente("1", "Pepito Candela", "docente@docente.com", "123");
    private Estudiante e1 = new Estudiante("1", "Juan Suarez", "juan@patito.com", "123");
    private Estudiante e2 = new Estudiante("2", "Maria Suarez", "maria@patito.com", "123");
    private Estudiante e3 = new Estudiante("3", "Jorge Oviiedo", "jorge@patito.com", "123");
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
        aulaVirtual.getEstudiantesRegistrados().add(e3);

        JPanel pantallaLogin = crearPantallaLogin();
        JPanel pantallaAulaDocente = crearPantallaAulaDocente();

        contenedor.add(pantallaLogin, "login");
        contenedor.add(pantallaAulaDocente, "aulaDocente");

        add(contenedor);
        setVisible(true);
    }

    //LOGIN
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

            if (usuario.equals(docente.getCorreo()) && contrasena.equals(docente.getContrasenia())) {
                layout.show(contenedor, "aulaDocente");
                encontrado = true;
            } else {
                for (int i = 0; i < aulaVirtual.estudiantesRegistrados.size(); i++) {
                    if (usuario.equals(aulaVirtual.estudiantesRegistrados.get(i).getCorreo())
                            && contrasena.equals(aulaVirtual.estudiantesRegistrados.get(i).getContrasenia())) {
                        JPanel pantallaEstudiante = crearPantallaAulaEstudiante(
                                aulaVirtual.estudiantesRegistrados.get(i));
                        contenedor.add(pantallaEstudiante, "aulaEstudiante");
                        layout.show(contenedor, "aulaEstudiante");
                        encontrado = true;
                        break;
                    }
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        });

        return fondo;
    }

    //AULA DOCENTE
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

                Curso nuevoCurso = aulaVirtual.crearCurso(aulaVirtual.getCursosDisponibles().size() + 1, nombre, "",
                        docente);

                for (Estudiante registrado : aulaVirtual.getEstudiantesRegistrados()) {
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

    //AULA ESTUDIANTE
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
        btnCerrarSesion.addActionListener(e -> {
            layout.show(contenedor, "login");
        });

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

    //PAGINA DEL CURSO
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

        String[] opciones = { "Materiales", "Tareas", "Registro de Notas" };

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
                    mostrarPanelMateriales(curso);
                } else if (opcion.equals("Tareas")) {
                    mostrarPanelTareas(curso);
                } else if (opcion.equals("Registro de Notas")) {
                    mostrarPanelNotas(curso);
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
            if (usuario.equals(docente.getCorreo()))
                layout.show(contenedor, "aulaDocente");
            else
                layout.show(contenedor, "aulaEstudiante");
        });

        panelCurso.add(btnVolver, BorderLayout.SOUTH);

        contenedor.add(panelCurso, "paginaCurso_" + curso.getIdCurso());
        layout.show(contenedor, "paginaCurso_" + curso.getIdCurso());
    }

    //PANEL DE MATERIALES
    private void mostrarPanelMateriales(Curso curso) {

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

                    JLabel lblMat = new JLabel("<html><b>" + m.getTitulo() + "</b> (" + m.getTipo()
                            + ")<br><font color='#CCCCCC'>" + m.getUrl() + "</font></html>");
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

        if (usuario.equals(docente.getCorreo())) {
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
                    if (curso.getMaterial() == null)
                        curso.setMaterial(new ArrayList<>());
                    curso.crearMaterial(curso.getMaterial().size() + 1, titulo, tipo, url);
                    refrescarLista.run();
                }
            });

            panelBotones.add(btnAgregar);
        }

        panelMateriales.add(panelBotones, BorderLayout.SOUTH);

        contenedor.add(panelMateriales, "materiales_" + curso.getIdCurso());
        layout.show(contenedor, "materiales_" + curso.getIdCurso());
    }

    private void mostrarPanelTareas(Curso curso) {
        JPanel panelTareas = new JPanel(new BorderLayout());
        panelTareas.setBackground(new Color(45, 55, 72));

        JLabel lblTitulo = new JLabel("Tareas del curso: " + curso.getNombreCurso(), SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panelTareas.add(lblTitulo, BorderLayout.NORTH);

        JPanel listaPanelT = new JPanel();
        listaPanelT.setLayout(new BoxLayout(listaPanelT, BoxLayout.Y_AXIS));
        listaPanelT.setBackground(new Color(45, 55, 72));

        JScrollPane scroll = new JScrollPane(listaPanelT);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(45, 55, 72));
        panelTareas.add(scroll, BorderLayout.CENTER);

        //FUNCION PARA REFRESCAR LA LISTA DE TAREAS
        Runnable refrescarListaT = () -> {
            listaPanelT.removeAll();
            if (curso.getTareas() != null && !curso.getTareas().isEmpty()) {
                for (Tarea t : curso.getTareas()) {
                    JPanel item = new JPanel(new BorderLayout());
                    item.setBackground(new Color(74, 85, 110));
                    item.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

                    JLabel lblTareas = new JLabel(t.getTitulo() + "\n- " + t.getDescripcion());
                    lblTareas.setForeground(Color.WHITE);
                    item.add(lblTareas, BorderLayout.CENTER);

                    JButton btnAccion = new JButton(usuario.equals(docente.getCorreo()) ? "Calificar" : "Ver tarea");
                    btnAccion.setBackground(new Color(96, 107, 134));
                    btnAccion.setForeground(Color.WHITE);
                    btnAccion.setFont(new Font("Segoe UI", Font.BOLD, 13));
                    btnAccion.setFocusPainted(false);

                    //Asocia la tarea a su boton
                    btnAccion.putClientProperty("tarea", t);

                    btnAccion.addActionListener(e -> {
                        Tarea tareaSeleccionada = (Tarea) ((JButton) e.getSource()).getClientProperty("tarea");
                        if (usuario.equals(docente.getCorreo())) {
                            //Pide calificacion
                            for (int i = 0; i < aulaVirtual.getEstudiantesRegistrados().size(); i++) {
                                String input = JOptionPane.showInputDialog(
                                        panelTareas,
                                        "Ingrese la calificación para "
                                                + aulaVirtual.getEstudiantesRegistrados().get(i).getNombre() + ":",
                                        "Calificar tarea",
                                        JOptionPane.QUESTION_MESSAGE);

                                try {
                                    if (curso.getrNotas() == null) {
                                        curso.setrNotas(new RegistroNotas());
                                        curso.getrNotas().setCalificaciones(new ArrayList<>());
                                    }
                                    double nota = Double.parseDouble(input);
                                    curso.calificarTarea(tareaSeleccionada,
                                            aulaVirtual.getEstudiantesRegistrados().get(i), nota);
                                    JOptionPane.showMessageDialog(panelTareas,
                                            "Tarea calificada con éxito.\nNota: " + nota,
                                            "Calificación registrada",
                                            JOptionPane.INFORMATION_MESSAGE);
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(panelTareas,
                                            "Por favor, ingrese un número válido.",
                                            "Error de formato",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } else {
                            //Si es estudiante solo mostrar informacion
                            JOptionPane.showMessageDialog(panelTareas,
                                    "Título: " + tareaSeleccionada.getTitulo() +
                                            "\nDescripción: " + tareaSeleccionada.getDescripcion() +
                                            (tareaSeleccionada.getCalificacion() != null
                                                    ? "\nCalificación: " + tareaSeleccionada.getCalificacion()
                                                    : "\nSin calificar aún."),
                                    "Detalles de la tarea",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    });

                    item.add(btnAccion, BorderLayout.EAST);
                    listaPanelT.add(Box.createVerticalStrut(10));
                    listaPanelT.add(item);
                }
            } else {
                JLabel lblVacio = new JLabel("No hay tareas en este momento.", SwingConstants.CENTER);
                lblVacio.setForeground(Color.LIGHT_GRAY);
                lblVacio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                listaPanelT.add(lblVacio);
            }

            listaPanelT.revalidate();
            listaPanelT.repaint();
        };

        refrescarListaT.run();

        //BOTONES INFERIORES
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelBotones.setBackground(new Color(45, 55, 72));

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(237, 87, 97));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(e -> layout.show(contenedor, "paginaCurso_" + curso.getIdCurso()));
        panelBotones.add(btnVolver);

        if (usuario.equals(docente.getCorreo())) {
            JButton btnAgregar = new JButton("Mandar Tarea");
            btnAgregar.setBackground(new Color(96, 107, 134));
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
            btnAgregar.setFocusPainted(false);

            btnAgregar.addActionListener(e -> {
                String tituloT = JOptionPane.showInputDialog(this, "Título de la tarea:");
                String desc = JOptionPane.showInputDialog(this, "Descripción de la tarea:");
                if (tituloT != null && desc != null && !tituloT.trim().isEmpty()) {
                    if (curso.getTareas() == null)
                        curso.setTareas(new ArrayList<>());

                    curso.crearTarea(tituloT, desc);
                    refrescarListaT.run();
                }
            });

            panelBotones.add(btnAgregar);
        }

        panelTareas.add(panelBotones, BorderLayout.SOUTH);
        contenedor.add(panelTareas, "tareas_" + curso.getIdCurso());
        layout.show(contenedor, "tareas_" + curso.getIdCurso());
    }

    //PANEL NOTAS
    private void mostrarPanelNotas(Curso curso) {
        JPanel panelNotas = new JPanel(new BorderLayout());
        panelNotas.setBackground(new Color(45, 55, 72));

        //Titulo principal
        JLabel lblTitulo = new JLabel("Registro de notas - " + curso.getNombreCurso(), SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panelNotas.add(lblTitulo, BorderLayout.NORTH);

        //Panel donde se mostraran las notas
        JPanel listaPanel = new JPanel();
        listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));
        listaPanel.setBackground(new Color(45, 55, 72));

        JScrollPane scroll = new JScrollPane(listaPanel);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(45, 55, 72));
        panelNotas.add(scroll, BorderLayout.CENTER);

        //Refrescar lista de notas
        Runnable refrescarLista = () -> {
            listaPanel.removeAll();
            if (aulaVirtual.getEstudiantesRegistrados() != null && !aulaVirtual.getEstudiantesRegistrados().isEmpty()) {
                int contador = 1;
                for (Estudiante e : aulaVirtual.getEstudiantesRegistrados()) {
                    RegistroNotas rNotas = e.getNotasEstudiante();

                    if (rNotas != null && rNotas.getCalificaciones() != null && !rNotas.getCalificaciones().isEmpty()) {
                        for (Double n : rNotas.getCalificaciones()) {
                            JPanel item = new JPanel(new BorderLayout());
                            item.setBackground(new Color(74, 85, 110));
                            item.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

                            JLabel lblNota = new JLabel(
                                    "<html><b>" + e.getNombre() + " - Nota #" + contador + ":</b> " + n + "</html>");
                            lblNota.setForeground(Color.WHITE);

                            item.add(lblNota, BorderLayout.CENTER);
                            listaPanel.add(Box.createVerticalStrut(10));
                            listaPanel.add(item);
                            contador++;
                        }
                    } else {
                        JLabel lblSinNotas = new JLabel(e.getNombre() + " no tiene notas registradas.",
                                SwingConstants.CENTER);
                        lblSinNotas.setForeground(Color.LIGHT_GRAY);
                        listaPanel.add(lblSinNotas);
                    }
                }
            } else {
                JLabel lblVacio = new JLabel("No hay estudiantes registrados.", SwingConstants.CENTER);
                lblVacio.setForeground(Color.LIGHT_GRAY);
                listaPanel.add(lblVacio);
            }

            listaPanel.revalidate();
            listaPanel.repaint();
        };

        refrescarLista.run();

        //Panel inferior con boton Volver
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelBotones.setBackground(new Color(45, 55, 72));

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(237, 87, 97));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(e -> layout.show(contenedor, "paginaCurso_" + curso.getIdCurso()));
        panelBotones.add(btnVolver);

        panelNotas.add(panelBotones, BorderLayout.SOUTH);

        contenedor.add(panelNotas, "notas_" + curso.getIdCurso());
        layout.show(contenedor, "notas_" + curso.getIdCurso());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

}
