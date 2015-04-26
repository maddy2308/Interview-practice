package bitManipulationProblems;

public class SetKthBit {

    public static void main(String[] args){
        SetKthBit obj = new SetKthBit();
        //obj.setKBit(45, 4);
        obj.setKBitOff(45, 4);
        System.out.println(obj.addTwoNumbers(14123 , 453115));
    }

    private int setKBitOff(int myNumber, int k) {
        System.out.println(Integer.toBinaryString(myNumber));
        int ONE = 1;
        int mask = ~(ONE << (k-1));
        myNumber = (myNumber & mask);
        System.out.println(Integer.toBinaryString(myNumber));
        return myNumber;
    }

    private int setKBit(int myNumber, int k) {
        System.out.println(Integer.toBinaryString(myNumber));
        int ONE = 1;
        int mask = ONE << (k-1);
        myNumber = myNumber | mask;
        System.out.println(Integer.toBinaryString(myNumber));
        return myNumber;
    }

    private int addTwoNumbers(int a, int b){
        int carry;
        while (b > 0) {
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
