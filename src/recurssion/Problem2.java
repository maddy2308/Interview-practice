package recurssion;

public class Problem2 {
    static int[] a;
    static int columns = 5;
    static int rows = 3;

    public static void main(String[] args) {
        int target = 15;
        a = new int[target];
        new Problem2().move(1, target);
        System.out.println(a[1] + a[5]);
    }

    int move(int boxNo, int target) {
        int right = 0, down = 0;
        if (boxNo > target) return 0;
        else if (boxNo == target) {
            //a[target - 1]++;
            return 1;
        } else if (a[boxNo - 1] > 0)
            return a[boxNo - 1];
        else {
            if (!(boxNo % columns == 0)) {
                right = move(boxNo + 1, target);
            }
            if (boxNo + columns <= target) {
                down = move(boxNo + columns, target);
            }
            return a[boxNo - 1] = right + down;
        }
    }
}
