package practiceProblems;

public class Hcf {

    public static void main(String[] args) {
        Double number = .125;
        int decPower = convertDecimalToWholeNumber(number);
        int deno = (int) Math.pow(10, decPower);
        int num = (int) (deno * number);
        int hcf = findHcf(deno, num, deno);
        System.out.println(num/hcf + "/" + deno/hcf);
    }

    // assuming a > b
    public static int findHcf(int a, int b, int divisor) {
        if (divisor == 1) {
            return 1;
        } else if ((b % divisor == 0) && (a % divisor == 0)) {
            return divisor;
        } else {
            return findHcf(a, b, divisor - 1);
        }
    }

    private static int convertDecimalToWholeNumber(Double number){
        String str = number+"";
        return str.length() - str.indexOf(".") - 1;
    }
}
