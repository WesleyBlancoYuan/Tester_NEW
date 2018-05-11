package com.WindThunderStudio.SwingTest.MigLayoutTest;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class AutoResizingProblem extends JFrame {
    
    private static final Font ARIAL_PLAIN_15 = new Font("Arial", Font.PLAIN, 15);
    private static final Font ARIAL_BOLD_14 = new Font("Arial", Font.BOLD, 14); //FONT++
    private static final Font ARIAL_PLAIN_14 = new Font("Arial", Font.PLAIN, 14); //font++
    private static final Font CONSOLAS_PLAIN_14 = new Font("Consolas", Font.PLAIN, 14); //FONT++
    private static final Font ARIAL_PLAIN_13 = new Font("Arial", Font.PLAIN, 13);//font++
    
    private JPanel panel2;
    public AutoResizingProblem() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new MigLayout("insets 5, fillx", "[]", "[]5[]"));
        
        final JPanel content = new JPanel();
        getContentPane().add(content, "cell 0 0, grow");
        
        final JPanel panel = new JPanel();
//              setLayout(null);

        panel.setLayout(new MigLayout("insets 5 5 5 5", "[fill, grow]5[300!]", "[]10[]5[fill, grow]5[]5[]"));
        panel.setOpaque(false);
        panel.setVisible(true);
                
                // CABECERA
                // ********
        final JLabel lblreconstruccinDelRegistro = new JLabel("<html>Reconstrucci\u00F3n del Registro de Env\u00EDos y Respuestas</html>");
        lblreconstruccinDelRegistro.setToolTipText("<html>Reconstrucci\u00F3n del Registro de Env\u00EDos y Respuestas</html>");
        lblreconstruccinDelRegistro.setOpaque(true);
        lblreconstruccinDelRegistro.setHorizontalTextPosition(SwingConstants.CENTER);
        lblreconstruccinDelRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        lblreconstruccinDelRegistro.setForeground(Color.BLACK);
        lblreconstruccinDelRegistro.setFont(ARIAL_PLAIN_15);
        lblreconstruccinDelRegistro.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        lblreconstruccinDelRegistro.setBorder(new LineBorder(Color.GRAY));
        lblreconstruccinDelRegistro.setBackground(UIManager.getColor("Menu.background"));
//              lblreconstruccinDelRegistro.setBounds(0, 2, 604, 23);
        panel.add(lblreconstruccinDelRegistro, "cell 0 0, span 2, h 25!, grow");      
                
                // BLOQUE DE SEGUIMIENTO
                // *********************
        JLabel lblSeguimiento = new JLabel("Seguimiento actual:");
        lblSeguimiento.setToolTipText("Seguimiento actual");
        lblSeguimiento.setFont(ARIAL_BOLD_14);
        //lblSeguimiento.setBounds(10, 80, 419, 14);
        panel.add(lblSeguimiento, "cell 0 1, split 3, h 25!");
        // Radio Buttons
        JRadioButton rbMantener = new JRadioButton();
        rbMantener.setText("Mantener");
        rbMantener.setFont(ARIAL_PLAIN_14);
        panel.add(rbMantener, ""); //add after the label of Seuigimiento, same cell.
        
        JRadioButton rbEliminar = new JRadioButton();
        rbEliminar.setText("Eliminar");
        rbEliminar.setFont(ARIAL_PLAIN_14);
        panel.add(rbEliminar, "grow");
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbMantener);
        group.add(rbEliminar);
        
        // Botón "Iniciar"
        JButton btnIniciarRBD = new JButton("Iniciar Reconstrucci\u00F3n");
        btnIniciarRBD.setFont(ARIAL_PLAIN_14);
        panel.add(btnIniciarRBD, "cell 1 1, gapleft push, h 30!, gapright 5");
        
        JPanel panelListasPorProcesar = new JPanel();
        panelListasPorProcesar.setLayout(new MigLayout("insets 0 0 0 0, fillx, debug","[50%]5[50%]", "[25!]5[45%]5[45%]"));
        panelListasPorProcesar.setOpaque(false);
        panelListasPorProcesar.setBorder(null);
