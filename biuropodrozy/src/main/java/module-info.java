module com.example.biuropodrozy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.biuropodrozy to javafx.fxml;
    exports com.example.biuropodrozy;
}