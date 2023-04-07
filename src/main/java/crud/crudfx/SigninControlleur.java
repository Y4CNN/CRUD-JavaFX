package crud.crudfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SigninControlleur {

    @FXML
    private TextField mail;

    @FXML
    private TextField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button send;

    @FXML
    private Button retour;

    Inscription uneInscription = new Inscription();

    public SigninControlleur() throws Exception {
    }

    @FXML
    void inscription(ActionEvent event) throws Exception {
        uneInscription.setNom(nom.getText());
        uneInscription.setPrenom(prenom.getText());
        uneInscription.setMail(mail.getText());
        uneInscription.setMdp(mdp.getText());
        uneInscription.ajout();
    }

    @FXML
    void retour(ActionEvent event){
        HelloApplication.sceneConnexion("hello-view");
    }

}
