package dp;

public class AllPermutationOfArray {

    public static void main(String[] args) {
        recurse("123".toCharArray(), "");
    }

    // recursive solution
    static void recurse(char[] arr, String permutationSoFar) {
        if (arr.length == 0) {
            System.out.println(permutationSoFar);
        } else {
            for (int i = 0; i < arr.length; i++) {
                char[] splicedArray = splice(arr, i);
                recurse(splicedArray, permutationSoFar + arr[i]);
            }
        }
    }

    private static char[] splice(char[] arr, int i) {
        char[] temp = new char[arr.length - 1];
        int j = 0;
        for (int index = 0; index < arr.length; index++) {
            if (index != i) {
                temp[j] = arr[index];
                j++;
            }
        }
        return temp;
    }

}
