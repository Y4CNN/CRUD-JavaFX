package crud.crudfx;
import bdd.bdd;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connexion  {
    private String mail;
    private String mdp;

    Connection maConnexion = bdd.getConnection();

    public Connexion() throws Exception {
    }

    public void showInfo(){
        System.out.println(getMail());
        System.out.println(getMdp());
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if(mail.matches(regex)) {
            this.mail = mail;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR !");
            alert.setContentText("ADRESSE MAIL NON COMFORME !");
            alert.showAndWait();

        }
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void verif() throws SQLException {

        PreparedStatement utilisateur = maConnexion.prepareStatement("SELECT * FROM user WHERE mail = ? AND mdp = MD5(CONCAT(?));");
        utilisateur.setString(1, mail);
        utilisateur.setString(2, mdp);
        ResultSet result = utilisateur.executeQuery();

        if (result.next()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succés !");
            alert.setContentText("Connexion réussie !");
            alert.showAndWait();
            HelloApplication.sceneConnexion("tableau_user");

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("MAIL OU MOT DE PASSE INCORRET !!");
            alert.showAndWait();
            HelloApplication.sceneConnexion("loginpage");
        }
    }
}