//              panelListasPorProcesar.setBounds(10, 100, 440, 270);
        panel.add(panelListasPorProcesar, "cell 0 2, grow");
        
     // Label "Número de ficheros por procesar"
        JLabel lblNmeroDeFicherosPorProcesar = new JLabel();
        lblNmeroDeFicherosPorProcesar.setFont(ARIAL_BOLD_14);
//              lblNmeroDeFicherosPorProcesar.setBounds(20, 80, 419, 14);
//              add(lblNmeroDeFicherosPorProcesar);
        panelListasPorProcesar.add(lblNmeroDeFicherosPorProcesar, "cell 0 0, grow, span 2");
        
        JLabel lblBuznDeEntrada = new JLabel();
        lblBuznDeEntrada.setFont(ARIAL_PLAIN_14);
        ;
//              lblBuznDeEntrada.setBounds(13, 10, 147, 14);
        panelListasPorProcesar.add(lblBuznDeEntrada, "cell 0 1, split 2, flowy, h 25!, grow");
        // Lista "Buzón de entrada"
        final JList listaRB01 = new JList();
        listaRB01.setOpaque(true);
        listaRB01.setBorder(null);
        listaRB01.setFont(CONSOLAS_PLAIN_14);       
        JScrollPane spRB01 = new JScrollPane();
//              spRB01.setBounds(10, 30, 205, 100);
        spRB01.getViewport().setOpaque(false);
        spRB01.setViewportView(listaRB01);
//              panelListasPorProcesar.add(spRB01);
        panelListasPorProcesar.add(spRB01, "cell 0 1, grow");
        
        JLabel lblFicherosRnt = new JLabel();
        lblFicherosRnt.setFont(ARIAL_PLAIN_14);
//              lblFicherosRnt.setBounds(225, 10, 147, 14);
        panelListasPorProcesar.add(lblFicherosRnt, "cell 1 1, flowy, split 2, h 25!, grow");
        
        // Lista "Ficheros RNT"
        JList listaRB02 = new JList();
        listaRB02.setOpaque(true);
        listaRB02.setBorder(null);
        listaRB02.setFont(CONSOLAS_PLAIN_14);
        JScrollPane spRB02 = new JScrollPane();
//              spRB02.setBounds(222, 30, 205, 100);
        spRB02.getViewport().setOpaque(false);
        spRB02.setViewportView(listaRB02);
        
        panelListasPorProcesar.add(spRB02, "cell 1 1, grow");
        
        
        // "Ficheros DCL" y "Ficheros RLC"
        JLabel lblFicherosDcl = new JLabel();
        lblFicherosDcl.setFont(ARIAL_PLAIN_14);
//              lblFicherosDcl.setBounds(13, 135, 147, 14);
        panelListasPorProcesar.add(lblFicherosDcl, "cell 0 2, split 2, flowy, h 25!, grow");
        // Lista "Ficheros DCL"
        JList listaRB03 = new JList();
        listaRB03.setOpaque(true);
        listaRB03.setFont(CONSOLAS_PLAIN_14);
        
        JScrollPane spRB03 = new JScrollPane();
//              spRB03.setBounds(10, 155, 205, 100);
        spRB03.getViewport().setOpaque(false);
        spRB03.setViewportView(listaRB03);      
        
//              panelListasPorProcesar.add(spRB03);
        panelListasPorProcesar.add(spRB03, "cell 0 2, grow");
        
        
        JLabel lblFicherosRlc = new JLabel();
        lblFicherosRlc.setFont(ARIAL_PLAIN_14);
//              lblFicherosRlc.setBounds(225, 135, 147, 14);
        panelListasPorProcesar.add(lblFicherosRlc, "cell 1 2, split 2, flowy, h 25!, grow");
        
        // Lista "Ficheros RLC"
        JList listaRB04 = new JList();
        listaRB04.setOpaque(true);
        listaRB04.setBorder(null);
        listaRB04.setFont(CONSOLAS_PLAIN_14);
        
        JScrollPane spRB04 = new JScrollPane();
