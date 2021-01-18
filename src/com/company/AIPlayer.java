package com.company;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer {
    private final AIPlayer.PlayerType playerType;
    public int personScore = 0;
    public int AIScore = 0;


    public AIPlayer(PlayerType pt) {
        this.playerType = pt;
    }


    public enum PlayerType {
        Black,
    }

    public CheckersBoard CopyBoard(CheckersBoard originalBoard, CheckersBoard emptyBoard) {

        for (int i = 0; i < originalBoard.size; i++) {
            for (int j = 0; j < originalBoard.size; j++) {
                emptyBoard.grid[i][j] = originalBoard.grid[i][j];
            }
        }

        return emptyBoard;

    }

    public int[] checkScore(CheckersBoard board) {
        int[] returnScores = new int[2];
        CheckersBoard cb = new CheckersBoard();

        int size = cb.size;
        personScore = 0;
        AIScore = 0;

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board.grid[i][j].getPlayerType() == Player.PlayerType.White) {
                    personScore++;
                } else if (board.grid[i][j].getPlayerType() == Player.PlayerType.Black) {
                    AIScore++;
                }
            }
        }

        returnScores[0] = personScore;
        returnScores[1] = AIScore;
        return returnScores;
    }

    public AIPlayer.PlayerType getPlayerType() {
        return playerType;
    }

    public void move(CheckersBoard board, AIPlayer player) {
        // Write code to find best start and end coordinates using a minimax algorithm here
        // Creates tempBoard and copies the full board onto tempBoard
        CheckersBoard tempBoard = new CheckersBoard();
        tempBoard = CopyBoard(board, tempBoard);

        for (int i = 0; i < tempBoard.size; i++) {
            for (int j = 0; j < tempBoard.size; j++) {
                Pawn p = new Pawn(tempBoard, Player.PlayerType.Black);
                Coordinates start = new Coordinates(i, j);
                int[] values = new int[4];
                values = p.canMove(start);

                if (values[0] == 1 && values[1] == 2) {
                    // Checks if can move and checks if it is the right color

                    Coordinates end = new Coordinates(values[2], values[3]);
                    board.grid[i][j].move(start, end);
                }
            }
        }



        // Insert optimal coordinates into

//        Coordinates c1 = new Coordinates(start row, start col);
//        Coordinates c2 = new Coordinates(end row, end col);
//        if (!board.move(c1, c2, player)) {
//            System.out.println("that doesn't work try again");
//            move(board, player);
//        }
    }

}