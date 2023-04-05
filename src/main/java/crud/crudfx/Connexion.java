package crud.crudfx;
import bdd.bdd;

public class Connexion {
    private String mail;
    private String mdp;

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
}
