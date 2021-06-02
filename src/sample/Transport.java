package sample;

import java.io.Serializable;

public class Transport implements Serializable {

    enum transportType{Overland, Sea, Air};

    private transportType type;
    private String name;
    private String number;

    public Transport(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Transport(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public transportType getType() {
        return type;
    }

    public void setType(transportType type) {
        this.type = type;
    }
}
