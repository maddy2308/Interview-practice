package strings;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class AddTwoStrings {

    public static void main(String[] args) {
        System.out.println(new AddTwoStrings().add(6, 5));
        System.out.println(new AddTwoStrings().addStringsAsNumbers(new StringBuilder("11452"), new StringBuilder("13")));
    }

    private int add(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    private String addStringsAsNumbers(StringBuilder str1, StringBuilder str2){
        int length1 = str1.length() - 1;
        int length2 = str2.length() - 1;
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[Math.abs(length1 - length2)];
        Arrays.fill(chars, '0');
        String rep = new String(chars);
        if (length1 < length2){
            str1.reverse().append(rep).reverse();
        } else {
            str2.reverse().append(rep).reverse();
        }
        int carry = 0;
        for (int index = length1; index >= 0; index --){
            int digit1 = str1.charAt(index) - '0';
            int digit2 = str2.charAt(index) - '0';
            int sum = carry + digit1 + digit2;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return (carry > 0) ? sb.append(carry).reverse().toString() : sb.reverse().toString();
    }
}
