package org.infantaelena.vista;

import javax.swing.*;
import java.awt.*;

public class InterfazGrafica extends JFrame {

    private final int ANCHO = 600;
    private final int ALTO = 600;

    private JTextField nombre;
    private JTextField apellido;
    private JTextField numReg;

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

        JPanel panelApellido = new JPanel();
        panelApellido.add(new JLabel("Apellido:"));
        apellido = new JTextField(20);
        panelApellido.add(apellido);
        panelDatos.add(panelApellido);

        JPanel panelNumReg = new JPanel();
        panelNumReg.add(new JLabel("Número de registro:"));
        numReg = new JTextField(20);
        panelNumReg.add(numReg);
        panelDatos.add(panelNumReg);


        add(panelDatos, BorderLayout.WEST);

        JPanel panelVacio = new JPanel();
        add(panelVacio, BorderLayout.CENTER);
        setVisible(true);
    }
}
