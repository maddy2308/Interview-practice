package bitManipulationProblems;

public class MaxBinaryGap {

    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(533));
        System.out.println(new MaxBinaryGap().gap(533));
    }
    public int gap(int number){
        int ONE = 1;
        int max = Integer.MIN_VALUE;
        int count = 0;
        boolean checkGap = false;
        while (number > 0){
            int rightBit = number & ONE;
            number >>= ONE;
            if (rightBit == 1){
                if (checkGap){
                    max = max > count ? max : count;
                    count = 0;
                } checkGap = true;
            } else {
                count = checkGap ? ++count : 0;
            }
        }
        return max;
    }
}
