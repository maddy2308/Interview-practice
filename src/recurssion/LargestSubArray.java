package recurssion;

public class LargestSubArray {

    private int globalMaxLength = 2;

    public static void main(String[] args) {
        new LargestSubArray().printAllSubArrays("1010101");
        //System.out.println("1010".substring(3, 4));
    }

    private void printAllSubArrays(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = globalMaxLength; i + j < str.length(); j += globalMaxLength) {
                System.out.println(str.substring(i, i + j));
            }
        }
    }

    private void updateGlobalLength(String str, int sumSoFar) {

    }
}
