package com.WindThunderStudio.TableWithComboBox;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class GetModelFromCBToList {

	  public static void main(String[] args) {
	    JFrame frame = new JFrame("Lister v1.0");

	    String[] items = { "A", "B", "C" };
	    JComboBox comboBox = new JComboBox(items);
	    comboBox.setEditable(true);

	    final JList list = new JList(comboBox.getModel());
	    JButton button = new JButton("Per favore");
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        Object[] selection = list.getSelectedValues();
	        for (Object s : selection)
	          System.out.println(s);
	      }
	    });

	    JPanel comboPanel = new JPanel();
	    comboPanel.add(comboBox);
	    frame.add(comboPanel, BorderLayout.NORTH);
	    frame.add(new JScrollPane(list), BorderLayout.CENTER);
	    frame.add(button, BorderLayout.SOUTH);

	    frame.setSize(200, 200);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	  }

}
