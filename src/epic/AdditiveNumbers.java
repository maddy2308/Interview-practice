package epic;

public class AdditiveNumbers {

    public static void main(String[] args) {
        AdditiveNumbers an = new AdditiveNumbers();
        an.generatefirstNumber("123459");
        System.out.println();
        an.generatefirstNumber("314538");
        System.out.println();
        an.generatefirstNumber("122436");
        System.out.println();
        an.generatefirstNumber("1241125");
    }


    private void generatefirstNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i);
            for (int length = 1; length <= str.length() / 2; length++) {
                String first = str.substring(0, length);
                recurse(first, str.substring(length));
            }
        }
    }

    // given a string generate all possible combinations for second number
    private void recurse(String first, String str) {
        int i = 1;
        String second = "";
        String temp = str;
        int maxLength = Math.max(first.length(), second.length());
        while (temp.length() >= maxLength) {
            second = str.substring(0, i);
            maxLength = Math.max(first.length(), second.length());
            temp = str.substring(i);
            if ((temp.length() >= maxLength) &&
                    (Integer.parseInt(first) + Integer.parseInt(second) == Integer.parseInt(temp.substring(0, maxLength)))) {
                System.out.println(first + " " + second);
            }
            i++;
        }
    }

}
