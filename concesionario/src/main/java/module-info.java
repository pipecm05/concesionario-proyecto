module interfaz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens interfaz.controllers to javafx.fxml;
    
    exports interfaz;
}
