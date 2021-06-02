package sample;

import java.io.Serializable;

public class Car extends OverlandTransport implements Serializable {

    private String typeOfCar;
    private String carMark;

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public String getCarMark() {
        return carMark;
    }

    public Car(String name, String number, int wheels, int sittingPlaces, String typeOfCar, String carMark){
        super(name, number, wheels, sittingPlaces);
        this.typeOfCar = typeOfCar;
        this.carMark = carMark;
    }
    public Car(){
//        super();
    }
}
