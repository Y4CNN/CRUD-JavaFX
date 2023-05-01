package crud.crudfx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;
import java.util.Random;

public class MotDePasseOublieControlleur {

    @FXML
    private Button retour;

    @FXML
    private Button envoyer;

    @FXML
    private TextField mail;

    @FXML
    private TextField code;

    private int code_send;

    private static String leMail;

    public String getLeMail() {
        return leMail;
    }

    public void setLeMail(String leMail) {
        this.leMail = leMail;
    }

    public void generateCode() {
        Random rand = new Random();
        this.code_send = rand.nextInt(90000) + 10000;
    }

    public int getCode() {
        return this.code_send;
    }


    @FXML
    void sendmdp(ActionEvent event) {
        final String fromEmail = "kiwi.vert143@gmail.com"; //requires valid gmail id
        final String password = "clvibbuleyhtgnms"; // correct password for gmail id
        final String toEmail = mail.getText();


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        generateCode();
        jakarta.EmailUtil.sendEmail(session, toEmail,
                "Récupération de votre mot de passe",
                "Nous avons bien reçu votre demande de récupération de mot de passe. Nous comprenons qu'il est facile d'oublier un mot de passe, et nous sommes là pour vous aider." +
                        "Voici votre code : "+ getCode());


    }


    @FXML
    void verifier(ActionEvent event) {
        setLeMail(mail.getText());
        String code1 = code.getText();
        int monCode = Integer.parseInt(code1);


        if (monCode == code_send){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succés !");
            alert.setContentText("Code correct vous pouvez changer de mot de passe");
            alert.showAndWait();
            System.out.println(getLeMail());
            HelloApplication.sceneConnexion("change_mdp");
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("! ERREUR !");
            alert.setContentText("LE CODE NE CORRESPOND PAS, VEUILLEZ REESSAYER !");
            alert.showAndWait();
        }


    }

    @FXML
    void retour(ActionEvent event){
        HelloApplication.sceneConnexion("loginpage");
    }
}
