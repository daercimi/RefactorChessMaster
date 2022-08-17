package util;

public class IsOnScreen {
    // Boolean to check if the piece is on the screen or not
    public static boolean invoke(int row, int col) {
        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            return true;
        } else {
            return false;
        }
    }
}