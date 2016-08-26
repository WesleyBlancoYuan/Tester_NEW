package com.WindThunderStudio.MigLayoutTest;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MigLayoutMySCCEE extends JFrame{
private JFrame mainFrame;
private JPanel panel;

private JLabel lblResumenAuto;
private JLabel lblResumenAutoResult;
private JLabel lblResumenRazonSocial;
private JLabel lblResumenRazonSocialResult;
private JLabel lblResumenPeriodo;
private JLabel lblResumenPeriodoResult;
private JLabel lblResumenFechaHora;
private JLabel lblResumenFechaHoraResult;

public MigLayoutMySCCEE(){
    run();
}

public void run(){
    JPanel p = new JPanel();
    p.setLayout(new MigLayout("debug, fill","[grow]","[50:20:30]10[100::]10[20::]10[50!]10[20!]"));

    panel = new JPanel();
    panel.setLayout(new MigLayout("fillx, debug", "[left, 15%]10[left, grow, 35%]10[left, 15%]10[left, grow, 35%]", "[center]10[center]"));

    lblResumenAuto = new JLabel("MY LABEL 1111111111111");
    lblResumenAutoResult = new JLabel("1111111111111111111111");

    panel.add(lblResumenAuto);
    panel.add(lblResumenAutoResult);

    lblResumenRazonSocial = new JLabel("MY LABEL 2222222222");
    lblResumenRazonSocialResult = new JLabel("2222222222222222222222");

    panel.add(lblResumenRazonSocial);
    panel.add(lblResumenRazonSocialResult,"wrap");

    lblResumenPeriodo = new JLabel("MY LABEL 33333333333333");
    lblResumenPeriodoResult = new JLabel("3333333333333333333333333333333333333333333333333333333");

    panel.add(lblResumenPeriodo);
    panel.add(lblResumenPeriodoResult);
    //poner el texto como html puede tener otra linea, porque es muy largo
    lblResumenFechaHora = new JLabel("<html>MY LABEL <br /> 4444444444444444</html>");
    lblResumenFechaHoraResult = new JLabel("4444444444444444444444444");

    panel.add(lblResumenFechaHora);
    panel.add(lblResumenFechaHoraResult);

    p.add(panel, "cell 0 0");
//    p.add(panel,"cell 0 0, grow");
//    p.add(panel,"grow");

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//    setBounds(0, 0, 1250, 500);
    getContentPane().add(p);

    pack();
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(true);
}

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            MigLayoutMySCCEE test = new MigLayoutMySCCEE();

        }
    });
}
}
