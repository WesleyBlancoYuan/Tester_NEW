package com.WindThunderStudio.EnableAndStatic;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class StaticMenubar extends JMenuBar{
        public static JMenu menu1;
        private JMenu menu2;
        public StaticMenubar() {
            menu1 = new JMenu("private static");
            menu2 = new JMenu("private");
            
            add(menu1);
            add(menu2);
        }
        
        
        public void disableAll() {
//          this.setVisible(false);
          menu1.setEnabled(false);
          menu2.setEnabled(false);
//          this.setVisible(true);
      }
      public void enableAll() {
//          this.setVisible(false);
          menu1.setEnabled(true);
          menu2.setEnabled(true);
//          this.setVisible(true);
      }
}
