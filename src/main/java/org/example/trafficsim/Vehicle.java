package org.example.trafficsim;

public interface Vehicle {
    String getType();
    int[] getLocation();
    void setLocation(int latitude, int longitude);

}