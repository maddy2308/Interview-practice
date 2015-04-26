package bitManipulationProblems;

public class MissingElement {
    public static void main(String[] args){
        int [] arr = {3, 4, 15};
        int[] missingElementArr = {3, 4};
        System.out.println(doXor(missingElementArr,doXor(arr, 0)));
    }

    private static int doXor (int[] arr, int xor){
        // do for another array with missing element
        for (int element : arr) {
            xor = element ^ xor;
            //System.out.println(xor);
        }
        return xor;
    }
}
