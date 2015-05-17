package recurssion;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(recurssionSqrt(23, 0, 100, 0.001f));
    }

    private static float recurssionSqrt(int number, float left, float right, float precision) {
        float mid = (left + right) / 2;
        if (Math.abs((mid * mid) - number) <= precision) {
            return mid;
        } else {
            if (mid * mid > number) {
                return recurssionSqrt(number, left, mid, precision);
            } else {
                return recurssionSqrt(number, mid, right, precision);
            }
        }
    }

}
