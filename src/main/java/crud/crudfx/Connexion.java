package crud.crudfx;
import bdd.bdd;
import javafx.event.ActionEvent;
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
            throw new IllegalArgumentException("Adresse e-mail invalide");

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
            System.out.println("Vous êtes connecté");
            HelloApplication.sceneConnexion("tableau_user");

        }else {
            System.out.println("Mail ou MDP incorrect !");
            HelloApplication.sceneConnexion("loginpage");
        }
    }
}
