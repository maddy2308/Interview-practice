package strings;

public class NumberToCSV {

    public static void main(String[] args) {
        System.out.println(new NumberToCSV().numToStr(-123456));
    }

    private String numToStr(int number) {
        String str = "";
        if (number < 0) {
            str = "-" + prettyString((number * -1) + "", 3);
        } else {
            str = prettyString(number + "", 3);
        }
        return str;
    }


    private String prettyString(String str, int places) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        String reversedString = new StringBuilder(str).reverse().toString();
        for (int index = 0; index < reversedString.length(); index++) {
            if (count < places) {
                sb.append(reversedString.charAt(index));
                count++;
            } else {
                sb.append(reversedString.charAt(index)).append(",");
                count = 1;
            }
        }
        String output = sb.reverse().toString(); //,123
        if (output.charAt(0) == ',') {
            return output.substring(1);//123
        }
        return output;
    }
}
