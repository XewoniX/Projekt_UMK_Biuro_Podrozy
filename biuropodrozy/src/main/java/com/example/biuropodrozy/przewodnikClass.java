package com.example.biuropodrozy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="przewodnik")
public class przewodnikClass {
    @Id
    @Column(name="PESEL")
    private String id;

    @Column(name="Imie")
    private String imie;

    @Column(name="Nazwisko")
    private String Nazwisko;

    @Column(name="Data_rozpoczecia_pracy")
    private String datarozpoczecia;

    public przewodnikClass() {
    }

    public przewodnikClass(String id, String imie, String nazwisko, String datarozpoczecia) {
        this.id = id;
        this.imie = imie;
        Nazwisko = nazwisko;
        this.datarozpoczecia = datarozpoczecia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getDatarozpoczecia() {
        return datarozpoczecia;
    }

    public void setDatarozpoczecia(String datarozpoczecia) {
        this.datarozpoczecia = datarozpoczecia;
    }
}
