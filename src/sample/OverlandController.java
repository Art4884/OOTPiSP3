package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Scanner;

public class OverlandController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField placesField;
    @FXML
    private TextField wheelsField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField markField;
    @FXML
    private TextField nameFieldM;
    @FXML
    private TextField numberFieldM;
    @FXML
    private TextField placesFieldM;
    @FXML
    private TextField wheelsFieldM;
    @FXML
    private TextField typeFieldM;
    @FXML
    private TextField markFieldM;


    @FXML
    public void car() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("overlandInfo.fxml"));
        primaryStage.setTitle("Car");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void motorcycle() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("overlandInfoMotorcycle.fxml"));
        primaryStage.setTitle("Motorcycle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void xmlSerializationCar(){
        String name = nameField.getText();
        String number = numberField.getText();
        int sittingPlaces = Integer.parseInt(placesField.getText());
        int wheels = Integer.parseInt(wheelsField.getText());
        String typeOfCar = typeField.getText();
        String carMark = markField.getText();
        Transport car = new Car(name, number, wheels, sittingPlaces, typeOfCar, carMark);
        xmlSave(car,1);
    }

    @FXML
    public void xmlSerializationMotorcycle(){
        String name = nameFieldM.getText();
        String number = numberFieldM.getText();
        int sittingPlaces = Integer.parseInt(placesFieldM.getText());
        int wheels = Integer.parseInt(wheelsFieldM.getText());
        String typeOfCar = typeFieldM.getText();
        String carMark = markFieldM.getText();
        Transport motorcycle = new Motorcycle(name, number, wheels, sittingPlaces, typeOfCar, carMark);
        xmlSave(motorcycle, 2);
    }

    private void xmlSave(Transport object, int type){
        try {
            XMLEncoder coder;
            if(type == 1){
                coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src\\OD\\overlandCar.xml")));
            }else{
                coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src\\OD\\overlandMotorcycle.xml")));
            }
            coder.writeObject(object);
            coder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void xmlDeserializationCar(){
        try {
            FileInputStream input = new FileInputStream(new File("src\\OD\\overlandCar.xml"));
            XMLDecoder decoder = new XMLDecoder(input);
            Car object = (Car) decoder.readObject();
            decoder.close();
            input.close();
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            wheelsField.setText(Integer.toString(object.getWheels()));
            placesField.setText(Integer.toString(object.getSittingPlaces()));
            typeField.setText(object.getTypeOfCar());
            markField.setText(object.getCarMark());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void xmlDeserializationMotorcycle(){
        try {
            FileInputStream input = new FileInputStream(new File("src\\OD\\overlandMotorcycle.xml"));
            XMLDecoder decoder = new XMLDecoder(input);
            Motorcycle object = (Motorcycle) decoder.readObject();
            decoder.close();
            input.close();
            nameFieldM.setText(object.getName());
            numberFieldM.setText(object.getNumber());
            wheelsFieldM.setText(Integer.toString(object.getWheels()));
            placesFieldM.setText(Integer.toString(object.getSittingPlaces()));
            typeFieldM.setText(object.getTypeOfMotorcycle());
            markFieldM.setText(object.getMarkOfMotorcycle());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binarySerializationCar(){
        String name = nameField.getText();
        String number = numberField.getText();
        int sittingPlaces = Integer.parseInt(placesField.getText());
        int wheels = Integer.parseInt(wheelsField.getText());
        String typeOfCar = typeField.getText();
        String carMark = markField.getText();
        Transport car = new Car(name, number, wheels, sittingPlaces, typeOfCar, carMark);
        binarySave(car, 1);
    }

    @FXML
    public void binarySerializationMotorcycle(){
        String name = nameFieldM.getText();
        String number = numberFieldM.getText();
        int sittingPlaces = Integer.parseInt(placesFieldM.getText());
        int wheels = Integer.parseInt(wheelsFieldM.getText());
        String typeOfMotorcycle = typeFieldM.getText();
        String motorcycleMark = markFieldM.getText();
        Transport motorcycle = new Motorcycle(name, number, wheels, sittingPlaces, typeOfMotorcycle, motorcycleMark);
        binarySave(motorcycle, 2);
    }

    private void binarySave(Transport object, int type){
        try {
            FileOutputStream outputStream;
            if(type == 1){
                outputStream = new FileOutputStream("src\\OD\\overlandCar.txt");
            }else{
                outputStream = new FileOutputStream("src\\OD\\overlandMotorcycle.txt");
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binaryDeserializationCar(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\OD\\overlandCar.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Car object = (Car) objectInputStream.readObject();
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            wheelsField.setText(Integer.toString(object.getWheels()));
            placesField.setText(Integer.toString(object.getSittingPlaces()));
            typeField.setText(object.getTypeOfCar());
            markField.setText(object.getCarMark());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binaryDeserializationMotorcycle(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\OD\\overlandMotorcycle.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Motorcycle object = (Motorcycle) objectInputStream.readObject();
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            wheelsField.setText(Integer.toString(object.getWheels()));
            placesField.setText(Integer.toString(object.getSittingPlaces()));
            typeField.setText(object.getTypeOfMotorcycle());
            markField.setText(object.getMarkOfMotorcycle());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void textSerializationCar(){
        File file = new File("src\\OD\\overlandCar.txt");
        try {
            FileWriter writer = new FileWriter(file);
            String name = nameField.getText();
            String number = numberField.getText();
            int sittingPlaces = Integer.parseInt(placesField.getText());
            int wheels = Integer.parseInt(wheelsField.getText());
            String typeOfCar = typeField.getText();
            String carMark = markField.getText();
            StringBuilder builder = new StringBuilder();
            builder.append(name + " " + number + " " + sittingPlaces + " " + wheels + " " + typeOfCar + " " + carMark);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void textSerializationMotorcycle(){
        File file = new File("src\\OD\\overlandMotorcycle.txt");
        try {
            FileWriter writer = new FileWriter(file);
            String name = nameFieldM.getText();
            String number = numberFieldM.getText();
            int sittingPlaces = Integer.parseInt(placesFieldM.getText());
            int wheels = Integer.parseInt(wheelsFieldM.getText());
            String typeOfCar = typeFieldM.getText();
            String carMark = markFieldM.getText();
            StringBuilder builder = new StringBuilder();
            builder.append(name + " " + number + " " + sittingPlaces + " " + wheels + " " + typeOfCar + " " + carMark);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void textDeserializationCar(){
        File file = new File("src\\OD\\overlandCar.txt");
        try {
            Scanner sc = new Scanner(file);
            String str = sc.nextLine();
            String[] input = str.split(" ");
            Car object = new Car(input[0], input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), input[4], input[5]);
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            wheelsField.setText(Integer.toString(object.getWheels()));
            placesField.setText(Integer.toString(object.getSittingPlaces()));
            typeField.setText(object.getTypeOfCar());
            markField.setText(object.getCarMark());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void textDeserializationMotorcycle(){
        File file = new File("src\\OD\\overlandMotorcycle.txt");
        try {
            Scanner sc = new Scanner(file);
            String str = sc.nextLine();
            String[] input = str.split(" ");
            Motorcycle object = new Motorcycle(input[0], input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), input[4], input[5]);
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            wheelsField.setText(Integer.toString(object.getWheels()));
            placesField.setText(Integer.toString(object.getSittingPlaces()));
            typeField.setText(object.getTypeOfMotorcycle());
            markField.setText(object.getMarkOfMotorcycle());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
