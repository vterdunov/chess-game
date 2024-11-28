package chess;

public abstract class ChessPiece {
    String color;
    Boolean isMoved = false;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public final boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isPositionsValid(line, column, toLine, toColumn)) {
            return false;
        }

        // piece specific validations
        if (isValidMove(chessBoard, line, column, toLine, toColumn)) {
            isMoved = true;
            return true;
        }

        return false;
    }

    // isPositionsValid check common validations
    protected boolean isPositionsValid(int line, int column, int toLine, int toColumn) {
        return ChessUtils.isOnBoard(line, column, toLine, toColumn) &&
                !ChessUtils.isSamePosition(line, column, toLine, toColumn);
    }

    protected abstract boolean isValidMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    protected boolean canAttackPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }

    public abstract String getSymbol();
}