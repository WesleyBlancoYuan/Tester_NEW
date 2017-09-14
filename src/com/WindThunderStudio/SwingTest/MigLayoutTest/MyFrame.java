package com.WindThunderStudio.SwingTest.MigLayoutTest;

import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

public class MyFrame extends JFrame {
    public MyFrame() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("insets 10, fill", "[]", "[]5[]"));
        
        //first panel
        JPanel first = new JPanel();
        
        //first这个panel有5像素的边缘，2列，3行。第一列右对齐，占40%宽度；第二列默认，左对齐，占据剩余所有空间。
        first.setLayout(new MigLayout("insets 5, fill", "[right, 40%]5[fill, grow]", "[]5[]5[]"));
        first.setOpaque(false);
        //这个面板的border有些特殊：createTitledBorder()方法的签名可以有两个：前一个是线的类型，后面一个是标题文本。
        Border result = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "修改信息： ");
        first.setBorder(result);
        //把first加到contentPane里面
        add(first, "cell 0 0, grow");
        
        JLabel original = new JLabel("输入原密码： ");
        JLabel newPass = new JLabel("输入新密码： ");
        JLabel confirm = new JLabel("确认新密码： ");
        
        JTextField orig_field = new JTextField();
        JTextField new_field = new JTextField();
        JTextField confirm_field = new JTextField();
        
        //miglayout的核心就是网格排布。用坐标来定义添加元素的位置
        first.add(original, "cell 0 0, w 100!");      //add to col 0, line 0, min:pref:max width all set to 100
        first.add(newPass, "cell 0 1, w 100!");       //add to col 0, line 1
        first.add(confirm, "cell 0 2, w 100!");       //add to col 0, line 2
        
        first.add(orig_field, "cell 1 0, w 150!");    //add to col 1, line 0, min:pref:max width all set to 150
        first.add(new_field, "cell 1 1, w 150!");    //add to col 1, line 1
        first.add(confirm_field, "cell 1 2, w 150!");    //add to col 1, line 2
        
        //按钮面板
        JPanel buttons = new JPanel();
        buttons.setOpaque(false);
        //边缘为5像素；有两列，中间是10像素的间距，列内元素居中；有一行，行中上下对齐也是居中
        buttons.setLayout(new MigLayout("insets 5, fill", "[center]10[center]", "[center]"));
        JButton yes = new JButton("Y. 确定");
        //快捷键设为虚拟键Y，得到下划线效果
        yes.setMnemonic(KeyEvent.VK_Y);
        
        JButton quit = new JButton("Q. 退出");
        //快捷键设为虚拟键Q，得到下划线效果
        quit.setMnemonic(KeyEvent.VK_Q);
        
        //把yes按钮加到第一列第一行，min:pref:max的大小都设为100像素
        buttons.add(yes, "cell 0 0, w 100!");
        //把quit按钮加到第二列第一行，min:pref:max的大小都设为100像素
        buttons.add(quit, "cell 1 0, w 100!");
        
        //把按钮面板加到contentPane里面
        add(buttons, "cell 0 1, grow");
        pack();
        setBounds(0, 0, 500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyFrame frame = new MyFrame();

            }

        });
    }
}
