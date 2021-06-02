package sample;

import java.io.Serializable;

public class Glider extends AirTransport implements Serializable {

    private String typeOfGlider;

    public String getTypeOfGlider() {
        return typeOfGlider;
    }

    public Glider(String name, String number, int sittingPlaces, boolean helix, String typeOfGlider) {
        super(name, number, sittingPlaces, helix);
        this.typeOfGlider = typeOfGlider;
    }

    public Glider(){

    }
}
