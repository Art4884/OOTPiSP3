package sample;

import java.io.Serializable;

public class Yacht extends SeaTransport implements Serializable {

    private boolean sail;
    private int decks;

    public boolean isSail() {
        return sail;
    }

    public int getDecks() {
        return decks;
    }

    public Yacht(String name, String number, boolean motor, boolean sail, int decks) {
        super(name, number, motor);
        this.sail = sail;
        this.decks = decks;
    }

    public Yacht(){

    }
}
