package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Scanner;

public class SeaController {

    @FXML
    public TextField nameField;
    @FXML
    public TextField numberField;
    @FXML
    public TextField decksField;
    @FXML
    public CheckBox motorCheck;
    @FXML
    public CheckBox sailCheck;
    @FXML
    public TextField bNameField;
    @FXML
    public TextField bNumberField;
    @FXML
    public TextField materialField;
    @FXML
    public CheckBox bMotorCheck;
    @FXML
    public CheckBox oarsCheck;

    @FXML
    public void yacht() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("seaInfo.fxml"));
        primaryStage.setTitle("Yacht");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void boat() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("boatInfo.fxml"));
        primaryStage.setTitle("boat");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void xmlSerializationYacht(){
        String name = nameField.getText();
        String number = numberField.getText();
        boolean motor = motorCheck.isSelected();
        boolean sail = sailCheck.isSelected();
        int decks = Integer.parseInt(decksField.getText());
        Transport yacht = new Yacht(name, number, motor, sail, decks);
        xmlSave(yacht,1);
    }

    @FXML
    public void xmlSerializationBoat(){
        String name = bNameField.getText();
        String number = bNameField.getText();
        boolean motor = bMotorCheck.isSelected();
        boolean oars = oarsCheck.isSelected();
        String primeMaterial = materialField.getText();
        Transport boat = new Boat(name, number, motor, oars, primeMaterial);
        xmlSave(boat, 2);
    }

    private void xmlSave(Transport object, int type){
        try {
            XMLEncoder coder;
            if(type == 1){
                coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src\\SD\\seaYacht.xml")));
            }else{
                coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src\\SD\\seaBoat.xml")));
            }
            coder.writeObject(object);
            coder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void xmlDeserializationYacht(){
        try {
            FileInputStream input = new FileInputStream(new File("src\\SD\\seaYacht.xml"));
            XMLDecoder decoder = new XMLDecoder(input);
            Yacht object = (Yacht) decoder.readObject();
            decoder.close();
            input.close();
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            motorCheck.setSelected(object.isMotor());
            sailCheck.setSelected(object.isSail());
            decksField.setText(Integer.toString(object.getDecks()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void xmlDeserializationBoat(){
        try {
            FileInputStream input = new FileInputStream(new File("src\\SD\\seaBoat.xml"));
            XMLDecoder decoder = new XMLDecoder(input);
            Boat object = (Boat) decoder.readObject();
            decoder.close();
            input.close();
            bNameField.setText(object.getName());
            bNumberField.setText(object.getNumber());
            motorCheck.setSelected(object.isMotor());
            oarsCheck.setSelected(object.isOars());
            materialField.setText(object.getPrimaryMaterial());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binarySerializationYacht(){
        String name = nameField.getText();
        String number = numberField.getText();
        boolean motor = motorCheck.isSelected();
        boolean sail = sailCheck.isSelected();
        int decks = Integer.parseInt(decksField.getText());
        Transport yacht = new Yacht(name, number, motor, sail, decks);
        binarySave(yacht, 1);
    }

    @FXML
    public void binarySerializationBoat(){
        String name = bNameField.getText();
        String number = bNameField.getText();
        boolean motor = bMotorCheck.isSelected();
        boolean oars = oarsCheck.isSelected();
        String primeMaterial = materialField.getText();
        Transport boat = new Boat(name, number, motor, oars, primeMaterial);
        binarySave(boat, 2);
    }

    private void binarySave(Transport object, int type){
        try {
            FileOutputStream outputStream;
            if(type == 1){
                outputStream = new FileOutputStream("src\\SD\\seaYacht.txt");
            }else{
                outputStream = new FileOutputStream("src\\OD\\seaBoat.txt");
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binaryDeserializationYacht(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\SD\\seaYacht.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Yacht object = (Yacht) objectInputStream.readObject();
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            motorCheck.setSelected(object.isMotor());
            sailCheck.setSelected(object.isSail());
            decksField.setText(Integer.toString(object.getDecks()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binaryDeserializationBoat(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\SD\\seaBoat.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Boat object = (Boat) objectInputStream.readObject();
            bNameField.setText(object.getName());
            bNumberField.setText(object.getNumber());
            motorCheck.setSelected(object.isMotor());
            oarsCheck.setSelected(object.isOars());
            materialField.setText(object.getPrimaryMaterial());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void textSerializationYacht(){
        File file = new File("src\\SD\\seaYacht.txt");
        try {
            FileWriter writer = new FileWriter(file);
            String name = nameField.getText();
            String number = numberField.getText();
            boolean motor = motorCheck.isSelected();
            boolean sail = sailCheck.isSelected();
            int decks = Integer.parseInt(decksField.getText());
            StringBuilder builder = new StringBuilder();
            builder.append(name + " " + number + " " + motor + " " + sail + " " + decks);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void textSerializationBoat(){
        File file = new File("src\\SD\\seaBoat.txt");
        try {
            FileWriter writer = new FileWriter(file);
            String name = bNameField.getText();
            String number = bNameField.getText();
            boolean motor = bMotorCheck.isSelected();
            boolean oars = oarsCheck.isSelected();
            String primeMaterial = materialField.getText();
            StringBuilder builder = new StringBuilder();
            builder.append(name + " " + number + " " + motor + " " + oars + " " + primeMaterial);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void textDeserializationYacht(){
        File file = new File("src\\SD\\seaYacht.txt");
        try {
            Scanner sc = new Scanner(file);
            String str = sc.nextLine();
            String[] input = str.split(" ");
            Yacht object = new Yacht(input[0], input[1], Boolean.parseBoolean(input[2]), Boolean.parseBoolean(input[3]), Integer.parseInt(input[4]));
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            motorCheck.setSelected(object.isMotor());
            sailCheck.setSelected(object.isSail());
            decksField.setText(Integer.toString(object.getDecks()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void textDeserializationBoat(){
        File file = new File("src\\SD\\seaBoat.txt");
        try {
            Scanner sc = new Scanner(file);
            String str = sc.nextLine();
            String[] input = str.split(" ");
            Boat object = new Boat(input[0], input[1], Boolean.parseBoolean(input[2]), Boolean.parseBoolean(input[3]), input[4]);
            bNameField.setText(object.getName());
            bNumberField.setText(object.getNumber());
            motorCheck.setSelected(object.isMotor());
            oarsCheck.setSelected(object.isOars());
            materialField.setText(object.getPrimaryMaterial());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
