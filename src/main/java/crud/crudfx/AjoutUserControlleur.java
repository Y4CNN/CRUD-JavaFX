package crud.crudfx;

import bdd.bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjoutUserControlleur {

    int est_admin;

    @FXML
    private TextField mail;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button retour;

    @FXML
    private Button send;

    @FXML
    private CheckBox status;

    public AjoutUserControlleur() throws Exception {
    }

    public class PasswordGenerator {
        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        private static SecureRandom random = new SecureRandom();

        public static String generate(int length) {
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(randomIndex));
            }
            return sb.toString();
        }
    }

    String password = PasswordGenerator.generate(12);

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.sceneConnexion("tableau_user");
    }

    @FXML
    void definiStatus(ActionEvent event) {
        if(status.isSelected()){
            est_admin = 0;
        }else {
            est_admin = 1;
        }

    }

    Connection maConnexion = bdd.getConnection();

    @FXML
    void valider(ActionEvent event) throws SQLException {
        PreparedStatement insert = maConnexion.prepareStatement("INSERT INTO user (nom, prenom, mail,mdp, est_admin) VALUES (?,?,?,?,?);");
        insert.setString(1, nom.getText());
        insert.setString(2, prenom.getText());
        insert.setString(3, mail.getText());
        insert.setString(4,password);
        insert.setString(5, String.valueOf(est_admin));
        insert.executeUpdate();

        HelloApplication.sceneConnexion("tableau_user");
    }

}
