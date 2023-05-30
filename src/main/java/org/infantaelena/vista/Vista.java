package org.infantaelena.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Clase que representa la vista de la aplicación
 * Implementar con menus de texto o con interfaz gráfica
 *
 * @author
 * @version 1.0
 * @date 24/04/2023
 */
public class Vista extends JFrame {
    private final int ANCHO = 800;
    private final int ALTO = 600;

    private JTextField nombre;
    private JComboBox<String> tipo;
    private JTextField habilidades;
    private JTextField hp;
    private JTextField ataque;
    private JTextField defensa;
    private JTextField velocidad;
    private DefaultTableModel atributosTableModel;

    private JButton btnCrear;
    private JButton btnModificar;
    private JButton btnBorrar;
    private JButton btnFiltrar;
    private JButton btnListar;

    private JButton btnBuscar;

    public Vista() {
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
        tipo = new JComboBox<String>(new String[]{"Normal", "Fuego", "Agua", "Planta", "Eléctrico", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Roca", "Fantasma", "Dragón", "Siniestro", "Acero", "Hada"});
        panelTipo.add(tipo);
        panelDatos.add(panelTipo);

        JPanel panelHabilidades = new JPanel();
        panelHabilidades.add(new JLabel("Habilidades:"));
        habilidades = new JTextField(20);
        panelHabilidades.add(habilidades);
        panelDatos.add(panelHabilidades);

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

        btnCrear = new JButton("Crear");
        panelBoton.add(btnCrear);
        add(panelBoton, BorderLayout.SOUTH);

        btnBorrar = new JButton("Borrar");
        panelBoton.add(btnBorrar);
        add(panelBoton, BorderLayout.SOUTH);

        btnBuscar = new JButton("Buscar");
        panelBoton.add(btnBuscar);
        add(panelBoton, BorderLayout.SOUTH);

        btnListar = new JButton("Listar");
        panelBoton.add(btnListar);
        add(panelBoton, BorderLayout.SOUTH);

        btnFiltrar = new JButton("Filtrar");
        panelBoton.add(btnFiltrar);
        add(panelBoton, BorderLayout.SOUTH);

        btnModificar = new JButton("Modificar");
        panelBoton.add(btnModificar);
        add(panelBoton, BorderLayout.SOUTH);


        JPanel panelVacio = new JPanel();
        add(panelVacio, BorderLayout.CENTER);
        setVisible(true);
    }

    public int getANCHO() {
        return ANCHO;
    }

    public int getALTO() {
        return ALTO;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public JComboBox<String> getTipo() {
        return tipo;
    }

    public void setTipo(JComboBox<String> tipo) {
        this.tipo = tipo;
    }

    public JTextField getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(JTextField habilidades) {
        this.habilidades = habilidades;
    }

    public JTextField getHp() {
        return hp;
    }

    public void setHp(JTextField hp) {
        this.hp = hp;
    }

    public JTextField getAtaque() {
        return ataque;
    }

    public void setAtaque(JTextField ataque) {
        this.ataque = ataque;
    }

    public JTextField getDefensa() {
        return defensa;
    }

    public void setDefensa(JTextField defensa) {
        this.defensa = defensa;
    }

    public JTextField getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(JTextField velocidad) {
        this.velocidad = velocidad;
    }

    public DefaultTableModel getAtributosTableModel() {
        return atributosTableModel;
    }

    public void setAtributosTableModel(DefaultTableModel atributosTableModel) {
        this.atributosTableModel = atributosTableModel;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnFiltrar() {
        return btnFiltrar;
    }

    public void setBtnFiltrar(JButton btnFiltrar) {
        this.btnFiltrar = btnFiltrar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public void setBtnListar(JButton btnListar) {
        this.btnListar = btnListar;
    }


}
