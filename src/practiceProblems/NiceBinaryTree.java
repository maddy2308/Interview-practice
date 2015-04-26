package practiceProblems;

public class NiceBinaryTree {

    public static void main(String[] args) {
        findNumberOfBits(12, 16);
        System.out.println(recurse("nll", 0));
    }

    private static int recurse(String str, int index) {
        if (str.charAt(index) == 'l') return 0;
        //str = str.substring(index+1);
        int left = recurse(str, index + 1);
        //str = str.substring(index+1);
        int right = recurse(str, index + 2);
        return Math.max(left, right) + 1;
    }

    public static int findNumberOfBits(int x, int y) {
        int bitCount = 0;
        int z = x ^ y;  //XOR x and y
        while (z != 0) {
            //increment count if last binary digit is a 1:
            bitCount += z & 1;
            z = z >> 1;  //shift Z by 1 bit to the right
        }
        return bitCount;
    }
}
