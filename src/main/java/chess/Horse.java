package chess;

public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    @Override
    protected boolean isValidMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) ||
                (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2);
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
