package com.company;

public class King extends Token {
    King(CheckersBoard board, Player.PlayerType type) {
        super(board, type);
    }

    @Override
    public boolean move(Coordinates beg, Coordinates end) {
        int mult = Player.PlayerType.White == type ? 1 : -1;
        boolean isKilling = false;
        // make king is moving diagonally
        if ((Math.abs(end.c - beg.c)) != Math.abs(end.r - beg.r)) {
            System.out.println("King doesn't move diagonally");
            return false;
        } else {
            System.out.println("King moves diagonal");
        }

        if ((Math.abs(end.c - beg.c)) == 2 || Math.abs(end.r - beg.r) != 2) {
            System.out.println("King is about to do a murder");
            isKilling = true;
        }

        // Checks if is moving correct amount of space
        if (isKilling = false) {
            if ((Math.abs(end.c - beg.c)) != 1 || Math.abs(end.r - beg.r) != 1) {
                System.out.println("King isn't moving correct amount of space for a non murder");
                return false;
            } else {
                //King is moving correct amount, so move the king
                System.out.println("King is moving correct amount");
                board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
                board.grid[beg.r][beg.c] = null;
                return true;
            }
        }

        //Do murder
        if (isKilling == true) {
            // If the token is white
            if (mult == 1) {
                int midNum = (end.c - beg.c) / 2;
                boolean isForwardKill = (end.r > beg.r);
                // Checks if piece is moving proper amount of space
                if (Math.abs(end.c - beg.c) != 2 || Math.abs(end.r - beg.r) != 2) {
                    return false;
                } else
                    System.out.println("Moving proper amount");
                // Checks if there is anything in the endpoint space
                if (board.grid[end.r][end.c] != null) {
                    System.out.println("Something is in the endzone");
                    return false;
                } else {
                    System.out.println("Final space is empty");
                }
                // Checks to see if the enemy is in the kill spot
                if (isForwardKill) {
                    if (board.grid[beg.r + 1][beg.c + midNum] == null
                            || board.grid[beg.r + 1][beg.c + midNum].getPlayerType() == Player.PlayerType.White) {
                        System.out.println("No enemy in sight");
                        return false;
                    } else {
                        System.out.println("Enemy in sight");
                        board.grid[beg.r + 1][beg.c + midNum] = null;
                        System.out.println("Murder Successful");
                        board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
                        board.grid[beg.r][beg.c] = null;
                        return true;
                    }
                } else {
                    if (board.grid[beg.r - 1][beg.c + midNum] == null
                            || board.grid[beg.r - 1][beg.c + midNum].getPlayerType() == Player.PlayerType.White) {
                        System.out.println("No enemy in sight");
                        return false;
                    } else {
                        System.out.println("Enemy in sight");
                        board.grid[beg.r - 1][beg.c + midNum] = null;
                        System.out.println("Murder Successful");
                        board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
                        board.grid[beg.r][beg.c] = null;
                        return true;
                    }
                }
            } else {
                int midNum = (end.c - beg.c) / 2;
                boolean isForwardKill = (end.r < beg.r);
                // Checks if piece is moving proper amount of space
                if (Math.abs(end.c - beg.c) != 2 || Math.abs(end.r - beg.r) != 2) {
                    return false;
                } else
                    System.out.println("Moving proper amount");
                // Checks if there is anything in the endpoint space
                if (board.grid[end.r][end.c] != null) {
                    System.out.println("Something is in the endzone");
                    return false;
                } else {
                    System.out.println("Final space is empty");
                }
                // Checks to see if the enemy is in the kill spot
                if (isForwardKill) {
                    if (board.grid[beg.r - 1][beg.c + midNum] == null
                            || board.grid[beg.r - 1][beg.c + midNum].getPlayerType() == Player.PlayerType.Black) {
                        System.out.println("No enemy in sight");
                        return false;
                    } else {
                        System.out.println("Enemy in sight");
                        board.grid[beg.r - 1][beg.c + midNum] = null;
                        System.out.println("Murder Successful");
                        board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
                        board.grid[beg.r][beg.c] = null;
                        return true;
                    }
                } else {
                    if (board.grid[beg.r + 1][beg.c + midNum] == null
                            || board.grid[beg.r + 1][beg.c + midNum].getPlayerType() == Player.PlayerType.Black) {
                        System.out.println("No enemy in sight");
                        return false;
                    } else {
                        System.out.println("Enemy in sight");
                        board.grid[beg.r + 1][beg.c + midNum] = null;
                        System.out.println("Murder Successful");
                        board.grid[end.r][end.c] = board.grid[beg.r][beg.c];
                        board.grid[beg.r][beg.c] = null;
                        return true;
                    }
                }
            }
        }


        return true;
    }

    @Override
    public String print()
    {
        if (this.type == Player.PlayerType.White)
            return "wk";
        else
            return "bk";
    }
}

/*
        // No idea what this does
        if (beg.r > end.r && beg.c > end.c) {
            for (int i = beg.r; i > end.r;) {
                for (int j = beg.c; j > end.c; --i, --j) {
                    if (board.grid[i][j] != null) {
                        return false;
                    }
                }
            }
        }

        // No idea what this is
        if (beg.r > end.r && beg.c < end.c) {
            for (int i = beg.r; i > end.r;) {
                for (int j = beg.c; j < end.c; --i, ++j) {
                    if (board.grid[i][j] != null) {
                        return false;
                    }
                }
            }
        }

        // is this movement?
        if (beg.r < end.r && beg.c > end.c) {
            for (int i = beg.r; i < end.r;) {
                for (int j = beg.c; j > end.c; ++i, --j) {
                    if (board.grid[i][j] != null) {
                        return false;
                    }
                }
            }
        }

        // This is terribly implemented movement
        if (beg.r < end.r && beg.c < end.c) {
            for (int i = beg.r; i < end.r;) {
                for (int j = beg.c; j < end.c; ++i, ++j) {
                    if (board.grid[i][j] != null) {
                        return false;
                    }
                }
            }
        }


    }


    */