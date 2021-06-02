package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public void overLandButton() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Overland.fxml"));
        primaryStage.setTitle("Overland");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void seaButton() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Sea.fxml"));
        primaryStage.setTitle("Sea");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void airButton() throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("air.fxml"));
        primaryStage.setTitle("Air");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
