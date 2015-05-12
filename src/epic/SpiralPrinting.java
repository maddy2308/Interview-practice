package epic;

public class SpiralPrinting {

    public static void main(String[] args) {
        spiralPrint();
    }

    private static int[][] arr = {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
    };

    private static void spiralPrint() {

        int row = arr.length % 2 == 0 ? arr[0].length / 2 : arr[0].length / 2 + 1;
        for (int i = 0; i < row; i++) {
            forwardPrint(i, i);
            downPrint(arr[0].length - i - 1, i);
            reversePrint(arr.length - i - 1, i);
            upPrint(i, i);
        }
    }

    private static void forwardPrint(int row, int miss) {
        for (int i = miss; i < arr[0].length - miss; i++) {
            System.out.print(arr[row][i] + " ");
        }
    }

    private static void downPrint(int column, int miss) {
        for (int i = miss + 1; i < arr.length - miss; i++) {
            System.out.print(arr[i][column] + " ");
        }
    }

    private static void reversePrint(int row, int miss) {
        for (int i = arr[0].length - 2 - miss; i >= miss; i--) {
            System.out.print(arr[row][i] + " ");
        }
    }

    private static void upPrint(int column, int miss) {
        for (int i = arr.length - 2 - miss; i >= miss + 1; i--) {
            System.out.print(arr[i][column] + " ");
        }
    }
}
