package sample;

import java.io.Serializable;

public class Motorcycle extends OverlandTransport implements Serializable {

    private String typeOfMotorcycle;
    private String markOfMotorcycle;

    public String getTypeOfMotorcycle() {
        return typeOfMotorcycle;
    }

    public String getMarkOfMotorcycle() {
        return markOfMotorcycle;
    }

    public Motorcycle(String name, String number, int wheels, int sittingPlaces, String typeOfMotorcycle, String markOfMotorcycle) {
        super(name, number, wheels, sittingPlaces);
        this.typeOfMotorcycle = typeOfMotorcycle;
        this.markOfMotorcycle = markOfMotorcycle;
    }
}
