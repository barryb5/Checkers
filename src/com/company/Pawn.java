package com.company;

public class Pawn extends Token {
    Pawn(CheckersBoard board, Player.PlayerType type)
    {
        super(board, type);
    }


    @Override
    public boolean move(Coordinates beg, Coordinates end)
    {
        int mult = Player.PlayerType.White == type ? 1 : -1;
        boolean isKilling = false;

        if (Math.abs(beg.c - end.c) == 2) {
            System.out.println("You are about to do a murder. Are you sure about this? Sike you have no say in the matter it has happened already.");
            isKilling = true;
        } else if (mult*end.r < mult*beg.r || Math.abs(beg.c - end.c) != 1) {
            return false;
        }

        // checks if murder is possible
        if (isKilling == true) {
            System.out.println("Murder is possible");
            // If the token is white
            if (mult == 1) {
                int midNum = (end.c - beg.c) / 2;
                // Checks if piece is moving proper amount of space
                if (Math.abs(end.c - beg.c) != 2 || Math.abs(end.r - beg.r) != 2) {
                    return false;
                } else
                    System.out.println("Moving proper amount");
                // Checks if there is anything in the endpoint space
                if (board.grid[end.r][end.c] != null) {
                    System.out.println("Something is in the endzone");
                    return false;
                } else
                    System.out.println("Final space is empty");
                // Checks to see if the enemy is in the kill spot
                if (board.grid[beg.r - 1][beg.c + midNum] == null
                    || board.grid[beg.r - 1][beg.c + midNum].getPlayerType() == Player.PlayerType.White) {
                    System.out.println("No enemy in sight");
                    return false;
                } else {
                    System.out.println("Enemy in sight");
                }
                board.grid[beg.r - 1][beg.c + midNum] = null;
                System.out.println("Murder Successful");
            } else {
                int midNum = (end.c - beg.c) / 2;
                // Checks if piece is moving proper amount of space
                if (Math.abs(end.c - beg.c) != 2 || Math.abs(end.r - beg.r) != 2) {
                    return false;
                } else
                    System.out.println("Moving proper amount");
                // Checks if there is anything in the endpoint space
                if (board.grid[end.r][end.c] != null) {
                    System.out.println("Something is in the endzone");
                    return false;
                } else
                    System.out.println("Final space is empty");
                // Checks to see if the enemy is in the kill spot
                if (board.grid[beg.r + 1][beg.c + midNum] == null
                        || board.grid[beg.r - 1][beg.c + midNum].getPlayerType() == Player.PlayerType.Black) {
                    System.out.println("No enemy in sight");
                    return false;
                } else {
                    System.out.println("Enemy in sight");
                }
                board.grid[beg.r - 1][beg.c + midNum] = null;
                System.out.println("Murder Successful");
            }
        }

        board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
        board.grid[beg.r][beg.c] = null;
        return true;
    }

    @Override
    public String print()
    {
        if (this.type == Player.PlayerType.White)
            return "w";
        else
            return "b";
    }
}