package strings;

public class RemoveExtraSpaces {


    private static String removeRedundantSpace(String str) {

        StringBuilder sb = new StringBuilder();
        boolean isFirstSpace = false;
        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                if (!isFirstSpace) {
                    sb.append(' ');
                    isFirstSpace = true;
                }
            } else {
                isFirstSpace = false;
                sb.append(ch);
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(removeRedundantSpace(""));
    }

}
