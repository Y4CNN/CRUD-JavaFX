package crud.crudfx;

import bdd.bdd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableauControlleur {
    @FXML
    private TableColumn<User, Integer> admin;


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

    @FXML
    private TextField showmail;

    @FXML
    private TextField shownom;

    @FXML
    private TextField showprenom;

    @FXML
    private TextField showstatus;

    public ObservableList<User> data = FXCollections.observableArrayList();

    Connection maConnexion = bdd.getConnection();


    public TableauControlleur() throws Exception {
    }

    @FXML
    void ajoutUser(ActionEvent event){
        HelloApplication.sceneConnexion("adduser");
    }

    @FXML
    void selectUser(ActionEvent event) throws SQLException {
        ObservableList<User> userselected;
        userselected = tableau.getSelectionModel().getSelectedItems();

        if (userselected.size() > 0) {
            PreparedStatement showInfo = maConnexion.prepareStatement("SELECT * FROM user WHERE id_user = ?");
            showInfo.setInt(1, userselected.get(0).getId_user());
            ResultSet showUser = showInfo.executeQuery();
            if (showUser.next()) {
                shownom.setText(showUser.getString("nom"));
                showprenom.setText(showUser.getString("prenom"));
                showmail.setText(showUser.getString("mail"));
                showstatus.setText(String.valueOf(showUser.getInt("est_admin")));
            }
        }else {
            System.out.println("Veuillez sélectionner un utilisateur à modifier.");
        }
    }

    @FXML
    void modifUser(ActionEvent event) throws SQLException {
        ObservableList<User> userselected = tableau.getSelectionModel().getSelectedItems();
        if (userselected.size() > 0) {
            PreparedStatement update = maConnexion.prepareStatement("UPDATE user SET nom = ?, prenom = ?, mail = ?, est_admin = ? WHERE id_user = ?");
            update.setString(1, shownom.getText());
            update.setString(2, showprenom.getText());
            update.setString(3, showmail.getText());
            update.setInt(4, Integer.parseInt(showstatus.getText()));
            update.setInt(5, userselected.get(0).getId_user());
            update.executeUpdate();
        } else {
            System.out.println("Veuillez sélectionner un utilisateur à modifier.");
        }
    }



    @FXML
    void suppUser(ActionEvent event) throws Exception {

        ObservableList<User> userselected;
        userselected=tableau.getSelectionModel().getSelectedItems();

        PreparedStatement delete = maConnexion.prepareStatement("DELETE FROM user WHERE id_user = ?");
        delete.setInt(1, userselected.get(0).getId_user());
        delete.executeUpdate();

        System.out.println("L'utilisateur "+ userselected.get(0).getId_user() +" a été supprimer !");

        HelloApplication.sceneConnexion("tableau_user");
    }


    @FXML
    void refreshData(ActionEvent event) throws Exception {
        data.clear();

        PreparedStatement stat = maConnexion.prepareStatement("SELECT * FROM user");
        ResultSet rs = stat.executeQuery();
        while (rs.next()) {
            data.add(new User(rs.getInt("id_user"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getInt("est_admin")));
        }

        tableau.setItems(data);
    }



    public void initialize() throws Exception {
        System.out.println("Bienvenue sur l'interface administrateur");
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
    void retour(ActionEvent event){
        HelloApplication.sceneConnexion("loginpage");
    }




}
