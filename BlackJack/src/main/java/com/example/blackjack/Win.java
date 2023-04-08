package com.example.blackjack;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Random;

public class Win
{
    AnchorPane anchorPane = new AnchorPane();
    public Scene createWinScene() {
        // Create the root node for the scene

        Scene scene = new Scene(anchorPane, 600, 900, Color.BLACK);

        return scene;
    }
}




