module crud.crudfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens crud.crudfx to javafx.fxml;
    exports crud.crudfx;
}