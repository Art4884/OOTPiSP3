package sample;

import java.io.Serializable;

public class OverlandTransport extends Transport implements Serializable {

    private int wheels;
    private int sittingPlaces;

    public OverlandTransport(String name, String number, int wheels, int sittingPlaces){
        super(name, number);
        this.wheels = wheels;
        this.sittingPlaces = sittingPlaces;
        setType(transportType.Overland);
    }

    public OverlandTransport() {

    }

    public int getWheels() {
        return wheels;
    }

    public int getSittingPlaces() {
        return sittingPlaces;
    }
}
