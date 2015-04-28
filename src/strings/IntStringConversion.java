package strings;

public class IntStringConversion {

    public static void main(String[] args) {
        IntStringConversion obj = new IntStringConversion();
        System.out.println(obj.toString(obj.toInteger("0")));
    }

    public String toString(int number){
        StringBuilder sb = new StringBuilder();
        if (number == 0){
            return "0";
        } else {
            boolean isNegative = (number < 0);
            if (isNegative) {
                number = -number;
            }
            while (number > 0) {
                int digit = number % 10;
                sb.append(digit);
                number /= 10;
            }
            if (isNegative) sb.append("-");
            return sb.reverse().toString();
        }
    }

    public int toInteger(String str){
        char ch = str.charAt(0);
        boolean isNegative = false;
        int placeHolder = 0;
        int number;
        if (ch == '-'){
            number = 0;
            isNegative = true;
        }else{
            placeHolder ++;
            number = ch-48;
        }
        for (int i = str.length() - 1; i >= 1; i--, placeHolder++){
            ch = str.charAt(i);
            if (ch >= 48 && ch <= 57){
                int digit = ch - 48;
                number += Math.pow(10, placeHolder) * digit;
            } else {
                throw new NumberFormatException();
            }
        }
        return isNegative? -number : number ;
    }
}
