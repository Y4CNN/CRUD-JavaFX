package crud.crudfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import bdd.bdd;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button login;

    @FXML
    private Button signin;

    @FXML
    private Label message;

    @FXML
    void showLogin(ActionEvent event) {
        HelloApplication.sceneConnexion("loginpage");
    }

    @FXML
    void showSignin(ActionEvent event) {
        HelloApplication.sceneConnexion("signinpage");
    }



}