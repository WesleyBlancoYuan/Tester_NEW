package com.WindThunderStudio.SwingTest.MigLayoutTest;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import net.miginfocom.swing.MigLayout;

public class MenuResizingProblem extends JFrame {
    public MenuResizingProblem() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        final JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new MigLayout("insets 5, fillx, debug", "[]", "[]5[]5[]"));
        
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        
        JMenuItem file_new = new JMenuItem("New...");
        file.add(file_new);
        
        JMenu tool = new JMenu("Tool");
        
        JMenuItem tool_options = new JMenuItem("Options...");
        tool.add(tool_options);
        
        bar.add(file);
        bar.add(tool);
        
        
        panel.add(bar,"cell 0 0, grow");
        
        getContentPane().add(panel);
        bar.setEnabled(false);
        file.setEnabled(false);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MenuResizingProblem frame = new MenuResizingProblem();

            }

        });
    }
}

