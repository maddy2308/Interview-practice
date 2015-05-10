package epic;

public class WellOrderedString {

    public static void main(String[] args) {
        wellOrderedSubSequence(8, "");
    }

    public static void wellOrderedSubSequence(int length, String result) {
        if (result.length() == length) {
            System.out.println(result);
        } else {
            int previous;
            if ((result.length() - 1) < 0) {
                previous = 0;
            } else {
                previous = Integer.parseInt(result.charAt(result.length() - 1) + "");
            }
            for (int i = previous + 1; i <= 9; i++) {
                wellOrderedSubSequence(length, result + i);
            }
        }
    }
}
