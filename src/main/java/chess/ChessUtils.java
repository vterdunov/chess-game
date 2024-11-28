package chess;

public class ChessUtils {
    public static final int BOARD_SIZE = 8;

    public static boolean isOnBoard(int... coordinates) {
        for (int coord : coordinates) {
            if (coord < 0 || coord >= BOARD_SIZE) return false;
        }
        return true;
    }

    public static boolean isSamePosition(int line, int column, int toLine, int toColumn) {
        return line == toLine && column == toColumn;
    }
}
