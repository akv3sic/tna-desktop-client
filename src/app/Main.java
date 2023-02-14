package app;

import app.controller.Home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Main extends Application {

    private static Scene homeScene;
    private String buffer;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    private static Stage primaryStage = new Stage();

    public static Scene getHomeScene() {
        return homeScene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        buffer = "";
        Parent root = FXMLLoader.load(getClass().getResource("view/Home.fxml"));
        primaryStage = Main.getPrimaryStage();
        primaryStage.setTitle("Time & Attendance System");
        primaryStage.getIcons().add(new Image("./assets/logo.png"));
        primaryStage.setScene(new Scene(root, 700, 675));


        Stage finalPrimaryStage = primaryStage;
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
            //System.out.println("Key pressed: " + event.toString());
            buffer = buffer + event.getText();
            //System.out.println(buffer);
            switch(event.getCode()) {
                case F5: { // F5 key -> go to full screen
                    finalPrimaryStage.setFullScreen(!finalPrimaryStage.isFullScreen());
                    break;
                }
                case ENTER: { // Enter -> activate RFID processing chain
                    //System.out.println("Enter clicked");

                    try {
                        handleRfidEvent();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    clearBuffer();
                }
                default:  {
                    // do nothing
                }
            }
        });

        primaryStage.requestFocus();
        primaryStage.show();
    }

    private void clearBuffer() {
        buffer = "";
    }


    private void handleRfidEvent() throws SQLException {
        if(isBufferValid()) {
            System.out.println("Card ID: " + buffer);
        }
    }

    private boolean isBufferValid() {
        try {
            this.buffer = buffer.substring(0,10);
            if (buffer.length() == 10 && buffer.matches("\\d{10}")) {
                return true;
            }
        }
        catch (Exception ex){
            System.out.println("RFID buffer greška: " + ex);
        }
        return false;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
