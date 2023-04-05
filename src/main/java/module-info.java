module crud.crudfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens crud.crudfx to javafx.fxml;
    exports crud.crudfx;
}