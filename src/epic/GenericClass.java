package epic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericClass {
    public static void main(String[] args) {
        //splits("967", "1000");
        //additiveNumbers("123459");
        //printAllSeedNumber(738);
        //generatePhoneNumbers(4, Arrays.asList(2, 3, 4, 7, 9));
        // System.out.println(isNumberColorful("243", "", 4));
        // getAllSteppingNumbers(1, (long) Math.pow(10, 15));
        ConvertAnagrams("ACADBB".toCharArray(), "DCBABA".toCharArray(), 6);
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

    // check for repeating digits and length of number > 2
    private static Set<Integer> set = new HashSet<Integer>();

    private static boolean isNumberColorful(String number, String result, int length) {
        int l = result.split(",").length;
        if (l > 1 && l < length) {
            System.out.println(result);
            if (isPresent(set, result)) {
                return false;
            }
        }
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            String s = number.substring(i + 1);
            if (result.length() > 0) {
                boolean flag = isNumberColorful(s, result + "," + ch, length);
                if (!flag) return flag;
            } else {
                boolean flag = isNumberColorful(s, ch + "", length);
                if (!flag) return flag;
            }
        }
        return true;
    }

    private static boolean isPresent(Set<Integer> set, String result) {
        String str[] = result.split(",");
        int mul = 1;
        for (String aStr : str) {
            mul *= Integer.parseInt(aStr);
        }
        return !set.add(mul);

    }

    private static void getAllSteppingNumbers(long start, long end) {
        for (long i = start; i <= end; i++) {
            if (isSteppingNumber(i + "")) {
                System.out.println(i);
            }
        }
    }

    private static boolean isSteppingNumber(String number) {
        char[] arr = number.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            int left = arr[i - 1] - '0';
            int right = arr[i] - '0';
            if (!((Math.abs(left - right)) == 1)) {
                return false;
            }
        }
        return true;
    }


    private static void ConvertAnagrams(char src[], char dst[], int n) {

    }

    private static void swap(char[] src, int i, int j) {
        char temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }
}







/*
for (int cur = 0; cur < n; ++cur) {
    if (src[cur] == dst[cur]) continue;
    int ct = cur + 1;
    for (; src[ct] != dst[cur] && ct < n; ++ct) ;
    for (; ct != cur; --ct) {
        swap(src, ct, ct - 1);
        System.out.println(Arrays.toString(src));
    }
}
 */