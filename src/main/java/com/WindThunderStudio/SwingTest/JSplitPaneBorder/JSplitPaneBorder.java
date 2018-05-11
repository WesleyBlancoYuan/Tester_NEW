package com.WindThunderStudio.SwingTest.JSplitPaneBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class JSplitPaneBorder extends JFrame {
    public JSplitPaneBorder() {
        begin();
    }

    private void begin() {
        
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTree tree1 = new JTree();
        DefaultMutableTreeNode root1 = new DefaultMutableTreeNode();
        root1.setUserObject("Tree 1: loooooooooooooooooooooooooooooooooong");
        DefaultTreeModel model1 = new DefaultTreeModel(root1);
        tree1.setModel(model1);
        tree1.setBorder(BorderFactory.createLineBorder(Color.RED));
        tree1.setBorder(null);
        JScrollPane sp1 = new JScrollPane(tree1);
        sp1.setViewportBorder(BorderFactory.createLineBorder(Color.YELLOW));
        sp1.setViewportBorder(null);
        sp1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //sp1.setBorder(null);
        
        JTree tree2 = new JTree();
        DefaultMutableTreeNode root2 = new DefaultMutableTreeNode();
        root2.setUserObject("Tree 2: short");
        DefaultTreeModel model2 = new DefaultTreeModel(root2);
        tree2.setModel(model2);
        tree2.setBorder(BorderFactory.createLineBorder(Color.RED));
        tree2.setBorder(null);
        JScrollPane sp2 = new JScrollPane(tree2);
        sp2.setViewportBorder(BorderFactory.createLineBorder(Color.YELLOW));
        sp2.setViewportBorder(null);
        sp2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        sp2.setBorder(null);
        
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp1, sp2);
        split.setBorder(BorderFactory.createEtchedBorder());
        split.setPreferredSize(new Dimension(600, 300));
        split.setDividerLocation(200);
        
        setLayout(new BorderLayout());
        
        add(split, BorderLayout.CENTER);
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JSplitPaneBorder frame = new JSplitPaneBorder();

            }

        });
    }
}
