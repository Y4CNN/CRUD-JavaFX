package crud.crudfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import bdd.bdd;
import javafx.scene.control.TextField;

public class HelloController {

    public Button login;
    @FXML
    private TextField mail;

    @FXML
    private TextField mdp;

    @FXML
    void showLogin(ActionEvent event){
        HelloApplication.sceneConnexion("loginpage");
    }

    @FXML
    void login(ActionEvent event){
        HelloApplication.sceneConnexion("hello-view");
        Connexion uneConnexion = new Connexion();
        uneConnexion.setMail(mail.getText());
        uneConnexion.setMdp(mdp.getText());
        uneConnexion.showInfo();

    }




}