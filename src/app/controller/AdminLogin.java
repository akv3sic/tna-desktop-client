package app.controller;

import app.Main;
import app.api.ApiServiceImpl;
import app.helpers.Email;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLogin implements Initializable  {

    private final Stage primaryStage;
    public MFXButton btnLogin;
    public Label errorLabel;

    @FXML
    TextField emailTxt;
    @FXML
    PasswordField passTxt;

    private ApiServiceImpl apiService = ApiServiceImpl.getInstance();

    // constructor for AdminLogin controller
    public AdminLogin() {
        this.primaryStage = Main.getPrimaryStage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleBtnLogin(ActionEvent e) throws IOException {

        String email = emailTxt.getText();
        String pass = passTxt.getText();

        // e-mail and password validation
        if (email.equals("") || pass.equals("")){
            errorLabel.setText("Potrebno je popuniti oba polja.");
        }

        else if(isValidEmailAddress(email)){

        }
        else {
            errorLabel.setText("E-adresa nije valjana.");
        }
    }

    private boolean isValidEmailAddress(String email) {
        Email eMailHelper = new Email();
        return eMailHelper.isValid(email);
    }

    public void handleBtnBack(ActionEvent actionEvent) {
        // change primary stage to home view
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
            primaryStage.setTitle("Time & Attendance System");
            primaryStage.setScene(new Scene(root, 700, 675));
            primaryStage.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
