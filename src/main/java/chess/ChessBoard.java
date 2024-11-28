package chess;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling0() {
        if (nowPlayer.equals("White")) {
            // cells has not to be empty
            if (board[0][4] == null || board[0][0] == null) return false;

            // it has to be King and Rook
            if (board[0][4].getSymbol().equals("K") && board[0][0].getSymbol().equals("R") &&
                    // and the castling way is free
                    board[0][1] == null && board[0][2] == null && board[0][3] == null &&

                    // and white pieces
                    board[0][4].getColor().equals("White") && board[0][0].getColor().equals("White") &&

                    // and they have not moved
                    !board[0][4].isMoved && !board[0][0].isMoved &&

                    // and Kind is not under attack
                    !new King("White").isUnderAttack(this, 0, 6)) {

                // Do the castling
                board[0][2] = board[0][4]; // move King
                board[0][3] = board[0][0]; // move Rook
                board[0][4] = null;
                board[0][0] = null;
                nowPlayer = "Black";

                return true;
            }
        } else {
            // cells has not to be empty
            if (board[7][4] == null || board[7][0] == null) return false;

            // it has to be King and Rook
            if (board[7][4].getSymbol().equals("K") && board[7][0].getSymbol().equals("R") &&

                    // and the castling way is free
                    board[7][1] == null && board[7][2] == null && board[7][3] == null &&

                    // and black pieces
                    board[7][4].getColor().equals("Black") && board[7][0].getColor().equals("Black") &&

                    // and they have not moved
                    !board[7][4].isMoved && !board[7][0].isMoved &&

                    // and Kind is not under attack
                    !new King("Black").isUnderAttack(this, 7, 6)) {

                // Do the castling
                board[7][2] = board[7][4]; // move King
                board[7][3] = board[7][0]; // move Rook
                board[7][4] = null;
                board[7][0] = null;
                nowPlayer = "White";

                return true;
            }
        }
        return false;
    }

    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            // cells has not to be empty
            if (board[0][4] == null || board[0][7] == null) return false;

            // it has to be King and Rook
            if (board[0][4].getSymbol().equals("K") && board[0][7].getSymbol().equals("R") &&

                    // and the castling way is free
                    board[0][5] == null && board[0][6] == null &&

                    // and white pieces
                    board[0][4].getColor().equals("White") && board[0][7].getColor().equals("White") &&

                    // and they have not moved
                    !board[0][4].isMoved && !board[0][7].isMoved &&

                    // and Kind is not under attack
                    !new King("White").isUnderAttack(this, 0, 2)) {

                // Do the castling
                board[0][6] = board[0][4]; // move King
                board[0][5] = board[0][7]; // move Took
                board[0][4] = null;
                board[0][7] = null;
                nowPlayer = "Black";

                return true;
            }
        } else {
            // Do the castling
            if (board[7][4] == null || board[7][7] == null) return false;

            // it has to be King and Rook
            if (board[7][4].getSymbol().equals("K") && board[7][7].getSymbol().equals("R") &&

                    // and the castling way is free
                    board[7][5] == null && board[7][6] == null &&

                    // and black pieces
                    board[7][4].getColor().equals("Black") && board[7][7].getColor().equals("Black") &&

                    // and they have not moved
                    !board[7][4].isMoved && !board[7][7].isMoved &&

                    // and Kind is not under attack
                    !new King("Black").isUnderAttack(this, 7, 2)) {

                // Do the castling
                board[7][6] = board[7][4]; // move King
                board[7][5] = board[7][7]; // move Rook
                board[7][4] = null;
                board[7][7] = null;
                nowPlayer = "White";

                return true;
            }
        }
        return false;
    }
}