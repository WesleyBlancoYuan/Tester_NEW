package com.WindThunderStudio.SwingTest.UpdateTab;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import net.miginfocom.swing.MigLayout;

public class UpdateTab extends JDialog {
    public UpdateTab() {
        begin();
    }

    private void begin() {
        //我尝试着做一下哈。不知道是不是你要的东西，不好别打我。
        //毕竟“我的电脑”里面好像没有“自动更新”选项卡。这个是系统属性里面的。
        try {
            //模仿Windows 2000/XP的样式
            UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
            //原来的字体太小了
            UIManager.put("TabbedPane.font", new Font("Microsoft Yahei", Font.PLAIN, 13));
            UIManager.put("Button.font", new Font("Microsoft Yahei", Font.PLAIN, 13));
            UIManager.put("Label.font", new Font("Microsoft Yahei", Font.PLAIN, 13));
            UIManager.put("RadioButton.font", new Font("Microsoft Yahei", Font.PLAIN, 13));
            UIManager.put("ComboBox.font", new Font("Microsoft Yahei", Font.PLAIN, 13));
            
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //窗口标题
        setTitle("系统属性");
        
        //复杂布局不得不使用MigLayout。一列，两行，上面放JTabbedPane，下面放两个按钮,固定为40像素高
        setLayout(new MigLayout("insets 5, fill", "[]", "[]5[40!]"));
        
        //下方按钮面板
        JPanel buttons = new JPanel();
        buttons.setOpaque(false); //避免灰色背景
        //复杂布局。三列，一行。三列统统往右边推到顶，右对齐。
        buttons.setLayout(new MigLayout("insets 2, fill", "push[]5[]5[]", "[]"));
        
        JButton confirm = new JButton("确定");
        buttons.add(confirm, "cell 0 0, w 70!"); //确定：第一行第一列，宽度100像素
        JButton cancel = new JButton("取消");
        buttons.add(cancel, "cell 1 0, w 70!"); //取消：第一行第二列，宽度100像素
        JButton apply = new JButton("应用");
        buttons.add(apply, "cell 2 0, w 70!"); //取消：第一行第三列，宽度100像素
        
        //将按钮面板加到窗口里面，第一列第二行，上下左右都尽量占据余下空间
        add(buttons, "cell 0 1, grow");
        
        //上方选项卡面板
        JTabbedPane allTabs = new JTabbedPane();
        add(allTabs, "cell 0 0, grow");
        //所有tabs放最上面
        allTabs.setTabPlacement(JTabbedPane.TOP);
        //如果一行放不下所有tab的标题，换行显示
        allTabs.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        
        //其他tab我就做个标题算了。
        JLayeredPane layer0 = new JLayeredPane();
        JLayeredPane layer1 = new JLayeredPane();
        JLayeredPane layer2 = new JLayeredPane();
        JLayeredPane layer3 = new JLayeredPane();
        
        
        
        allTabs.addTab("常规", layer0);
        allTabs.addTab("计算机名", layer1);
        allTabs.addTab("硬件", layer2);
        allTabs.addTab("高级", layer3);
        allTabs.addTab("常规", layer0);
        
        
        JLayeredPane update = new JLayeredPane();
        update.setOpaque(false); //灰色背景
        update.setLayout(new MigLayout("insets 2, fillx", "[]", "[]4[]4[]4[]4[]4[]4[]4[]4[]"));
        
        //第一行：帮助保护您的计算机
        JLabel blueTitle = new JLabel("帮助保护您的计算机");
        blueTitle.setForeground(Color.WHITE);
        blueTitle.setBackground(Color.BLUE);
        blueTitle.setOpaque(true); //为了标题的背景颜色能显示出来
        //图片我网上找了三张
        blueTitle.setIcon(new ImageIcon(getClass().getResource("shield_color.gif")));
        update.add(blueTitle, "cell 0 0, h 50!, grow, gapleft 5, gapright 5, gaptop 5, gapbottom 5");
        
        JLabel automatic = new JLabel();
        //JLabel的文本支持最基本的html。使用此标签后，JLabel可以在固定宽度的条件下自动换行。
        automatic.setText("<html>Windows可以定期检查重要更新，并为您安装它们。(启用自动更新可以在安装其他更新之前先自动更新Windows Update软件。)</html>");
        update.add(automatic, "cell 0 1, growx"); //宽度已经固定为其上一级容器的宽度。拖放窗口可以看到标签自动换行。
        
        JLabel howToUpdate = new JLabel();
        howToUpdate.setForeground(Color.BLUE);
        howToUpdate.setText("<html><a href=\"/\">自动更新如何工作？</a>"); //虽然有超链接效果，但点击无法重定向。
//        howToUpdate.setText("自动更新如何工作？");
        //下划线效果和手型图标
//        Font font = howToUpdate.getFont();
//        Map attributes = font.getAttributes();
//        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//        howToUpdate.setFont(font.deriveFont(attributes));
        howToUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.add(howToUpdate, "cell 0 2, growx");
        
        JRadioButton auto = new JRadioButton("自动更新(推荐)(U)");
        auto.setMnemonic(KeyEvent.VK_U);
        auto.setFont(new Font(auto.getFont().getName(), Font.BOLD, auto.getFont().getSize()));
        update.add(auto, "cell 0 3, growx");
        
        //绿色盾牌面板
        JPanel green = new JPanel();
        green.setOpaque(false);
        
        //三行四列。布局复杂的时候最好先行在纸上设计一下。有个叫asciiflow的网站画这种图不错。
//        +-------------------+-------------------------------------+
//        |                   |                                     |
//        |                   |                                     |
//        |                   +-------------------------------------+
//        |                   |                                     |
//        |                   |                                     |
//        |                   +-------------------------------------+
//        |                   | +-----------+  +----+  +----------+ |
//        |                   | |           |  |    |  |          | |
//        |                   | +-----------+  +----+  +----------+ |
//        +-------------------+-------------------------------------+
        green.setLayout(new MigLayout("insets 2, fill", "[center]3[]3[]3[]", "[]3[20!]3[]"));//第二行无元素但必须空出来
        
        JLabel greenShield = new JLabel();
        greenShield.setText(null);
        greenShield.setIcon(new ImageIcon(getClass().getResource("shield_green.gif")));
        green.add(greenShield, "cell 0 0 1 3, aligny top, sizegroup shield"); //第一列第一行跨一列三行
        
        JLabel downloadAndInstall = new JLabel("自动下载推荐的更新，并安装它们：");
        green.add(downloadAndInstall, "cell 1 0, span 3, growx"); //在第二列第一行显示，并跨3列
        
        JComboBox<String> frecuency = new JComboBox<String>(new String[]{"每天","每周","每月","每年"});
        green.add(frecuency, "cell 1 2");
        
        JLabel at = new JLabel("在");
        green.add(at, "cell 2 2, grow");
        
        JComboBox<String> time = new JComboBox<String>(new String[]{"3:00","4:00", "5:00"});
        green.add(time, "cell 3 2");
        
        //把绿色盾牌面板加到tab里面，可别忘了
        update.add(green, "cell 0 4, grow");
        
        JRadioButton onlyDownload = new JRadioButton("下载更新，但是由我来决定什么时候安装(D)。");
        onlyDownload.setMnemonic(KeyEvent.VK_D);
        update.add(onlyDownload, "cell 0 5, growx");
        
        JRadioButton onlyNotify = new JRadioButton("有可用下载时通知我，但是不要自动下载或安装更新(N)。");
        onlyNotify.setMnemonic(KeyEvent.VK_N);
        update.add(onlyNotify, "cell 0 6, growx");
        
        JRadioButton off = new JRadioButton("关闭自动更新(T)。");
        off.setMnemonic(KeyEvent.VK_T);
        update.add(off, "cell 0 7, growx");
        
        //把所有的radiobutton加入一个buttongroup来实现多选一的自动控制
        ButtonGroup bg = new ButtonGroup();
        bg.add(auto);
        bg.add(onlyDownload);
        bg.add(onlyNotify);
        bg.add(off);
        
        //红色盾牌面板
        JPanel red = new JPanel();
        red.setOpaque(false);
        red.setLayout(new MigLayout("insets 5, fill", "[center]2[]", "[]2[30!]2[]"));
        
        JLabel redShield = new JLabel();
        redShield.setText(null);
        redShield.setIcon(new ImageIcon(getClass().getResource("shield_red.gif")));
        red.add(redShield, "cell 0 0 1 3, aligny top, sizegroup shield");
        
        JLabel vulnerable = new JLabel("如果您不定期安装更新，您的计算机将变得易受攻击。");
        red.add(vulnerable, "cell 1 0, growx");
        
        JLabel install = new JLabel("<html>从<a href=\"www.microsoft.com\"/>Windows Update网站</a>安装更新。</html>");
        red.add(install, "cell 1 2, growx");
        
        //将红色盾牌面板加入到选项卡里面
        update.add(red, "cell 0 8, grow");
       
        JLabel again = new JLabel("<html><a href=\"/\">再次提供我以前隐藏的更新</a>");
        again.setForeground(Color.BLUE);
        again.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.add(again, "cell 0 9, growx");
        
        allTabs.addTab("自动更新", update);
        
        JLayeredPane layer5 = new JLayeredPane();
        allTabs.addTab("远程", layer5);
        
        allTabs.setSelectedIndex(4);
        
        pack();
        setBounds(0, 0, 500, getHeight()+15); //miglayout bug，如果有tabbedpane无法计算准确高度。需要调整。
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                UpdateTab frame = new UpdateTab();

            }

        });
    }
}

