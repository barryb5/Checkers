package com.company;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

    	// pb is player black and pw is player white
		AIPlayer pb = new AIPlayer(AIPlayer.PlayerType.Black);
		Player pw = new Player(Player.PlayerType.White);

		// create a new Game class and play the game

		Game game = new Game(pb, pw);
	    game.play();

/*
		CheckersBoard cb = new CheckersBoard();
		cb.printBoard();
		System.out.println("God spawned a white piece");
		cb.grid[4][1] = new Pawn(cb, Player.PlayerType.White);
		cb.printBoard();
		cb.move(new Coordinates(5, 0), new Coordinates(3, 2), pb);
		cb.printBoard();
		cb.grid[2][1] = null;
		cb.grid[2][1] = new King(cb, Player.PlayerType.White);
		System.out.println("After god saw the atrocious murder, he made a pawn a king");
		cb.printBoard();
		cb.move(new Coordinates(2, 1), new Coordinates(4, 3), pw);
		cb.printBoard();
*/
	}
}
	