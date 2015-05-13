package epic;


import java.util.Arrays;
import java.util.Random;

public class FindIslands {

    private static int islandNumber = 1;
    private static final int ISLAND_REPRESENTATION = 1;

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 0, 1, 1}
        };
        Random random = new Random();
        int[][] array = new int[6][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(2);
            }
        }

        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }

        findIslands(array);
    }

    private static void findIslands(int[][] arr) {
        int[][] cc = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (cc[i][j] == 0 && arr[i][j] == ISLAND_REPRESENTATION) {
                    findConnectedComponents(arr, cc, i, j);
                    islandNumber++;
                }
            }
        }
        System.out.println();
        for (int[] c : cc) {
            System.out.println(Arrays.toString(c));
        }
    }

    private static void findConnectedComponents(int[][] arr, int[][] cc, int i, int j) {
        cc[i][j] = islandNumber;

        // go north
        if (i - 1 >= 0 && arr[i - 1][j] == ISLAND_REPRESENTATION && cc[i - 1][j] == 0) {
            findConnectedComponents(arr, cc, i - 1, j);
        }
        // go south
        if (i + 1 < arr.length && arr[i + 1][j] == ISLAND_REPRESENTATION && cc[i + 1][j] == 0) {
            findConnectedComponents(arr, cc, i + 1, j);
        }
        // go east
        if (j + 1 < arr[0].length && arr[i][j + 1] == ISLAND_REPRESENTATION && cc[i][j + 1] == 0) {
            findConnectedComponents(arr, cc, i, j + 1);
        }
        // go west
        if (j - 1 >= 0 && arr[i][j - 1] == ISLAND_REPRESENTATION && cc[i][j - 1] == 0) {
            findConnectedComponents(arr, cc, i, j - 1);
        }
    }
}
