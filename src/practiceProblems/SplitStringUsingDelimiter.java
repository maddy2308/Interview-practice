package practiceProblems;


public class SplitStringUsingDelimiter {

    private static void splitString(String str, String delimiter) {
        char[] sArray = str.toCharArray();
        char[] dArray = delimiter.toCharArray();
        int j, k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArray.length; i++) {
            for (k = 0, j = i; k < dArray.length; k++, j++) {
                if (dArray[k] != sArray[j]) break;
            }
            if (k == dArray.length) {
                System.out.println(sb.toString());
                sb = new StringBuilder();
                i = j - 1;
            } else {
                sb.append(sArray[i]);
            }
        }
        if (sb.length() > 0)
            System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        splitString("This is a test which is to test delimiter", "Madhur");
    }
}
