package chess;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    protected boolean isValidMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Move forward
        if (column == toColumn) {
            // way has to be empty
            if (chessBoard.board[toLine][toColumn] != null) {
                return false;
            }

            if (color.equals("White")) {
                return (line == 1 && (toLine == 2 || toLine == 3)) ||  // first move allows two cells
                        (toLine == line + 1);                          // regular move
            }

            if (color.equals("Black")) {
                return (line == 6 && (toLine == 5 || toLine == 4)) ||  // first move allows two cells
                        (toLine == line - 1);                          // regular move
            }
        }

        // Attack
        if (Math.abs(column - toColumn) != 1) {
            return false;
        }

        boolean isWhitePawnAttack = color.equals("White") && toLine == line + 1;
        boolean isBlackPawnAttack = color.equals("Black") && toLine == line - 1;
        if (!(isWhitePawnAttack || isBlackPawnAttack)) {
            return false;
        }

        // Check enemy piece on the target ceil
        return chessBoard.board[toLine][toColumn] != null &&
                !chessBoard.board[toLine][toColumn].getColor().equals(color);
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}