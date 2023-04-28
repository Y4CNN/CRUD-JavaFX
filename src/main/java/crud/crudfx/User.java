package crud.crudfx;

import bdd.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private int id_user;
    private String nom;
    private String prenom;
    private String mail;
    private int est_admin;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public int getEst_admin() {
        return est_admin;
    }

    public void setEst_admin(int est_admin) {
        this.est_admin = est_admin;
    }

    public User() throws Exception {
    }

    public User(int id_user, String nom, String prenom, String mail, int est_admin) throws Exception {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.est_admin = est_admin;
    }


}
