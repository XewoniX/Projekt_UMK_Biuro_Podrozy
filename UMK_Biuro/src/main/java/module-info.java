module com.example.umk_biuro {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires javafx.graphics;

    requires mysql.connector.java;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires eu.hansolo.tilesfx;

    opens com.example.umk_biuro to javafx.fxml;
    exports com.example.umk_biuro;
}