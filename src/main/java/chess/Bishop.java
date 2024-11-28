package chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    protected boolean isValidMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // diagonal
        return Math.abs(line - toLine) == Math.abs(column - toColumn);
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}