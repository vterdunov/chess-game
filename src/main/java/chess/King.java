package chess;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    protected boolean isValidMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // move one ceil
        return Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(this.color)) {
                    if (piece instanceof King) {
                        if (Math.abs(i - line) <= 1 && Math.abs(j - column) <= 1) {
                            return true;
                        }
                    } else {
                        if (piece.canAttackPosition(board, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}