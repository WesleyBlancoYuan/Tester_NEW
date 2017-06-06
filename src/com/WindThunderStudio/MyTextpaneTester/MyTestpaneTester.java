package com.WindThunderStudio.MyTextpaneTester;

import com.WindThunderStudio.Util.Elements.MyJTextPane;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MyTestpaneTester extends JFrame {
    public MyTestpaneTester() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyJTextPane pane = new MyJTextPane();
        pane.append("Line 1");
        pane.append(System.getProperty("line.separator"));
        pane.append("Line 2");
        pane.setBounds(0, 0, 200, 100);
        add(pane);
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyTestpaneTester frame = new MyTestpaneTester();

            }

        });
    }
}

