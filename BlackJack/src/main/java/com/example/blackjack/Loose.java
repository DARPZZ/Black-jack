package com.example.blackjack;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Loose
{
    AnchorPane anchorPane = new AnchorPane();
    public Scene createLooseScene()
    {
        Scene scene = new Scene(anchorPane, 600, 900);

        return scene;
    }
}
