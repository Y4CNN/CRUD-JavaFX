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
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void verif() throws SQLException {

        PreparedStatement utilisateur = maConnexion.prepareStatement("SELECT * FROM user WHERE mdp = ? and mail = ?;");
        utilisateur.setString(1, mdp);
        utilisateur.setString(2, mail);
        ResultSet result = utilisateur.executeQuery();

        if (result.next()) {
            System.out.println("Vous êtes connecté");
            HelloApplication.sceneConnexion("logged");
        }else {
            System.out.println("Mail ou MDP incorrect !");
            HelloApplication.sceneConnexion("loginpage");
        }
    }
}
