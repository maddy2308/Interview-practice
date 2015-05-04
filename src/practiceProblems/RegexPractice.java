package practiceProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class
        RegexPractice {

    private static String address = "41-3 Otis Street, Somerville, MA-02145, " +
            "4348516455" +
            "1-(434)-851-6455" +
            "1 434 851 6455" +
            "434-851-6455" +
            "(434)-851-6455," +
            " madhur.eng@gmail.com, " +
            " madhur_mehta@schneider-electric.com" +
            " mehta.ma@husky.neu.edu, MS from Northeastern University";

    private static String random = "AAA dsds {{{{ $$$$ 44422234234 fddfg sdhi374326 }}}}}";

    public static void main(String[] args) {
        //finding phone number
        applyRegex("(\\d{9})|((\\d(-| )?)?(\\(?\\d{3}\\)?(-| )?\\d{3}(-| )?\\d{4}))", address);

        // finding email ids
        applyRegex("[A-Za-z0-9%-_]+@[A-Za-z0-9%-_]+\\.\\w{2,3}", address);
    }

    private static void applyRegex(String regex, String strToApplyOn) {
        Pattern pattern = Pattern.compile(regex);
        Matcher regexMatcher = pattern.matcher(strToApplyOn);

        while (regexMatcher.find()){
            if (regexMatcher.group().length() > 0){
                System.out.print(regexMatcher.group().trim());
            }
            System.out.println();
        }
    }


}
