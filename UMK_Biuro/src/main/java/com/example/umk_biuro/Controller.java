package com.example.umk_biuro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
        }
    catch(Exception e){
        e.printStackTrace();
    }
    }
    public void wyswietl(ActionEvent event) {
        try {

            if (Objects.equals(choiceBox.getValue(), "turysta")) {
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

            if (Objects.equals(choiceBox.getValue(), "przeprowadzenie wycieczki")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `przeprowadzaniewycieczki`;");
                Label0.setText("ID_Grupy");
                Label1.setText("ID_Wycieczki");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("ID_Wycieczki"));
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "przewodnik")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `przewodnik`;");
                Label0.setText("PESEL");
                Label1.setText("Imie");
                Label2.setText("Nazwisko");
                Label3.setText("Data rozpoczecia pracy");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("PESEL"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Imie"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Nazwisko"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Data_rozpoczecia_pracy"));
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "przynaleznosc do grupy")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `przynaleznoscdogrupy`;");
                Label0.setText("ID_Grupy");
                Label1.setText("Id_Turysty");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("ID_Turysty"));
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }


            if (Objects.equals(choiceBox.getValue(), "terminarz przewodnikow")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `terminarzprzewodnikow`;");
                Label0.setText("ID_Terminu");
                Label1.setText("PESEL przewodnika");
                Label2.setText("Data rozpoczęcia");
                Label3.setText("Data zakończenia");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Terminu"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("PESEL_przewodnika"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Data_rozpoczecia"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Data_zakonczenia"));
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "wycieczka")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `wycieczka`;");
                Label0.setText("ID_Wycieczki");
                Label1.setText("Data rozpoczecia");
                Label2.setText("Data zakonczenia");
                Label3.setText("Data cena biletu");
                Label4.setText("Miejsce wycieczki");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Wycieczki"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Data_rozpoczecia"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Data_zakonczenia"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Cena_biletu"));
                    Label4.setText(Label4.getText() + "\n"  + queryOutputUserName.getString("Miejsce_wycieczki"));
                }
            }

            if (Objects.equals(choiceBox.getValue(), "grupa z przewodnikiem")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `grupazprzewodnikiem`;");
                Label0.setText("ID_Grupy");
                Label1.setText("PESEL");
                Label2.setText("Imie");
                Label3.setText("Nazwisko");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("PESEL"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Imie"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("Nazwisko"));
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "grupy ilosci osob")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `grupyiloscosob`;");
                Label0.setText("ID_Grupy");
                Label1.setText("Ilosc osob w grupie");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Grupy"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Ilo?? os?b w grupie"));
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "przewodnik z ocenami")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `przewodnikzocenami`;");
                Label0.setText("PESEL");
                Label1.setText("Imie");
                Label2.setText("Nazwisko");
                Label3.setText("Srednia ocena");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("PESEL"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Imie"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Nazwisko"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("?rednia ocena"));
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "turysta i wycieczki")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `turystaiwycieczki`;");
                Label0.setText("Imie");
                Label1.setText("Nazwisko");
                Label2.setText("ID_Turysty");
                Label3.setText("ID_wycieczki");
                Label4.setText("Miejsce wycieczki");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("Imie"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Nazwisko"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("ID_Turysty"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("ID_wycieczki"));
                    Label4.setText(Label4.getText() + "\n"  + queryOutputUserName.getString("Miejsce_wycieczki"));
                }
            }

            if (Objects.equals(choiceBox.getValue(), "wycieczka dni srednia cena")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `wycieczkadnisredniacena`;");
                Label0.setText("ID_Wycieczki");
                Label1.setText("Ilosc dni");
                Label2.setText("Cena biletu");
                Label3.setText("Srednia cena za dzien");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Wycieczki"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("Ilo?? dni"));
                    Label2.setText(Label2.getText() + "\n"  + queryOutputUserName.getString("Cena_biletu"));
                    Label3.setText(Label3.getText() + "\n"  + queryOutputUserName.getString("?rednia cena za 1 dzie?"));
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            if (Objects.equals(choiceBox.getValue(), "wycieczka zarobek")) {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                Statement statement = connectDB.createStatement();
                ResultSet queryOutputUserName = statement.executeQuery("SELECT * FROM `wycieczkazarobek`;");
                Label0.setText("ID_Wycieczki");
                Label1.setText("przychod");
                Label2.setText("");
                Label3.setText("");
                Label4.setText("");

                while (queryOutputUserName.next()) {
                    Label0.setText(Label0.getText() + "\n"  + queryOutputUserName.getString("ID_Wycieczki"));
                    Label1.setText(Label1.getText() + "\n"  + queryOutputUserName.getString("przych?d"));
                    Label2.setText(Label2.getText() + "\n");
                    Label3.setText(Label3.getText() + "\n");
                    Label4.setText(Label4.getText() + "\n");
                }
            }

            } catch(Exception e){
                e.printStackTrace();
            }

    }
}
