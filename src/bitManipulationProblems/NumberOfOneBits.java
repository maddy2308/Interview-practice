package bitManipulationProblems;

import java.util.Objects;

public class NumberOfOneBits {
    public static void main(String[] args){
        int number = 13;
        System.out.println(1 << number);
        System.out.println(Integer.toBinaryString(number));
        System.out.println(new NumberOfOneBits().oneBits(number));
    }
    public int oneBits(int number){
        int count = 0;
        int ONE = 1;
        while (number > 0){
            int rightBit = number & ONE;
            if (rightBit == 1){
                count++;
            }
            number = number >> ONE;
        }
        return count;
    }
}