//              spRB04.setBounds(222, 155, 205, 100);
        spRB04.getViewport().setOpaque(false);
        spRB04.setViewportView(listaRB04);      
        
        panelListasPorProcesar.add(spRB04, "cell 1 2, grow");
        
        JLabel lblNmeroDeFicherosProcesados = new JLabel();
        lblNmeroDeFicherosProcesados.setFont(ARIAL_BOLD_14);
//                lblNmeroDeFicherosProcesados.setBounds(450, 80, 270, 14);
//                add(lblNmeroDeFicherosProcesados);
        panel.add(lblNmeroDeFicherosProcesados, "cell 1 2, grow, split 2, flowy, align left, h 25!");
        
        JList listaRBProcesados = new JList();
        listaRBProcesados.setOpaque(true);
        listaRBProcesados.setBorder(null);
        listaRBProcesados.setFont(CONSOLAS_PLAIN_14);
        
        JScrollPane spRBProcesados = new JScrollPane();
        spRBProcesados.setBorder(new LineBorder(Color.DARK_GRAY));
        spRBProcesados.getViewport().setOpaque(false);
//              spRBProcesados.setBounds(10, 10, 250, 250);
        spRBProcesados.setViewportView(listaRBProcesados);
        
//              panelListaProcesados.add(spRBProcesados);
        
        panel.add(spRBProcesados, "cell 1 2, grow");
        
        // Muestra del avance del proceso
        JLabel lblAvance = new JLabel("A long bar");
        lblAvance.setFont(ARIAL_PLAIN_14);
        lblAvance.setForeground(Color.BLACK); //lblAvance.setForeground(Color.decode("#0078FF"));
//              lblAvance.setBounds(10, 30, 440, 23);
        
        JProgressBar pbAvance = new JProgressBar();
        pbAvance.setBackground(Color.LIGHT_GRAY);
        pbAvance.setOpaque(true);
        pbAvance.setBorder(new LineBorder(Color.GRAY));
        //pbAvance.setUI(new RenderGradientPalletProgressBarUI());
        //pbAvance.setUI(new RenderBarraProgreso());
        //pbAvance.setForeground(Color.BLACK);
        pbAvance.setString("");
        pbAvance.setStringPainted(true);
        pbAvance.setFont(ARIAL_PLAIN_13);
        pbAvance.setMaximum(0);
        pbAvance.setMinimum(0);
//              pbAvance.setBounds(0, 375, 720, 16);
        
        panel.add(lblAvance, "cell 0 3, span 2, grow");
//        panel.add(pbAvance, "cell 0 4, span 2, grow");
        
        JButton button = new JButton("Toggle");
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                CardLayout cl = null;
                cl = (CardLayout)content.getLayout();
                if (panel.isVisible()) {
                    System.out.println("show panel2");
                    cl.show(content, "panel2");
                } else if (panel2.isVisible()) {
                    System.out.println("show panel1");
                    cl.show(content, "panel1");
                }
            }
        });
        getContentPane().add(button, "cell 0 1, grow");
        
//              add(lblAvance);
//              add(pbAvance);
        content.setLayout(new CardLayout());
        content.add(panel, "panel1");
        
        panel2 = new JPanel() {
            @Override
            public void paintComponent(Graphics g){
                Dimension tamanio = getSize();
                ImageIcon imagenDeFondo = new ImageIcon("img/back.png");
                g.drawImage(imagenDeFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
                setOpaque(false);
//              super.paintComponent(g);
            }
            
//            @Override
//            public Dimension getPreferredSize() {
//                return new Dimension(600,400);
//            }
        };
        
        content.add(panel2, "panel2");
//        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                AutoResizingProblem frame = new AutoResizingProblem();

            }

        });
    }
}
