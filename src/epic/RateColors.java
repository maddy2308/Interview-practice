package epic;

import java.util.Arrays;

public class RateColors {

    private static final int POINT_SYSTEM = 3;
    private static final int BLACK = 0;
    private static int blackPoints = 0;
    private static final int RED = 1;
    private static int count = 0;

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 0, 1, 1}
        };
        int[][] temp = cloneArray(arr);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                count = 0;
                blackPoints += horizontalMovement(temp, i, j, BLACK);
            }
        }
        temp = cloneArray(arr);
        count = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                count = 0;
                blackPoints += verticalMovement(temp, i, j, BLACK);
            }
        }

        System.out.println(blackPoints);

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

    }

    private static int horizontalMovement(int[][] temp, int i, int j, int color) {
        if (j >= temp[0].length) {
            return convertToPoints(count);
        } else {
            if (temp[i][j] != color)
                return convertToPoints(count);
            else {
                count++;
                int points = horizontalMovement(temp, i, j + 1, color);
                temp[i][j] = -1;
                return points;
            }
        }
    }

    private static int verticalMovement(int[][] temp, int i, int j, int color) {
        if (i >= temp.length) {
            return convertToPoints(count);
        } else {
            if (temp[i][j] != color)
                return convertToPoints(count);
            else {
                count++;
                int points = verticalMovement(temp, i + 1, j, color);
                temp[i][j] = -1;
                return points;
            }
        }
    }


    private static int convertToPoints(int elements) {
        return elements >= POINT_SYSTEM ? elements - (POINT_SYSTEM - 1) : 0;
    }

    private static int[][] cloneArray(int[][] arr) {
        int[][] temp = new int[arr.length][arr[0].length];
        int i = 0;
        for (int[] a : arr) {
            temp[i] = Arrays.copyOf(a, a.length);
            i++;
        }
        return temp;
    }
}
