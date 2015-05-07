package strings;

public class StringAddition {

    public static void main(String[] args) {
        StringAddition sa = new StringAddition();
        System.out.println(sa.subtractDriver("-11171", "89"));
    }

    private String addTwoStrings(String a, String b) {
        if (((a.charAt(0) == '-') && (b.charAt(0) == '-')) || ((a.charAt(0) != '-') && (b.charAt(0) != '-'))) {
            // add two strings
            return"";
        } else {
            return subtractDriver(a, b);
        }
    }

    private String additionDriver(String a, String b){
        String result = "";
        String aTemp = a;
        String bTemp = b;
        if ((a.charAt(0) == '-') && (b.charAt(0) == '-')){
            aTemp = removeNegativeSign(a);
            bTemp = removeNegativeSign(b);
        }

        return result;
    }

    private String subtractDriver(String a, String b) {
        // if only one of them is negative
        StringBuilder result;
        String aTemp = removeNegativeSign(a);
        String bTemp = removeNegativeSign(b);
        if (isFirstBigger(aTemp, bTemp)) {
            bTemp = makeStringsOfSameLength(bTemp, aTemp.length());
            result = new StringBuilder(subtract(aTemp, bTemp));
            if (a.charAt(0) == '-') {
                result.append('-');
            }
        } else {
            aTemp = makeStringsOfSameLength(aTemp, bTemp.length());
            result = new StringBuilder(subtract(bTemp, aTemp));
            if (b.charAt(0) == '-') {
                result.append('-');
            }
        }
        return result.reverse().toString();
    }

    private String makeStringsOfSameLength(String bTemp, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - bTemp.length(); i++) {
            sb.append("0");
        }
        sb.append(bTemp);
        return sb.toString();
    }

    private String removeNegativeSign(String a) {
        String str = a;
        if (a.charAt(0) == '-') {
            str = str.substring(1);
        }
        return str;
    }

    private boolean isFirstBigger(String aTemp, String bTemp) {
        int i;
        if (aTemp.length() == bTemp.length()) {
            // check character by character from front
            for (i = 0; i < aTemp.length(); i++) {
                int first = Integer.parseInt(aTemp.charAt(i) + "");
                int second = Integer.parseInt(bTemp.charAt(i) + "");
                if (first > second) break;
            }
            return i != aTemp.length();
        } else return aTemp.length() > bTemp.length();
    }

    // a > b
    // assuming they are numbers having digits only
    private String subtract(String a, String b) {
        String[] big = a.split(""); // has more digits
        String[] small = b.split(""); // has less or equal digits
        StringBuilder sb = new StringBuilder();
        for (int i = small.length - 1; i >= 1; i--) {
            int sm = Integer.parseInt(small[i]);
            int bg = Integer.parseInt(big[i]);
            if (sm > bg) {
                makeCarryAvailable(big, i - 1);
                bg += 10;
            }
            sb.append(bg - sm);
        }
        return sb.toString();
    }

    private void makeCarryAvailable(String[] big, int i) {
        int number = Integer.parseInt(big[i]);
        if (number > 0) {
            big[i] = (--number) + "";
        } else {
            makeCarryAvailable(big, i - 1);
        }
    }
}
