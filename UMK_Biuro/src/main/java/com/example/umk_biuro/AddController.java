package com.example.umk_biuro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    Label label0,label1,label2,label3;

    @FXML
    TextField textfield0,textfield1,textfield2,textfield3;
    @FXML
    ComboBox cBox;

    private String[] options = {"grupa","opinia przewodnika","przeprowadzenie wycieczki","przewodnik","przynaleznosc do grupy","terminarz przewodnikow","turysta", "wycieczka"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cBox.getItems().addAll(options);
    }

    @FXML
    private void showInputs(ActionEvent event){
        try {
            if(Objects.equals(cBox.getValue(), "grupa")) {
                label0.setText("ID_Grupy");
                label1.setText("PESEL_przewodnika");
                label2.setText("");
                label3.setText("");
                textfield0.setDisable(false);
                textfield1.setDisable(false);
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

        try {
            if(Objects.equals(cBox.getValue(), "grupa")) {

            } else if(Objects.equals(cBox.getValue(), "opinia przewodnika")){

            } else if(Objects.equals(cBox.getValue(), "przeprowadzenie wycieczki")){

            } else if(Objects.equals(cBox.getValue(), "przewodnik")){

            } else if(Objects.equals(cBox.getValue(), "przewodnik")){

            } else if(Objects.equals(cBox.getValue(), "przynaleznosc do grupy")){

            } else if(Objects.equals(cBox.getValue(), "terminarz przewodnikow")){

            } else if(Objects.equals(cBox.getValue(), "turysta")){

            } else if(Objects.equals(cBox.getValue(), "wycieczka")){

            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
