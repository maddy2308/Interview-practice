package bitManipulationProblems;

public class ReverseBits {

    public static void main(String[]args){
        int number = 83;
        System.out.println(Integer.toBinaryString(number));
        for (int i = 0; i < 8; i++) {
            number = reverse(number, i, 16 - i);
        }
        System.out.println(Integer.toBinaryString(number));
    }

    public static int reverse(int number, int fromLeft, int fromRight){
        int a = (number >> fromLeft) & 1;
        int b = (number >> fromRight) & 1;
        if ((a ^ b) != 0){
            number ^= (1 << fromLeft) | (1 << fromRight);
            return number;
        }
        return number;
    }
}
