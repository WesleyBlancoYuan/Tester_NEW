package com.WindThunderStudio.EnableAndStatic;

import javax.swing.SwingUtilities;

public class TestButtonPrivateStatic {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TestWithPrivateStaticButton frame = new TestWithPrivateStaticButton();
                StaticMenubar.menu1.setEnabled(false);
                frame.getBar().disableAll();
            }

        });
    }
}
