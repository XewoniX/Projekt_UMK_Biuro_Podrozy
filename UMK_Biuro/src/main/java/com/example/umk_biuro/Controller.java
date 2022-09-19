package com.example.umk_biuro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView table;
    @FXML
    private TableColumn table1;
    @FXML
    private TableColumn table2;
    @FXML
    private TableColumn table3;
    @FXML
    private TableColumn table4;
    @FXML
    private TableColumn table5;
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

    private String[] options = {"grupa","opinia przewodnika","przeprowadzenie wycieczki","przewodnik","przynaleznosc do grupy","terminarz przewodnikow","turysta",
            "wycieczka","---------------","grupa z przewodnikiem","grupy ilosci osob","przewodnik z ocenami","turysta i wycieczki","wycieczka dni srednia cena","wycieczka zarobek"};
    @FXML
    private TextField text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    choiceBox.getItems().addAll(options);
    }

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    public void usun(ActionEvent event) {
        try {
            String numer = text.getText();
            Statement statement = connectDB.createStatement();
            if(Objects.equals(choiceBox.getValue(), "turysta"))
            {
                int deleteCount = statement.executeUpdate("DELETE FROM `" + choiceBox.getValue() + "` WHERE ID_Turysty = " + numer + ";");
            }
            if(Objects.equals(choiceBox.getValue(), "grupa"))
            {
                int deleteCount = statement.executeUpdate("DELETE FROM `" + choiceBox.getValue() + "` WHERE ID_Grupy = " + numer + ";");
            }
            if(Objects.equals(choiceBox.getValue(), "opinia przewodnika"))
            {
                int deleteCount = statement.executeUpdate("DELETE FROM `" + "opiniaprzewodnika" + "` WHERE ID_Opinii = " + numer + ";");
            }
            if(Objects.equals(choiceBox.getValue(), "przeprowadzenie wycieczki"))
            {
                int deleteCount = statement.executeUpdate("DELETE FROM `" + "przeprowadzonewycieczki" + "` WHERE ID_Grupy = " + numer + ";");
            }
            if(Objects.equals(choiceBox.getValue(), "przewodnik"))
            {
                int deleteCount = statement.executeUpdate("DELETE FROM `" + choiceBox.getValue() + "` WHERE PESEL = " + numer + ";");
            }
            if(Objects.equals(choiceBox.getValue(), "przynaleznosc do grupy"))
            {
                int deleteCount = statement.executeUpdate("DELETE FROM `" + "przynaleznoscdogrupy" + "` WHERE ID_Grupy = " + numer + ";");
            }
            if(Objects.equals(choiceBox.getValue(), "terminarz przewodnikow"))
            {
                int deleteCount = statement.executeUpdate("DELETE FROM `" + "terminarzprzewodnikow" + "` WHERE ID_Terminu = " + numer + ";");
            }
            if(Objects.equals(choiceBox.getValue(), "wycieczka"))
            {
                int deleteCount = statement.executeUpdate("DELETE FROM `" + choiceBox.getValue() + "` WHERE ID_Wycieczki = " + numer + ";");
            }
            wyswietl(event);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void wyswietl(ActionEvent event) {
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            Statement statement = connectDB.createStatement();
            if (Objects.equals(choiceBox.getValue(), "turysta")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `turysta`;");
                Label0.setText("ID_Turysty"+"\n");
                Label1.setText("Imie"+"\n");
                Label2.setText("Nazwisko"+"\n");
                Label3.setText("Email"+"\n");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Turysty")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("imie")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Nazwisko")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Email")+"\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "grupa")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `grupa`;");
                Label0.setText("ID_Grupy"+"\n");
                Label1.setText("PESEL_przewodnika"+"\n");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("PESEL_przewodnika")+"\n");
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "opinia przewodnika")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `opiniaprzewodnika`;");
                Label0.setText("ID_Opinii"+"\n");
                Label1.setText("PESEL_przewodnika"+"\n");
                Label2.setText("Ocena"+"\n");
                Label3.setText("Opis"+"\n");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Opinii")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("PESEL_przewodnika")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Ocena")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Opis")+"\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "przeprowadzenie wycieczki")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `przeprowadzaniewycieczki`;");
                Label0.setText("ID_Grupy"+"\n");
                Label1.setText("ID_Wycieczki"+"\n");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("ID_Wycieczki")+"\n");
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "przewodnik")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `przewodnik`;");
                Label0.setText("PESEL"+"\n");
                Label1.setText("Imie"+"\n");
                Label2.setText("Nazwisko"+"\n");
                Label3.setText("Data rozpoczecia pracy"+"\n");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("PESEL")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Imie")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Nazwisko")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Data_rozpoczecia_pracy")+"\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "przynaleznosc do grupy")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `przynaleznoscdogrupy`;");
                Label0.setText("ID_Grupy"+"\n");
                Label1.setText("Id_Turysty"+"\n");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("ID_Turysty")+"\n");
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "terminarz przewodnikow")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `terminarzprzewodnikow`;");
                Label0.setText("ID_Terminu"+"\n");
                Label1.setText("PESEL przewodnika"+"\n");
                Label2.setText("Data rozpoczęcia"+"\n");
                Label3.setText("Data zakończenia"+"\n");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Terminu")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("PESEL_przewodnika")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Data_rozpoczecia")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Data_zakonczenia")+"\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "wycieczka")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `wycieczka`;");
                Label0.setText("ID_Wycieczki"+"\n");
                Label1.setText("Data rozpoczecia"+"\n");
                Label2.setText("Data zakonczenia"+"\n");
                Label3.setText("Data cena biletu"+"\n");
                Label4.setText("Miejsce wycieczki"+"\n");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Wycieczki")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Data_rozpoczecia")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Data_zakonczenia")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Cena_biletu")+"\n");
                    Label4.setText(Label4.getText() + "\n"  + queryOutputUserName.getString("Miejsce_wycieczki")+"\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "grupa z przewodnikiem")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `grupazprzewodnikiem`;");
                Label0.setText("ID_Grupy"+"\n");
                Label1.setText("PESEL"+"\n");
                Label2.setText("Imie"+"\n");
                Label3.setText("Nazwisko"+"\n");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy"+"\n"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("PESEL")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Imie")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Nazwisko")+"\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "grupy ilosci osob")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `grupyiloscosob`;");
                Label0.setText("ID_Grupy"+"\n");
                Label1.setText("Ilosc osob w grupie"+"\n");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Ilo?? os?b w grupie")+"\n");
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "przewodnik z ocenami")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `przewodnikzocenami`;");
                Label0.setText("PESEL"+"\n");
                Label1.setText("Imie"+"\n");
                Label2.setText("Nazwisko"+"\n");
                Label3.setText("Srednia ocena"+"\n");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("PESEL")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Imie")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Nazwisko")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("?rednia ocena")+"\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "turysta i wycieczki")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `turystaiwycieczki`;");
                Label0.setText("Imie"+"\n");
                Label1.setText("Nazwisko"+"\n");
                Label2.setText("ID_Turysty"+"\n");
                Label3.setText("ID_wycieczki"+"\n");
                Label4.setText("Miejsce wycieczki"+"\n");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("Imie")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Nazwisko")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("ID_Turysty")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("ID_wycieczki")+"\n");
                    Label4.setText(Label4.getText() + "\n"  + queryOutputUserName.getString("Miejsce_wycieczki")+"\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "wycieczka dni srednia cena")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `wycieczkadnisredniacena`;");
                Label0.setText("ID_Wycieczki"+"\n");
                Label1.setText("Ilosc dni"+"\n");
                Label2.setText("Cena biletu"+"\n");
                Label3.setText("Srednia cena za dzien"+"\n");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Wycieczki")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Ilo?? dni")+"\n");
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Cena_biletu")+"\n");
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("?rednia cena za 1 dzie?")+"\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "wycieczka zarobek")) {
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `wycieczkazarobek`;");
                Label0.setText("ID_Wycieczki"+"\n");
                Label1.setText("przychod"+"\n");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Wycieczki")+"\n");
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("przychód")+"\n");
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            } catch(Exception e){
                e.printStackTrace();
            }
    }

    public void addDane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addDane.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dodaj dane");
        stage.initOwner(Label0.getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }
}
