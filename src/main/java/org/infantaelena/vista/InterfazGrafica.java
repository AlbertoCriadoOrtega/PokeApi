package org.infantaelena.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InterfazGrafica extends JFrame {

    private final int ANCHO = 800;
    private final int ALTO = 600;

    private JTextField nombre;
    private JTextField tipo;
    private JTextField hp;
    private JTextField ataque;
    private JTextField defensa;
    private JTextField velocidad;
    private DefaultTableModel atributosTableModel;

    public InterfazGrafica(){
        setTitle("PokeAPI");
        setSize(ANCHO, ALTO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));

        JPanel panelNombre = new JPanel();
        panelNombre.add(new JLabel("Nombre:"));
        nombre = new JTextField(20);
        panelNombre.add(nombre);
        panelDatos.add(panelNombre);

        JPanel panelTipo = new JPanel();
        panelTipo.add(new JLabel("Tipo:"));
        tipo = new JTextField(20);
        panelTipo.add(tipo);
        panelDatos.add(panelTipo);

        JPanel panelHP = new JPanel();
        panelHP.add(new JLabel("HP:"));
        hp = new JTextField(20);
        panelHP.add(hp);
        panelDatos.add(panelHP);

        JPanel panelAtaque = new JPanel();
        panelAtaque.add(new JLabel("Ataque:"));
        ataque = new JTextField(20);
        panelAtaque.add(ataque);
        panelDatos.add(panelAtaque);

        JPanel panelDefensa = new JPanel();
        panelDefensa.add(new JLabel("Defensa:"));
        defensa = new JTextField(20);
        panelDefensa.add(defensa);
        panelDatos.add(panelDefensa);

        JPanel panelVelocidad = new JPanel();
        panelVelocidad.add(new JLabel("Velocidad:"));
        velocidad = new JTextField(20);
        panelVelocidad.add(velocidad);
        panelDatos.add(panelVelocidad);

        add(panelDatos, BorderLayout.WEST);

        JPanel panelTabla = new JPanel();

        atributosTableModel = new DefaultTableModel();
        atributosTableModel.addColumn("Nombre");
        atributosTableModel.addColumn("Tipo");
        atributosTableModel.addColumn("HP");
        atributosTableModel.addColumn("Ataque");
        atributosTableModel.addColumn("Defensa");
        atributosTableModel.addColumn("Velocidad");

        JTable atributosTable = new JTable(atributosTableModel);
        JScrollPane atributosScrollPane = new JScrollPane(atributosTable);
        panelTabla.add(atributosScrollPane);

        add(panelTabla, BorderLayout.EAST);

        JPanel panelBoton = new JPanel();

        JButton btnCrear = new JButton("Crear");
        panelBoton.add(btnCrear);
        add(panelBoton, BorderLayout.SOUTH);

        JButton btnBorrar = new JButton("Borrar");
        panelBoton.add(btnBorrar);
        add(panelBoton, BorderLayout.SOUTH);

        JButton btnListar = new JButton("Listar");
        panelBoton.add(btnListar);
        add(panelBoton, BorderLayout.SOUTH);

        JButton btnFiltrar = new JButton("Filtrar");
        panelBoton.add(btnFiltrar);
        add(panelBoton, BorderLayout.SOUTH);

        JButton btnModificar = new JButton("Modificar");
        panelBoton.add(btnModificar);
        add(panelBoton, BorderLayout.SOUTH);

        JButton btnGuardarBBDD = new JButton("Guardar BBDD");
        panelBoton.add(btnGuardarBBDD);
        add(panelBoton, BorderLayout.SOUTH);

        JButton btnCargarBBDD = new JButton("Cargar BBDD");
        panelBoton.add(btnCargarBBDD);
        add(panelBoton, BorderLayout.SOUTH);



        JPanel panelVacio = new JPanel();
        add(panelVacio, BorderLayout.CENTER);
        setVisible(true);
    }
}
