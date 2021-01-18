package com.company;

public class Pawn extends Token {
    Pawn(CheckersBoard board, Player.PlayerType type)
    {
        super(board, type);
    }

    public int[] canMove(Coordinates beg) {
        int mult = Player.PlayerType.White == type ? 1 : -1;
        int[] returnValues = new int[4];
        /** @param returnValues - will have 0 in first spot if no movement available, one if there is,
         *                        will have 1 in second spot if white, 2 if black
         *                        will have end coordinates row in spot 3
         *                        will have end coordinates column in spot 4
        */

        if (mult == 1) {
            returnValues[1] = 1;
            // Player is white
            return returnValues;
        } else if (mult == -1) {
            returnValues[1] = 2;
            // Player is black
            if (beg.c - 1 < 0 || beg.c + 1 > 7 || beg.r - 1 < 0) {

            }

            if (beg.c - 1 >= 0 || beg.r - 1 >= 0) {
                if (board.grid[beg.c - 1][beg.r - 1] == null) {
                    returnValues[0] = 1;
                    returnValues[2] = beg.r - 1;
                    returnValues[3] = beg.c - 1;
                    return returnValues;
                }
            } else if (board.grid[beg.c + 1][beg.r - 1] == null) {
            if (beg.c - 1 >= 0 || beg.r - 1 >= 0) {
                returnValues[0] = 1;
                returnValues[2] = beg.r - 1;
                returnValues[3] = beg.c + 1;
                return returnValues;
                }
            } else {
                returnValues[0] = 0;
                return returnValues;
            }
        }

        returnValues[0] = 0;
        return returnValues;
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