package com.WindThunderStudio.MigLayoutTest;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MigLayoutTest extends JFrame{
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
	
	public MigLayoutTest(){
		run();
	}
	
	public void run(){
		mainFrame = new JFrame();
//		mainFrame.setSize(1250, 500);
//		mainFrame.setPreferredSize(new Dimension(1250, 500));
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel p = new JPanel();
//		p.setSize(mainFrame.getSize());
//		p.setMaximumSize(mainFrame.getMaximumSize());
//		p.setPreferredSize(mainFrame.getPreferredSize());
		p.setLayout(new MigLayout("fill, debug","[]","[50:20:30]10[100::]10[20::]10[50!]10[20!]"));
		
		panel = new JPanel();
		panel.setLayout(new MigLayout("fillx, debug", "[left, 15%]10[left, 35%]10[left, 15%]10[left, 35%]", "[center]10[center]10[]"));
		lblResumenAuto = new JLabel("MY LABEL 1");
		lblResumenAutoResult = new JLabel("1111111111111111111111");
		
		panel.add(lblResumenAuto);
		panel.add(lblResumenAutoResult);
		
		lblResumenRazonSocial = new JLabel("MY LABEL 22");
		lblResumenRazonSocialResult = new JLabel("2222222222222222222222");
		
		panel.add(lblResumenRazonSocial);
		panel.add(lblResumenRazonSocialResult,"wrap");
		
		lblResumenPeriodo = new JLabel("MY LABEL 3");
		lblResumenPeriodoResult = new JLabel("3333333333");
		
		panel.add(lblResumenPeriodo);
		panel.add(lblResumenPeriodoResult, "growx");
		//poner el texto como html puede tener otra linea, porque es muy largo
		lblResumenFechaHora = new JLabel("<html>MY LABEL <br /> 444444444</html>");
		lblResumenFechaHoraResult = new JLabel("4444444444444444444444444");
		
		panel.add(lblResumenFechaHora);
		panel.add(lblResumenFechaHoraResult, "growx");
		
		
		JButton button = new JButton("now what????");
		panel.add(button, "cell 2 2, gapleft push");
		p.add(panel);
		
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		setBounds(0, 0, 1250, 500);
//		getContentPane().add(mainFrame.getContentPane());
		
		
		p.updateUI();
		panel.updateUI();
		
		System.out.println(p.getWidth());
		System.out.println(panel.getWidth());
		System.out.println(lblResumenAuto.getWidth());
		System.out.println(lblResumenAutoResult.getWidth());
		
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
				MigLayoutTest test = new MigLayoutTest();
				
			}
		});
	}
}
