package sample;

public class SeaTransport extends Transport {

    private boolean motor;

    public boolean isMotor() {
        return motor;
    }

    public SeaTransport(String name, String number, boolean motor) {
        super(name, number);
        this.motor = motor;
        setType(transportType.Sea);
    }

    public SeaTransport(){

    }
}
