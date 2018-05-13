package com.WindThunderStudio.SwingTest.CombineComboBox;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class CombineJComboBox extends JFrame {
    //定义为域，让内部类可以直接使用
    private JComboBox<String> comboAirports;
    private JComboBox<String> comboCities;
    
    public CombineJComboBox() {
        begin();
    }

    private void begin() {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //第一个下拉列表：机场
        comboAirports = 
                new JComboBox<String>(new String[]{"选个机场吧？", "双流机场", "通州机场", "虹桥机场", "首都国际机场", "浦东国际机场"});
        comboAirports.addItemListener(new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                //如果是选中选项动作
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().toString().equals("虹桥机场") || 
                            e.getItem().toString().equals("浦东国际机场")) {
                        comboCities.setSelectedItem("上海");
                    } else if (e.getItem().toString().equals("通州机场") || 
                            e.getItem().toString().equals("首都国际机场")) {
                        comboCities.setSelectedItem("北京");
                    } else if (e.getItem().toString().equals("双流机场")) {
                        comboCities.setSelectedItem("成都");//我还没有去过成都，不知道为什么想到机场就想到了这个名字。
                    } else {
                        comboCities.setSelectedIndex(0); //选中第一个选项。
                    }
                } else if (e.getStateChange() == ItemEvent.DESELECTED){
                    //不要做任何事。选中一个选项必定导致前面一个选项不被选中。一次选择实际上产生了两个event
                }
            }
        });
        comboAirports.setSelectedIndex(0); //初始选择第一个选项
        comboAirports.setBounds(0, 0, 150, 30);
        add(comboAirports, BorderLayout.WEST);
        
        //第二个下拉列表：城市
        comboCities = new JComboBox<String>(new String[]{"你想要去哪个城市呢？", "北京", "上海", "成都"});
        comboCities.setSelectedIndex(0); //初始选择第一个选项
        comboCities.setBounds(0, 0, 150, 30);
        add(comboCities, BorderLayout.EAST);
        
        
        pack();//计算所有component尺寸，妥善安排好，然后压缩到最合适尺寸。
        setBounds(0, 0, 300, 100); //重新设置窗口尺寸
        setLocationRelativeTo(null); //窗口居中
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                CombineJComboBox frame = new CombineJComboBox();

            }

        });
    }
}
