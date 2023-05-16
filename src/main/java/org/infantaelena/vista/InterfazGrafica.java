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

        JPanel panelTipo = new JPanel();
        panelTipo.add(new JLabel("Tipo:"));
        apellido = new JTextField(20);
        panelTipo.add(apellido);
        panelDatos.add(panelTipo);

        JPanel panelHP = new JPanel();
        panelHP.add(new JLabel("HP:"));
        numReg = new JTextField(20);
        panelHP.add(numReg);
        panelDatos.add(panelHP);

        JPanel panelAtaque = new JPanel();
        panelAtaque.add(new JLabel("Ataque:"));
        numReg = new JTextField(20);
        panelAtaque.add(numReg);
        panelDatos.add(panelAtaque);

        JPanel panelAtaqueEspecial = new JPanel();
        panelAtaqueEspecial.add(new JLabel("Ataque Especial:"));
        numReg = new JTextField(20);
        panelAtaqueEspecial.add(numReg);
        panelDatos.add(panelAtaqueEspecial);

        JPanel panelDefensa = new JPanel();
        panelDefensa.add(new JLabel("Defensa:"));
        numReg = new JTextField(20);
        panelDefensa.add(numReg);
        panelDatos.add(panelDefensa);

        JPanel panelDefensaEspecial = new JPanel();
        panelDefensaEspecial.add(new JLabel("DefensaEspecial:"));
        numReg = new JTextField(20);
        panelDefensaEspecial.add(numReg);
        panelDatos.add(panelDefensaEspecial);

        JPanel panelVelocidad = new JPanel();
        panelVelocidad.add(new JLabel("Velocidad:"));
        numReg = new JTextField(20);
        panelVelocidad.add(numReg);
        panelDatos.add(panelVelocidad);

        add(panelDatos, BorderLayout.WEST);

        JPanel panelVacio = new JPanel();
        add(panelVacio, BorderLayout.CENTER);
        setVisible(true);
    }
}
