package com.WindThunderStudio.ChineseFontsFinder;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Vector;

public class ChineseFontFinder {
	
	public Vector<String> findAllFontsForChinese() {
		Vector<String> chinesefonts = new Vector<String>();
		Font[] allfonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		String chinesesample = "\u4e00";
		for (int j = 0; j < allfonts.length; j++) {
		    if (allfonts[j].canDisplayUpTo(chinesesample) == -1) { 
		        chinesefonts.add(allfonts[j].getFontName());
		        System.out.println(allfonts[j]);
		    }
		}
		
		return chinesefonts;
	}
}
