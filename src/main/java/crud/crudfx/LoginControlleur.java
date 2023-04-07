package crud.crudfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginControlleur {

    @FXML
    private Button login;

    @FXML
    private TextField mail;

    @FXML
    private PasswordField mdp;

    @FXML
    private Button oublie;

    Connexion uneConnexion = new Connexion();

    public LoginControlleur() throws Exception {
    }

    @FXML
    void login(ActionEvent event) throws SQLException {
        HelloApplication.sceneConnexion("hello-view");
        uneConnexion.setMail(mail.getText());
        uneConnexion.setMdp(mdp.getText());
        uneConnexion.showInfo();
        uneConnexion.verif();

    }

    @FXML
    void oublie(ActionEvent event) {
        HelloApplication.sceneConnexion("mdp_oublie");
    }

    @FXML
    void retour(ActionEvent event){
        HelloApplication.sceneConnexion("hello-view");
    }

}
