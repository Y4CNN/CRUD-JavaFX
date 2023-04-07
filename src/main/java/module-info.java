module crud.crudfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.mail;


    opens crud.crudfx to javafx.fxml;
    exports crud.crudfx;
}