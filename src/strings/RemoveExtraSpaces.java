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

    private static String removeRedundantSpacesMethod2(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split("\\s+");
        for (String s : split) {
            sb.append(s).append(" ");
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(removeRedundantSpacesMethod2("This is      a     tests   "));
    }

}
