package epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitNumber {
    public static void main(String[] args) {
        //splits("967", "1000");
        //additiveNumbers("123459");
        //printAllSeedNumber(738);
        generatePhoneNumbers(4, Arrays.asList(2, 3, 4, 7, 9));
    }

    public static void splits(String number1, String number2) {
        int num = Integer.parseInt(number2);
        String half1, half2;
        for (int index = 1; index < number1.length(); index++) {
            half1 = number1.substring(0, index);
            half2 = number1.substring(index);
            if ((Integer.parseInt(half1) + Integer.parseInt(half2)) <= num) {
                System.out.println(half1 + "--" + half2);
            }
        }

    }

    /*
    You need to generate all possible permutations of phone numbers of a certain length, except
        a) two same digits can not be next to each other,
        b) cannot contain digits from a given list of exclusion
        c) if number contains 4, must start with 4 as well.
     */

    private static void generatePhoneNumbers(int length, List<Integer> exclusions) {
        List<Integer> allowedNumbers = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++) {
            if (!exclusions.contains(i)) allowedNumbers.add(i);
        }
        if (allowedNumbers.contains(4)) {
            recurse(length, allowedNumbers, "4");
        } else {
            recurse(length, allowedNumbers, "");
        }
    }

    private static void recurse(int length, List<Integer> allowedNumbers, String soFar) {
        if (soFar.length() == length) {
            System.out.println(soFar);
        } else {
            for (int digit : allowedNumbers) {
                if (soFar.length() > 0) {
                    int last = soFar.charAt(soFar.length() - 1) - '0';
                    if (last != digit) {
                        recurse(length, allowedNumbers, soFar + digit);
                    }
                } else {
                    recurse(length, allowedNumbers, soFar + digit);
                }
            }
        }
    }


    private static void printAllSeedNumber(int n) {

        List<Integer> list = new ArrayList<Integer>();
        // get all factors of a number
        for (int i = n / 2; i >= 2; i--) {
            if (n % i == 0)
                list.add(i);
        }

        for (int factor : list) {
            int mul = factor;
            int temp = factor;
            while (temp > 0) {
                mul *= (temp % 10);
                if (mul > n) break;
                temp = temp / 10;
            }
            if (mul == n) {
                System.out.println(factor);
            }
        }
    }

    private static void snakeProblem() {

    }


    private static void additiveNumbers(String str, int n) {

    }
}
