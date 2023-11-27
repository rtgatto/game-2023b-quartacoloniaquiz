package com.mygdx.quiz;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class QcqGame {
    private Board board;
    private Player player;
    private Dice dice;

    public void setNewGame() {
            board = new Board();
            player = new Player();
            dice = new Dice();
        } 

    public void welcomeUser() {
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Press ENTER to roll the dice.");
    }

    public void startGame() {
        welcomeUser();

        // Wait for user input (ENTER key) to roll the dice
        while (!Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            // You can add a delay here if needed
        }

        // Perform the dice roll and update the game state
        int diceValue = dice.roll();
        System.out.println("You rolled a " + diceValue);

        // Move the player based on the dice value
        player.move(diceValue);

        // Apply the event on the board square where the player landed
        Event event = board.getEventForSquare(player.getPosition());
        if (event != null) {
            event.applyEvent(player);
            System.out.println(event.getMessage(player));
        }

        // Check if the player has won
        if (player.checkWin()) {
            System.out.println("Congratulations! You reached the end of the board.");
        } else {
            // Continue the game loop or perform other actions as needed
        }
    }
}