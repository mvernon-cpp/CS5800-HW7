package org.example.flyweight;

import java.util.HashMap;

public class StyleFactory {
    private HashMap<Integer, Style> styles = new HashMap<>();

    public  Style getStyle(int font){
        if( styles.containsKey( font ) )
        {
            return styles.get(font);
        }
        else {
            Style style = null;
            if( font == 0 ){
                style = new Style_Arial();
            } else if ( font == 1 ) {
                style = new Style_Calibri();
            } else if ( font == 2) {
                style = new Style_Verdana();
            } else if ( font == 3) {
                style = new Style_Courier();
            }

            styles.put(font, style);
            return style;
        }
    }
}
