package com.example.biuropodrozy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {

    private static EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("MyUnit");

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        EntityManager entityManager = factory.createEntityManager();
        Query q = entityManager.createQuery("select p from przewodnik p");
        List<przewodnikClass> list = q.getResultList();
        for(przewodnikClass d : list) {
            System.out.println(d);
        }
        launch();
    }
}