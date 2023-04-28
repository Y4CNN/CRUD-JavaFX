package crud.crudfx;

import bdd.bdd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableauControlleur {

    @FXML
    private Button add;

    @FXML
    private TableColumn<User, Integer> admin;

    @FXML
    private Button delete;

    @FXML
    private Button edit;

    @FXML
    private TableColumn<User, Integer> id;

    @FXML
    private TableColumn<User, String> mail;

    @FXML
    private TableColumn<User, String> nom;

    @FXML
    private TableColumn<User, String> prenom;

    @FXML
    private TableView<User> tableau;

    public ObservableList<User> data = FXCollections.observableArrayList();

    Connection maConnexion = bdd.getConnection();


    public TableauControlleur() throws Exception {
    }

    @FXML
    void afficherUser(ActionEvent event) throws Exception {

        PreparedStatement stat = maConnexion.prepareStatement("SELECT * FROM user");
        ResultSet rs = stat.executeQuery();
        while (rs.next()){
            data.add(new User(rs.getInt("id_user"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getInt("est_admin")));
        }
        id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id_user"));
        nom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        mail.setCellValueFactory(new PropertyValueFactory<User, String>("mail"));
        admin.setCellValueFactory(new PropertyValueFactory<User, Integer>("est_admin"));
        tableau.setItems(data);
    }

    @FXML
    void ajoutUser(ActionEvent event){
        HelloApplication.sceneConnexion("adduser");
    }

    @FXML
    void modifUser(ActionEvent event) {

    }

    @FXML
    void suppUser(ActionEvent event) throws Exception {

        ObservableList<User> userselected;
        userselected=tableau.getSelectionModel().getSelectedItems();

        PreparedStatement delete = maConnexion.prepareStatement("DELETE FROM user WHERE id_user LIKE "+ userselected.get(0).getId_user());
        delete.executeUpdate();

        System.out.println("L'utilisateur "+ userselected.get(0).getId_user() +" a été supprimer !");

        HelloApplication.sceneConnexion("tableau_user");
    }


}
