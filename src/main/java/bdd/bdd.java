package bdd;

import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class bdd {
    public static void main(String args[]) {
        String mysqlAdresse = "localhost:3306";
        String mysqlBdd = "cruduser";
        String mysqlUser = "root";
        String mysqlPassword = "";
        Connection maConnexion;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            maConnexion = DriverManager.getConnection("jdbc:mysql://" + mysqlAdresse + "/" + mysqlBdd + "?serverTimezone=UTC", mysqlUser, mysqlPassword);
            System.out.println("Connexion réussie a la base de donnée");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
