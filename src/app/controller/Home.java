package app.controller;

import eu.hansolo.medusa.Clock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import app.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private Clock clock;
    @FXML
    private Button btnAdministration;
    private Stage primaryStage;

    // constructor for Home controller
    public Home() {
        this.primaryStage = Main.getPrimaryStage();
    }


    public void handleBtnAdministration(ActionEvent actionEvent) throws IOException {
        // change primary stage to admin login view
        Parent root = FXMLLoader.load(getClass().getResource("../view/AdminLogin.fxml"));
        primaryStage.setTitle("Time & Attendance System - Administracija");
        primaryStage.setScene(new Scene(root, 700, 675));
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clock.setSkinType(Clock.ClockSkinType.SLIM);
        clock.setPrefSize(174, 174);
        clock.setRunning(true);

        // remove focus from buttons
        btnAdministration.setFocusTraversable(false);
    }
}
