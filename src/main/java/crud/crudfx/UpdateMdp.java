package crud.crudfx;
import bdd.bdd;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateMdp {

    private String newMdp;

    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String Mail) {
        this.mail = Mail;
    }


    public String getNewMdp() {
        return newMdp;
    }

    public void setNewMdp(String newMdp) {
        this.newMdp = newMdp;
    }

    Connection maConnexion = bdd.getConnection();
    MotDePasseOublieControlleur mdpOublie = new MotDePasseOublieControlleur();

    public UpdateMdp() throws Exception {
    }




    public void UpdateDuMdp() throws SQLException {
        PreparedStatement update = maConnexion.prepareStatement("UPDATE user SET mdp = MD5(?) WHERE mail = ?");
        update.setString(1, getNewMdp());
        update.setString(2, mdpOublie.getLeMail());
        update.executeUpdate();
    }
}
