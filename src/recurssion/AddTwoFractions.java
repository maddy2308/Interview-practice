package recurssion;

public class AddTwoFractions {

    private Fraction f1, f2, finalFraction;

    private class Fraction {
        private int deno;
        private int num;

        public Fraction() {
        }

        public Fraction(int num, int deno) {
            this.num = num;
            this.deno = deno;
        }
    }

    public AddTwoFractions() {
        f1 = new Fraction(2, 3);
        f2 = new Fraction(3, 4);
        finalFraction = new Fraction();
    }

    public static void main(String[] args) {
        AddTwoFractions obj = new AddTwoFractions();
        int lcm = obj.findLcm(obj.f1.deno, obj.f2.deno);
        obj.finalFraction.deno = lcm;
        obj.finalFraction.num = obj.calculateNum(lcm, obj.f1) + obj.calculateNum(lcm, obj.f2);
        System.out.println(obj.finalFraction.num + "/" + obj.finalFraction.deno);
        int gcd = obj.findHcf(obj.finalFraction.num, obj.finalFraction.deno);
        if (gcd > 1) {
            obj.finalFraction.num /= gcd;
            obj.finalFraction.deno /= gcd;
            System.out.println(obj.finalFraction.num + "/" + obj.finalFraction.deno);
        }
    }

    private int calculateNum(int lcm, Fraction f) {
        return f.num * (lcm / f.deno);
    }

    public int findLcm(int a, int b) {
        int hcf = findHcf(a, b);
        System.out.println("GCD of " + a + ", " + b + " is " + hcf);
        return (a * b) / hcf;
    }

    public int findHcf(int a, int b) {
        return findHcf(1, 1, a, b);
    }

    private int findHcf(int divisor, int hcf, int a, int b) {
        if (divisor > a || divisor > b) {
            return hcf;
        } else {
            if ((a % divisor == 0) && (b % divisor == 0)) {
                hcf = divisor;
                return findHcf(divisor + 1, hcf, a, b);
            } else {
                return findHcf(divisor + 1, hcf, a, b);
            }
        }
    }

    private boolean isPrime(int number) {
        if (number == 1 || number == 2 || number == 3) {
            return true;
        } else {
            for (int i = 2; i <= (int) Math.sqrt(number); i++) {
                if (number % i == 0)
                    return false;
            }
            return true;
        }
    }
}
