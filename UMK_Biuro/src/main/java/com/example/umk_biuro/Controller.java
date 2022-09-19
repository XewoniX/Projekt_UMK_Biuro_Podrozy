package com.example.umk_biuro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label Label0;
    @FXML
    private Label Label1;
    @FXML
    private Label Label2;
    @FXML
    private Label Label3;
    @FXML
    private Label Label4;
    @FXML
    private ChoiceBox<String> choiceBox;

    private String[] options = {"grupa","opinia przewodnika","przeprowadzenie wycieczki","przewodnik","przynaleznosc do grupy","terminarz przewodnikow","turysta","wycieczka","grupa z przewodnikiem","grupy ilosci osob","przewodnik z ocenami","turysta i wycieczki","wycieczka dni srednia ocen","wycieczka zarobek"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    choiceBox.getItems().addAll(options);
    }


    public void wyswietl(ActionEvent event) {


        try {
            if (Objects.equals(choiceBox.getValue(), "turysta")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `turysta`;");
                Label0.setText("ID_Turysty");
                Label1.setText("Imie");
                Label2.setText("Nazwisko");
                Label3.setText("Email");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Turysty"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("imie"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Nazwisko"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Email"));
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "grupa")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `grupa`;");
                Label0.setText("ID_Grupy");
                Label1.setText("PESEL_przewodnika");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("PESEL_przewodnika"));
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "opinia przewodnika")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `opiniaprzewodnika`;");
                Label0.setText("ID_Opinii");
                Label1.setText("PESEL_przewodnika");
                Label2.setText("Ocena");
                Label3.setText("Opis");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Opinii"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("PESEL_przewodnika"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Ocena"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Opis"));
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            } catch(Exception e){
                e.printStackTrace();
            }

    }
}
