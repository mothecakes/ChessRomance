package com.esqflowne.chessromance;

public class MyMath {
    public static int getRange(int input, int min, int max) {
        if (input < min) {
            return min;
        }
        if (input > max) {
            return max;
        }
        return input;
    }
    public static boolean inRange(int input, int min, int max) {
        if (input < min) {
            return false;
        }
        if (input > max) {
            return false;
        }
        return true;
    }
}
