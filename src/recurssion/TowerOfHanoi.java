package recurssion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        recursion(5, 1, 2, 3);
    }

    static void recursion(int disks, int beg, int aux, int end) {
        if (disks == 1) {
            System.out.println("Move disk from " + beg + " to " + end);
        } else {
            recursion(disks - 1, beg, end, aux);
            recursion(1, beg, aux, end);
            recursion(disks - 1, aux, beg, end);
        }
    }

}
