package hackerank.array;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s");
        String myString = scanner.nextLine();
        String[] arr = myString.split("\\s");
        scanner.close();
        int numberOfRotations = Integer.parseInt(firstLine[1]);
        if (arr.length < Math.abs(numberOfRotations)) {
            System.out.println("not valid");
        } else {
            if (numberOfRotations >= 0) {
                arr = leftRotate(arr, Integer.parseInt(firstLine[1]));
            } else {
                arr = rightRotate(arr, Integer.parseInt(firstLine[1]) * -1);
            }
            for (String anArr : arr) {
                System.out.print(anArr + " ");
            }
        }
    }

    private static String[] leftRotate(String[] arr, int times) {
        return rotate(arr, times);
    }

    private static String[] rightRotate(String[] arr, int times) {
        return rotate(arr, arr.length - times);
    }

    private static String[] rotate(String[] arr, int start) {
        String[] tempArr = new String[arr.length];
        int j = 0;
        for (int i = start; i < arr.length; i++, j++) {
            tempArr[j] = arr[i];
        }
        for (int i = 0; i < start; i++, j++) {
            tempArr[j] = arr[i];
        }
        return tempArr;
    }
}


/*
Right Rotation

6 4
1 2 3 4 5 6

1 2 3 4 5 6 --> 6 1 2 3 4 5 --> 5 6 1 2 3 4 --> 4 5 6 1 2 3

 */