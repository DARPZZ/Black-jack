package com.example.blackjack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    BlackJackGame blackJackGame = new BlackJackGame();
    private Stage stage;
    Label navn = new Label("Indtast navn");
    Button confirm = new Button();
    TextField navnIndtastning = new TextField();
    AnchorPane anchorPane = new AnchorPane();
    @Override
    public void start(Stage stage) throws IOException
    {
        this.stage = stage;
        Scene scene = new Scene(anchorPane, 800, 800);
        navn.setLayoutY(400);
        navn.setLayoutX(400);
        navnIndtastning.setLayoutY(navn.getLayoutY()+30);
        navnIndtastning.setLayoutX(navn.getLayoutX()-35);
        confirm.setLayoutX(navnIndtastning.getLayoutX());
        confirm.setLayoutY(navnIndtastning.getLayoutY()+35);
        confirm.setPrefHeight(20);
        confirm.setPrefWidth(150);
        anchorPane.getChildren().addAll(confirm,navn,navnIndtastning);
        confirm.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                Scene createBlackJack = blackJackGame.createBlackJackScene(stage);
                stage.setScene(createBlackJack);
            }
        });

        stage.setTitle("Black Jack");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args)
    {
        launch();
    }
}