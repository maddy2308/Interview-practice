package bitManipulationProblems;

public class SingleNumber {

    public static void main(String[] args){
        System.out.println(new SingleNumber().singleNumber(new int[]{4, 8, 4, 6, 1, 8, 6}));
    }

    public int singleNumber(int[] A) {
        int x = 0;

        for (int a : A) {
            x = x ^ a;
        }

        return x;
    }
}
