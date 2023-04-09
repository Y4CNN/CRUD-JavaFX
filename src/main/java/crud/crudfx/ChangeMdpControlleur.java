package crud.crudfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ChangeMdpControlleur {

    @FXML
    private TextField newmdp;

    @FXML
    private Button valider;

    @FXML
    private TextField verifmdp;

    private String mdp2;

    UpdateMdp changeMDP = new UpdateMdp();

    public ChangeMdpControlleur() throws Exception {
    }

    public String getMdp2() {
        return mdp2;
    }

    public void setMdp2(String mdp2) {
        this.mdp2 = mdp2;
    }

    @FXML
    void updateMdp(ActionEvent event) throws SQLException {
        changeMDP.setNewMdp(String.valueOf(newmdp.getText()));
        setMdp2(verifmdp.getText());

        if(newmdp.getText().equals(getMdp2())){
            System.out.println("Mot de passe changé avec succès !");
            changeMDP.UpdateDuMdp();
            HelloApplication.sceneConnexion("loginpage");
        } else {
            System.out.println("Erreur : les mots de passe ne correspondent pas !");
        }
    }


}