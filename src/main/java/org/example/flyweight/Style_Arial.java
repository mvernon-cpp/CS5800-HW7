package org.example.flyweight;

public class Style_Arial implements Style{

    private String font;
    private String color;
    private int size;
    @Override
    public String getFont() {
        return font;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setStyle( String color, int size)
    {
        this.font = "Arial";
        this.color = color;
        this.size = size;
    }
    @Override
    public String toString(){
        return "Font: " + font + " Color: " + color + " Size: " + size;
    }
}
