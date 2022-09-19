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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class AddController implements Initializable {

    Boolean update = false;
    String klucz;
    @FXML
    Label label0,label1,label2,label3,output;

    @FXML
    TextField textfield0,textfield1,textfield2,textfield3,updateinput;
    @FXML
    ComboBox cBox;

    private final String[] options = {"grupa","opinia przewodnika","przeprowadzenie wycieczki","przewodnik","przynaleznosc do grupy","terminarz przewodnikow","turysta", "wycieczka"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cBox.getItems().addAll(options);
    }

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    private void setInfoText(String text){
        output.setText(text);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> output.setText(""));
            }
        }, 2000, 2000);
    }

    @FXML
    private void showInputs(ActionEvent event){
        update = false;
        klucz = "";
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
    private void getDaneUpdate(ActionEvent event) {
        try {
            Statement statement = connectDB.createStatement();
            if(Objects.equals(cBox.getValue(), "grupa")) {
                ResultSet queryOutput = statement.executeQuery("SELECT * FROM grupa WHERE ID_Grupy = '" + updateinput.getText() + "'");
                if(queryOutput.next() == false) {
                    setInfoText("Nie istnieje rekord o podanym kluczu w tabeli grupa");
                } else {
                    textfield0.setText(queryOutput.getString("PESEL_przewodnika"));
                    klucz = updateinput.getText();
                    update = true;
                }
            } else if(Objects.equals(cBox.getValue(), "opinia przewodnika")){
                ResultSet queryOutput = statement.executeQuery("SELECT * FROM opiniaprzewodnika WHERE ID_Opinii = '" + updateinput.getText() + "'");
                if(queryOutput.next() == false) {
                    setInfoText("Nie istnieje rekord o podanym kluczu w tabeli opiniaprzewodnika");
                } else {
                    textfield0.setText(queryOutput.getString("PESEL_przewodnika"));
                    textfield1.setText(queryOutput.getString("Ocena"));
                    textfield2.setText(queryOutput.getString("Opis"));
                    klucz = updateinput.getText();
                    update = true;
                }
            } else if(Objects.equals(cBox.getValue(), "przeprowadzenie wycieczki")){
                setInfoText("Nie ma podanej funcjonalności w tabeli przeprowadzaniewycieczki");
            } else if(Objects.equals(cBox.getValue(), "przewodnik")){
                ResultSet queryOutput = statement.executeQuery("SELECT * FROM przewodnik WHERE PESEL = '" + updateinput.getText() + "'");
                if(queryOutput.next() == false) {
                    setInfoText("Nie istnieje rekord o podanym kluczu w tabeli opiniaprzewodnika");
                } else {
                    textfield0.setText(queryOutput.getString("PESEL"));
                    textfield1.setText(queryOutput.getString("Imie"));
                    textfield2.setText(queryOutput.getString("Nazwisko"));
                    textfield3.setText(queryOutput.getString("Data_rozpoczecia_pracy"));
                    klucz = updateinput.getText();
                    update = true;
                }
            } else if(Objects.equals(cBox.getValue(), "przynaleznosc do grupy")){
                setInfoText("Nie ma podanej funcjonalności w tabeli przynaleznoscdogrupy");
            } else if(Objects.equals(cBox.getValue(), "terminarz przewodnikow")){
                ResultSet queryOutput = statement.executeQuery("SELECT * FROM terminarzprzewodnikow WHERE ID_Terminu = '" + updateinput.getText() + "'");
                if(queryOutput.next() == false) {
                    setInfoText("Nie istnieje rekord o podanym kluczu w tabeli terminarzprzewodnikow");
                } else {
                    textfield0.setText(queryOutput.getString("PESEL_przewodnika"));
                    textfield1.setText(queryOutput.getString("Data_rozpoczecia"));
                    textfield2.setText(queryOutput.getString("Data_zakonczenia"));
                    klucz = updateinput.getText();
                    update = true;
                }
            } else if(Objects.equals(cBox.getValue(), "turysta")){
                ResultSet queryOutput = statement.executeQuery("SELECT * FROM turysta WHERE ID_Turysty = '" + updateinput.getText() + "'");
                if(queryOutput.next() == false) {
                    setInfoText("Nie istnieje rekord o podanym kluczu w tabeli turysta");
                } else {
                    textfield0.setText(queryOutput.getString("Imie"));
                    textfield1.setText(queryOutput.getString("Nazwisko"));
                    textfield2.setText(queryOutput.getString("Email"));
                    klucz = updateinput.getText();
                    update = true;
                }
            } else if(Objects.equals(cBox.getValue(), "wycieczka")){
                ResultSet queryOutput = statement.executeQuery("SELECT * FROM wycieczka WHERE ID_Wycieczki = '" + updateinput.getText() + "'");
                if(queryOutput.next() == false) {
                    setInfoText("Nie istnieje rekord o podanym kluczu w tabeli wycieczka");
                } else {
                    textfield0.setText(queryOutput.getString("Data_rozpoczecia"));
                    textfield1.setText(queryOutput.getString("Data_zakonczenia"));
                    textfield2.setText(queryOutput.getString("Cena_biletu"));
                    textfield3.setText(queryOutput.getString("Miejsce_wycieczki"));
                    klucz = updateinput.getText();
                    update = true;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void addDane(ActionEvent event){
        output.setText("");
        try {
            Statement statement = connectDB.createStatement();
            int status = 0;
            if(Objects.equals(cBox.getValue(), "grupa")) {
                if(update == false) status = statement.executeUpdate("INSERT INTO Grupa(PESEL_przewodnika) VALUES ('" + textfield0.getText() + "');");
                else status = statement.executeUpdate("UPDATE Grupa SET PESEL_przewodnika = '" + textfield0.getText() + "' WHERE ID_Grupy = '" + klucz + "';");
            } else if(Objects.equals(cBox.getValue(), "opinia przewodnika")){
                if(update == false) status = statement.executeUpdate("INSERT INTO OpiniaPrzewodnika(PESEL_przewodnika, Ocena, Opis) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "');");
                else status = statement.executeUpdate("UPDATE OpiniaPrzewodnika SET PESEL_przewodnika = '" + textfield0.getText() + "', Ocena = '" + textfield1.getText() + "', Opis = '" + textfield2.getText() + "' WHERE ID_Opinii = '" + klucz + "';");
            } else if(Objects.equals(cBox.getValue(), "przeprowadzenie wycieczki")){
                status = statement.executeUpdate("INSERT INTO PrzeprowadzanieWycieczki(ID_Wycieczki, ID_Grupy) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "przewodnik")){
                if(update == false) status = statement.executeUpdate("INSERT INTO Przewodnik(PESEL, Imie, Nazwisko, Data_rozpoczecia_pracy) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "','" + textfield3.getText() + "');");
                else status = statement.executeUpdate("UPDATE Przewodnik SET Imie='" + textfield1.getText() + "', Nazwisko='" + textfield2.getText() + "', Data_rozpoczecia_pracy='" + textfield3.getText() + "' WHERE PESEL = '" + klucz + "';");
            } else if(Objects.equals(cBox.getValue(), "przynaleznosc do grupy")){
                status = statement.executeUpdate("INSERT INTO PrzynaleznoscDoGrupy(ID_Grupy, ID_Turysty) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "');");
            } else if(Objects.equals(cBox.getValue(), "terminarz przewodnikow")){
                if(update == false) status = statement.executeUpdate("INSERT INTO TerminarzPrzewodnikow(PESEL_przewodnika, Data_rozpoczecia, Data_zakonczenia) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "');");
                else status = statement.executeUpdate("UPDATE TerminarzPrzewodnikow SET PESEL_przewodnika='" + textfield0.getText() + "', Data_rozpoczecia='" + textfield1.getText() + "', Data_zakonczenia='" + textfield2.getText() + "'  WHERE ID_Terminu='" + klucz + "';");
            } else if(Objects.equals(cBox.getValue(), "turysta")){
                if(update == false) status = statement.executeUpdate("INSERT INTO Turysta(Imie, Nazwisko, Email) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "');");
                else status = statement.executeUpdate("UPDATE Turysta SET Imie='" + textfield0.getText() + "', Nazwisko='" + textfield1.getText() + "', Email='" + textfield2.getText() + "' WHERE ID_Turysty='" + klucz + "';");
            } else if(Objects.equals(cBox.getValue(), "wycieczka")){
                if(update == false) status = statement.executeUpdate("INSERT INTO wycieczka(Data_rozpoczecia, Data_zakonczenia, Cena_biletu, Miejsce_wycieczki) VALUES ('" + textfield0.getText() + "','" + textfield1.getText() + "','" + textfield2.getText() + "','" + textfield3.getText() + "');");
                else status = statement.executeUpdate("UPDATE wycieczka SET Data_rozpoczecia='" + textfield0.getText() + "', Data_zakonczenia='" + textfield1.getText() + "', Cena_biletu='" + textfield2.getText() + "', Miejsce_wycieczki='" + textfield3.getText() + "' WHERE ID_Wycieczki='" + klucz + "';");
            }
            textfield0.setText(""); textfield1.setText(""); textfield2.setText(""); textfield3.setText("");
            if (status > 0) setInfoText("Wprowadzenie danych do bazy powiodło się.");
            else setInfoText("Wystąpił problem przy wprowadzaniu danych do bazy.");
            if (update) {
                update = false;
                klucz = "";
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
