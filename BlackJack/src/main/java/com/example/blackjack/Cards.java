package com.example.blackjack;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;
import java.util.Timer;

public class Cards
{
    private String suit;
    private String rank;


    private int value;

    public Cards(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        if (rank.equals("Ace")) {
            this.value = 11;
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack") || rank.equals("10")) {
            this.value = 10;
        } else {
            this.value = Integer.parseInt(rank);
        }
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }

}


