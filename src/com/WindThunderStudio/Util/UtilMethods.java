package com.WindThunderStudio.Util;

public class UtilMethods {
    /**
     * According to the align <code>type</code>, substitute part of an empty String (constructed with <code>symbol</code>)
     * with text.
     * @param capacity the length of empty String
     * @param text content to fill in the empty String
     * @param symbol the char to construct the empty String
     * @param type the align type. Refer to <code>ALIGN_LEFT</code>, <code>ALIGN_RIGHT</code>
     * and <code>ALIGN_CENTER</code> in CTS.
     * @return the changed String.
     */
    public static String substituteWithContent(int capacity, String text, String symbol, int type) {
        if (capacity < text.length()) {
            return null;
        } else {
            StringBuilder b = new StringBuilder("");
            for (int i=0; i < capacity; i++) {
                b.append(symbol);
            }
            if (type == CTS.ALIGN_CENTER) { // centrar
                //buscar la posicion en la mitad
                int mid = (int) (capacity / 2); // siempre <= la mitad.
                int begin = mid - (int) (text.length() / 2);
                int end = begin + text.length();
                b.replace(begin, end, text);
                return b.toString();
            } else if (type == CTS.ALIGN_LEFT) { //left
                b.replace(0, text.length(), text);
                return b.toString();
            } else if (type == CTS.ALIGN_RIGHT) { //right
                b.replace(b.length() - text.length(), b.length(), text);
                return b.toString();
            }
        }
        return null;
    }
}
