package org.example.flyweight;

public interface Style {
    String getFont();
    String getColor();
    int getSize();
    void setStyle(String color, int size);
}
