package com.WindThunderStudio.NumberFormatter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {
    
    public String formatNumber(String s, boolean isInteger){
        String result = "";
        try {
            NumberFormat f = NumberFormat.getInstance(new Locale("es", "ES"));
            f.setGroupingUsed(true);
            if (isInteger) {
                f.setMaximumFractionDigits(0);
                f.setMinimumFractionDigits(0);
                f.setParseIntegerOnly(true);
            } else {
                f.setMaximumFractionDigits(2);
                f.setMinimumFractionDigits(2);
                f.setParseIntegerOnly(false);
            }
            try {
                Integer i = Integer.parseInt(s);
                result = f.format((double)i / 100);
            } catch (NumberFormatException e) {
                Long l = Long.parseLong(s);
                System.out.println((double)l / 100);
                
                result = f.format((double)l / 100);
            }
//            DecimalFormat f = new DecimalFormat("#.###,##");
//            result = f.format(Integer.parseInt(s) / 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
        NumberFormatter f = new NumberFormatter();
        System.out.println(f.formatNumber("123456", false));
        
    }

}
