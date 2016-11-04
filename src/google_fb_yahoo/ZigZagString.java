package google_fb_yahoo;

public class ZigZagString {

    /*  Given two String arrays combine and return one string which zigzags the letters.
        So A = { dog,elephant,cat} B = {cow,pig}. Return "dcoogwepliegphantcat"
    */

    public static void main(String[] args) {
        String[] a = {"dog", "elephant", "cat"}, b = {"cOw", "pig"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < a.length || j < b.length; i++, j++) {
            String str1 = i < a.length ? a[i] : "", str2 = j < b.length ? b[j] : "";
            sb = createZizZagPattern(str1, str2, sb);
        }
        System.out.println(sb.toString());
    }

    private static StringBuilder createZizZagPattern(String str1, String str2, StringBuilder result) {
        if (isEmpty(str1) && isEmpty(str2)) {
            return result;
        } else if (isEmpty(str1)) {
            return result.append(str2);
        } else if (isEmpty(str2)) {
            return result.append(str1);
        } else {
            result.append(str1.charAt(0)).append(str2.charAt(0));
            return createZizZagPattern(str1.substring(1), str2.substring(1), result);
        }
    }

    private static boolean isEmpty(String sb) {
        return ((sb == null) || (sb.trim().length() == 0) || sb.equals(""));
    }
}
