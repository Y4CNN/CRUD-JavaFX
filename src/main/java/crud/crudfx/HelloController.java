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
    private TextField nom;

    @FXML
    private TextField  prenom;



    Connexion uneConnexion = new Connexion();
    Inscription uneInscription = new Inscription();

    public HelloController() throws Exception {
    }

    @FXML
    void showLogin(ActionEvent event) {
        HelloApplication.sceneConnexion("loginpage");
    }

    @FXML
    void showSignin(ActionEvent event) {
        HelloApplication.sceneConnexion("signinpage");
    }

    @FXML
    void login(ActionEvent event) throws Exception {
        HelloApplication.sceneConnexion("hello-view");
        uneConnexion.setMail(mail.getText());
        uneConnexion.setMdp(mdp.getText());
        uneConnexion.showInfo();
        uneConnexion.verif();

    }

    @FXML
    void inscription(ActionEvent event) throws Exception{
        uneInscription.setNom(nom.getText());
        uneInscription.setPrenom(prenom.getText());
        uneInscription.setMail(mail.getText());
        uneInscription.setMdp(mdp.getText());
        uneInscription.ajout();

    }

    @FXML
    void oublie(ActionEvent event) throws Exception {
        HelloApplication.sceneConnexion("mdp_oublie");


    }


}