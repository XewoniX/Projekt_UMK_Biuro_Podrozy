package com.example.umk_biuro;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class AddController implements Initializable {

    @FXML
    Label label0,label1,label2,label3,output;

    @FXML
    TextField textfield0,textfield1,textfield2,textfield3;
    @FXML
    ComboBox cBox;

    private final String[] options = {"grupa","opinia przewodnika","przeprowadzenie wycieczki","przewodnik","przynaleznosc do grupy","terminarz przewodnikow","turysta", "wycieczka"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cBox.getItems().addAll(options);
    }

    @FXML
    private void showInputs(ActionEvent event){
        try {
            if(Objects.equals(cBox.getValue(), "grupa")) {
                label0.setText("PESEL_przewodnika");
                label1.setText("");
                label2.setText("");
                label3.setText("");
                textfield0.setDisable(false);
                textfield1.setDisable(true);
                textfield2.setDisable(true);
                textfield3.setDisable(true);
            } else if(Objects.equals(cBox.getValue(), "opinia przewodnika")){
                label0.setText("PESEL_przewodnika");
                label1.setText("Ocena");
                label2.setText("Opis");
                label3.setText("");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
                textfield2.setDisable(false);
                textfield3.setDisable(true);
            } else if(Objects.equals(cBox.getValue(), "przeprowadzenie wycieczki")){
                label0.setText("ID_Grupy");
                label1.setText("ID_Wycieczki");
                label2.setText("");
                label3.setText("");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
                textfield2.setDisable(true);
                textfield3.setDisable(true);
            } else if(Objects.equals(cBox.getValue(), "przewodnik")){
                label0.setText("PESEL");
                label1.setText("Imie");
                label2.setText("Nazwisko");
                label3.setText("Data_rozpoczecia_pracy");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
                textfield2.setDisable(false);
                textfield3.setDisable(false);
            } else if(Objects.equals(cBox.getValue(), "przewodnik")){
                label0.setText("PESEL");
                label1.setText("Imie");
                label2.setText("Nazwisko");
                label3.setText("Data_rozpoczecia_pracy");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
                textfield2.setDisable(false);
                textfield3.setDisable(false);
            } else if(Objects.equals(cBox.getValue(), "przynaleznosc do grupy")){
                label0.setText("ID_Grupy");
                label1.setText("ID_Turysty");
                label2.setText("");
                label3.setText("");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
                textfield2.setDisable(true);
                textfield3.setDisable(true);
            } else if(Objects.equals(cBox.getValue(), "terminarz przewodnikow")){
                label0.setText("PESEL_przewodnika");
                label1.setText("Data_rozpoczecia");
                label2.setText("Data_zakonczenia");
                label3.setText("");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
                textfield2.setDisable(false);
                textfield3.setDisable(true);
            } else if(Objects.equals(cBox.getValue(), "turysta")){
                label0.setText("Imie");
                label1.setText("Nazwisko");
                label2.setText("Email");
                label3.setText("");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
                textfield2.setDisable(false);
                textfield3.setDisable(true);
            } else if(Objects.equals(cBox.getValue(), "wycieczka")){
                label0.setText("Data_rozpoczecia");
                label1.setText("Data_zakonczenia");
                label2.setText("Cena_biletu");
                label3.setText("Miejsce_wycieczki");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
                textfield2.setDisable(false);
                textfield3.setDisable(false);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void addDane(ActionEvent event){
        output.setText("");
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            Statement statement = connectDB.createStatement();
            int status = 0;
            if(Objects.equals(cBox.getValue(), "grupa")) {
                status = statement.executeUpdate("INSERT INTO Grupa(PESEL_przewodnika) VALUES ('" + textfield0.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "opinia przewodnika")){
                status = statement.executeUpdate("INSERT INTO OpiniaPrzewodnika(PESEL_przewodnika, Ocena, Opis) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "przeprowadzenie wycieczki")){
                status = statement.executeUpdate("INSERT INTO PrzeprowadzanieWycieczki(ID_Wycieczki, ID_Grupy) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "przewodnik")){
                status = statement.executeUpdate("INSERT INTO Przewodnik(PESEL, Imie, Nazwisko, Data_rozpoczecia_pracy) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "','" + textfield3.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "przynaleznosc do grupy")){
                status = statement.executeUpdate("INSERT INTO PrzynaleznoscDoGrupy(ID_Grupy, ID_Turysty) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "terminarz przewodnikow")){
                status = statement.executeUpdate("INSERT INTO TerminarzPrzewodnikow(PESEL_przewodnika, Data_rozpoczecia, Data_zakonczenia) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "','" + textfield3.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "turysta")){
                status = statement.executeUpdate("INSERT INTO Turysta(Imie, Nazwisko, Email) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "wycieczka")){
                status = statement.executeUpdate("INSERT INTO Wycieczka(Data_rozpoczecia, Data_zakonczenia, Cena_biletu, Miejsce_wycieczki) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "','" + textfield3.getText() + "');");
            }
            textfield0.setText(""); textfield1.setText(""); textfield2.setText(""); textfield3.setText("");
            if (status > 0) output.setText("Wprowadzenie danych do bazy powiodło się.");
            else output.setText("Wystąpił problem przy wprowadzaniu danych do bazy.");
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> output.setText(""));
                }
            }, 5000, 5000);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
