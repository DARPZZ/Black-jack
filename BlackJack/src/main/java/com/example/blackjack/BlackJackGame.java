package com.example.blackjack;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;

public class BlackJackGame
{
    Loose loose = new Loose();

    Win win = new Win();
    private Stage stage;
    int playerValue = 0;
    Button draw = new Button();
    Button stand = new Button();
    int dealerValue;
    Label playersCard = new Label();
    Label DealerValue = new Label();
    Deck deck = new Deck();
    Cards card = deck.draw();
    boolean playerBust = false;
    boolean dealerBust = false;
    Timeline timeline = new Timeline();

    public Scene createBlackJackScene(Stage stage)
    {
        this.stage = stage;
        AnchorPane anchorPane = new AnchorPane();
        drawCard();
        getDealercards();

        playersCard.setLayoutX(400);
        playersCard.setLayoutY(50);
        DealerValue.setLayoutX(400);
        DealerValue.setLayoutY(650);
        draw.setLayoutY(700);
        draw.setLayoutX(150);
        draw.setPrefWidth(100);
        draw.setPrefHeight(20);
        draw.setText("Draw");

        stand.setPrefHeight(draw.getPrefHeight());
        stand.setPrefWidth(draw.getPrefWidth());
        stand.setLayoutX(300);
        stand.setLayoutY(draw.getLayoutY());
        stand.setText("Stand");

        anchorPane.getChildren().addAll(playersCard, draw, stand, DealerValue);
        Scene scene = new Scene(anchorPane, 800, 800);
        return scene;
    }

    public void drawCard()
    {
        draw.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                draw.setDisable(false);
                deck.shuffle();
                Cards card = deck.draw();
                playerValue = playerValue + card.getValue();
                playersCard.setText(String.valueOf(playerValue));
            }
        });
    }

    public void getDealercards()
    {
        deck.shuffle();
        Cards firstCard = deck.draw();
        dealerValue = firstCard.getValue();
        DealerValue.setText(String.valueOf(dealerValue));
        draw.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                Cards card = deck.draw();
                playerValue = playerValue + card.getValue();
                playersCard.setText(String.valueOf(playerValue));
                if (playerValue > 21) {
                    playerBust = true;
                    checkWinner();
                }
            }
        });
        stand.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                draw.setDisable(true);
                Cards secondCard = deck.draw();
                dealerValue += secondCard.getValue();
                DealerValue.setText(String.valueOf(dealerValue));
                if (dealerValue >= 17 && dealerValue <= 21) {
                    timeline.stop();
                    checkWinner();
                } else {
                    timeline = new Timeline(new KeyFrame(Duration.millis(1000), event ->
                    {
                        deck.shuffle();
                        Cards card = deck.draw();
                        dealerValue += card.getValue();
                        if (dealerValue > 21) {
                            dealerBust = true;
                            timeline.stop();
                            checkWinner();
                        } else if (dealerValue >= 17 && dealerValue <= 21) {
                            dealerBust = false;
                            timeline.stop();
                            checkWinner();
                        }
                        DealerValue.setText(String.valueOf(dealerValue));
                    }));
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                }
            }
        });
    }

    public void checkPlayerBust()
    {
        if (playerValue > 21) {
            playerBust = true;
        }
    }

    public void checkDealerBust()
    {
        if (dealerValue > 21) {
            dealerBust = true;
        }
    }

    public void checkWinner()
    {

        checkPlayerBust();
        checkDealerBust();
        timeline = new Timeline(new KeyFrame(Duration.millis(2000), event ->
        {

        }));
        timeline.setCycleCount(1);
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (playerBust) {
                    Scene createLooseScene = loose.createLooseScene();
                    stage.setScene(createLooseScene);
                } else if (dealerBust) {
                    Scene createWinScene = win.createWinScene();
                    stage.setScene(createWinScene);
                } else if (playerValue > dealerValue) {
                    Scene createWinScene = win.createWinScene();
                    stage.setScene(createWinScene);
                } else if (playerValue < dealerValue) {
                    Scene createLooseScene = loose.createLooseScene();
                    stage.setScene(createLooseScene);
                } else {
                    System.out.println("It's a tie");
                }
            }
        });
    }
}
