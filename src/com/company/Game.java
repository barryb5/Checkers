package com.company;
import java.lang.*;

public class Game {
    CheckersBoard  board = new CheckersBoard();
    AIPlayer pb;
    Player pw;

    Game(AIPlayer pb, Player pw) {
        this.pb = pb;
        this.pw = pw;
    }

    public void play() {
        // Player curPlayer = pw; // player white starts first
        boolean isPlayerWhite = true;

        // stating things to the players
        System.out.println("1. This is checkers.");
        System.out.println("2. White goes first.");
        System.out.println("3. The only way to win is by killing all of the other players pieces.");

        // loop until somebody wins
        while (!board.checkWinner()) {
            board.printBoard(); // print the board
            if (isPlayerWhite == true) {
                pw.move(board, pw); // player moves their piece
                isPlayerWhite = false; // swap between players
            } else {
                pb.move(board, pb); // player moves their piece
                isPlayerWhite = true; // swap between players
            }

            // curPlayer.move(board, curPlayer);
            // curPlayer = (curPlayer.getPlayerType() == pb.getPlayerType()) ? pw : pb;
        }
    }
}
