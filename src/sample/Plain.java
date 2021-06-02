package sample;

import java.io.Serializable;

public class Plain extends AirTransport implements Serializable {

    private boolean aquaChassis;

    public boolean isAquaChassis() {
        return aquaChassis;
    }

    public String getTypeOfPlain() {
        return typeOfPlain;
    }

    private String typeOfPlain;

    public Plain(String name, String number, int sittingPlaces, boolean helix, boolean aquaChassis, String typeOfPlain) {
        super(name, number, sittingPlaces, helix);
        this.aquaChassis = aquaChassis;
        this.typeOfPlain = typeOfPlain;
    }

    public Plain(){

    }
}
