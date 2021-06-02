package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Scanner;

public class AirController {

    @FXML
    public TextField nameField;
    @FXML
    public TextField numberField;
    @FXML
    public TextField placesField;
    @FXML
    public TextField typeField;
    @FXML
    public CheckBox helixCheck;
    @FXML
    public CheckBox chassisCheck;
    @FXML
    public TextField nameFieldG;
    @FXML
    public TextField numberFieldG;
    @FXML
    public TextField placesFieldG;
    @FXML
    public TextField typeFieldG;
    @FXML
    public CheckBox helixCheckG;


    @FXML
    public void plain() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("plainInfo.fxml"));
        primaryStage.setTitle("Plain");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void glider() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("gliderInfo.fxml"));
        primaryStage.setTitle("Glider");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void xmlSerializationPlane(){
        String name = nameField.getText();
        String number = numberField.getText();
        int sittingPlaces = Integer.parseInt(placesField.getText());
        boolean helix = helixCheck.isSelected();
        String typeOfPlane = typeField.getText();
        boolean aquaChassis = chassisCheck.isSelected();
        Transport plain = new Plain(name, number, sittingPlaces, helix, aquaChassis, typeOfPlane);
        xmlSave(plain,1);
    }

    @FXML
    public void xmlSerializationGlider(){
        String name = nameFieldG.getText();
        String number = numberFieldG.getText();
        int sittingPlaces = Integer.parseInt(placesFieldG.getText());
        boolean helix = helixCheckG.isSelected();
        String typeOfGlider = typeFieldG.getText();
        Transport glider = new Glider(name, number, sittingPlaces, helix, typeOfGlider);
        xmlSave(glider, 2);
    }

    private void xmlSave(Transport object, int type){
        try {
            XMLEncoder coder;
            if(type == 1){
                coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src\\AD\\airPlain.xml")));
            }else{
                coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src\\AD\\airGlider.xml")));
            }
            coder.writeObject(object);
            coder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void xmlDeserializationPlain(){
        try {
            FileInputStream input = new FileInputStream(new File("src\\AD\\airPlain.xml"));
            XMLDecoder decoder = new XMLDecoder(input);
            Plain object = (Plain) decoder.readObject();
            decoder.close();
            input.close();
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            placesField.setText(Integer.toString(object.getSittingPlaces()));
            typeField.setText(object.getTypeOfPlain());
            helixCheck.setSelected(object.isHelix());
            chassisCheck.setSelected(object.isAquaChassis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void xmlDeserializationGlider(){
        try {
            FileInputStream input = new FileInputStream(new File("src\\AD\\airGlider.xml"));
            XMLDecoder decoder = new XMLDecoder(input);
            Glider object = (Glider) decoder.readObject();
            decoder.close();
            input.close();
            nameFieldG.setText(object.getName());
            numberFieldG.setText(object.getNumber());
            placesFieldG.setText(Integer.toString(object.getSittingPlaces()));
            typeFieldG.setText(object.getTypeOfGlider());
            helixCheckG.setSelected(object.isHelix());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binarySerializationPlain(){
        String name = nameField.getText();
        String number = numberField.getText();
        int sittingPlaces = Integer.parseInt(placesField.getText());
        boolean helix = helixCheck.isSelected();
        String typeOfPlane = typeField.getText();
        boolean aquaChassis = chassisCheck.isSelected();
        Transport plain = new Plain(name, number, sittingPlaces, helix, aquaChassis, typeOfPlane);
        binarySave(plain, 1);
    }

    @FXML
    public void binarySerializationGlider(){
        String name = nameFieldG.getText();
        String number = numberFieldG.getText();
        int sittingPlaces = Integer.parseInt(placesFieldG.getText());
        boolean helix = helixCheckG.isSelected();
        String typeOfGlider = typeFieldG.getText();
        Transport glider = new Glider(name, number, sittingPlaces, helix, typeOfGlider);
        binarySave(glider, 2);
    }

    private void binarySave(Transport object, int type){
        try {
            FileOutputStream outputStream;
            if(type == 1){
                outputStream = new FileOutputStream("src\\AD\\airPlain.txt");
            }else{
                outputStream = new FileOutputStream("src\\OD\\airGlider.txt");
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binaryDeserializationPlain(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\AD\\airPlain.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Plain object = (Plain) objectInputStream.readObject();
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            placesField.setText(Integer.toString(object.getSittingPlaces()));
            typeField.setText(object.getTypeOfPlain());
            helixCheck.setSelected(object.isHelix());
            chassisCheck.setSelected(object.isAquaChassis());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void binaryDeserializationGlider(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\AD\\airGlider.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Glider object = (Glider) objectInputStream.readObject();
            nameFieldG.setText(object.getName());
            numberFieldG.setText(object.getNumber());
            placesFieldG.setText(Integer.toString(object.getSittingPlaces()));
            typeFieldG.setText(object.getTypeOfGlider());
            helixCheckG.setSelected(object.isHelix());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void textSerializationPlain(){
        File file = new File("src\\AD\\airPlain.txt");
        try {
            FileWriter writer = new FileWriter(file);
            String name = nameField.getText();
            String number = numberField.getText();
            int sittingPlaces = Integer.parseInt(placesField.getText());
            boolean helix = helixCheck.isSelected();
            String typeOfPlane = typeField.getText();
            boolean aquaChassis = chassisCheck.isSelected();
            StringBuilder builder = new StringBuilder();
            builder.append(name + " " + number + " " + sittingPlaces + " " + helix + " " + typeOfPlane + " " + aquaChassis);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void textSerializationGlider(){
        File file = new File("src\\AD\\airGlider.txt");
        try {
            FileWriter writer = new FileWriter(file);
            String name = nameFieldG.getText();
            String number = numberFieldG.getText();
            int sittingPlaces = Integer.parseInt(placesFieldG.getText());
            boolean helix = helixCheckG.isSelected();
            String typeOfGlider = typeFieldG.getText();
            StringBuilder builder = new StringBuilder();
            builder.append(name + " " + number + " " + sittingPlaces + " " + helix + " " + typeOfGlider);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void textDeserializationPlain(){
        File file = new File("src\\AD\\airPlain.txt");
        try {
            Scanner sc = new Scanner(file);
            String str = sc.nextLine();
            String[] input = str.split(" ");
            Plain object = new Plain(input[0], input[1], Integer.parseInt(input[2]), Boolean.parseBoolean(input[3]), Boolean.parseBoolean(input[5]), input[4]);
            nameField.setText(object.getName());
            numberField.setText(object.getNumber());
            placesField.setText(Integer.toString(object.getSittingPlaces()));
            typeField.setText(object.getTypeOfPlain());
            helixCheck.setSelected(object.isHelix());
            chassisCheck.setSelected(object.isAquaChassis());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void textDeserializationGlider(){
        File file = new File("src\\AD\\airGlider.txt");
        try {
            Scanner sc = new Scanner(file);
            String str = sc.nextLine();
            String[] input = str.split(" ");
            Glider object = new Glider(input[0], input[1], Integer.parseInt(input[2]), Boolean.parseBoolean(input[3]), input[4]);
            nameFieldG.setText(object.getName());
            numberFieldG.setText(object.getNumber());
            placesFieldG.setText(Integer.toString(object.getSittingPlaces()));
            typeFieldG.setText(object.getTypeOfGlider());
            helixCheckG.setSelected(object.isHelix());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
usage: git [--version] [--help] [-C <path>] [-c <name>=<value>]
           [--exec-path[=<path>]] [--html-path] [--man-path] [--info-path]
           [-p | --paginate | -P | --no-pager] [--no-replace-objects] [--bare]
           [--git-dir=<path>] [--work-tree=<path>] [--namespace=<name>]
           <command> [<args>]

These are common Git commands used in various situations:

start a working area (see also: git help tutorial)
   clone             Clone a repository into a new directory
   init              Create an empty Git repository or reinitialize an existing one

work on the current change (see also: git help everyday)
   add               Add file contents to the index
   mv                Move or rename a file, a directory, or a symlink
   restore           Restore working tree files
   rm                Remove files from the working tree and from the index
   sparse-checkout   Initialize and modify the sparse-checkout

examine the history and state (see also: git help revisions)
   bisect            Use binary search to find the commit that introduced a bug
   diff              Show changes between commits, commit and working tree, etc
   grep              Print lines matching a pattern
   log               Show commit logs
   show              Show various types of objects
   status            Show the working tree status

grow, mark and tweak your common history
   branch            List, create, or delete branches
   commit            Record changes to the repository
   merge             Join two or more development histories together
   rebase            Reapply commits on top of another base tip
   reset             Reset current HEAD to the specified state
   switch            Switch branches
   tag               Create, list, delete or verify a tag object signed with GPG

collaborate (see also: git help workflows)
   fetch             Download objects and refs from another repository
   pull              Fetch from and integrate with another repository or a local branch
   push              Update remote refs along with associated objects

'git help -a' and 'git help -g' list available subcommands and some
concept guides. See 'git help <command>' or 'git help <concept>'
to read about a specific subcommand or concept.
See 'git help git' for an overview of the system.
