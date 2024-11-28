package chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    protected boolean isValidMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return line == toLine || // horizontal
                column == toColumn || // vertical
                Math.abs(line - toLine) == Math.abs(column - toColumn); // diagonal
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}