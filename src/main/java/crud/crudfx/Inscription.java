package crud.crudfx;

import bdd.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Inscription {

    private String nom;
    private String prenom;
    private String mail;
    private String mdp;

    Connection maConnexion = bdd.getConnection();

    public Inscription() throws Exception {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public void ajout() throws Exception{

        PreparedStatement insert = maConnexion.prepareStatement("INSERT INTO user (nom, prenom, mail, mdp,est_admin) VALUES (?,?,?,?,?);");
        insert.setString(1, getNom());
        insert.setString(2, getPrenom());
        insert.setString(3, getMail());
        insert.setString(4, getMdp());
        insert.setInt(5, 1);
        insert.executeUpdate();

        HelloApplication.sceneConnexion("registred");
    }



}
