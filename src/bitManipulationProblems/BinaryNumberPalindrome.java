package bitManipulationProblems;


public class BinaryNumberPalindrome {

    private int myNumber = 53;
    public BinaryNumberPalindrome(int number){
        this.myNumber = number;
    }

    public static void main(String[] args) {
        BinaryNumberPalindrome obj = new BinaryNumberPalindrome(9);
        System.out.println(obj.isPalindrome());
        obj.swapBits(23);
        obj.swapNibbles(100);
    }

    private void swapNibbles(int x){
        System.out.println(Integer.toBinaryString(x));
        int leftNibble = (0xF0 & x) >> 4;
        int rightNibble = (0x0F & x) << 4;
        System.out.println(Integer.toBinaryString(rightNibble | leftNibble));
    }

    private void swapBits(int x){
        int evenBits = x & 0xAA;
        int oddBits  = x & 0x55;

        System.out.println(Integer.toBinaryString(evenBits));
        System.out.println(Integer.toBinaryString(oddBits));
        System.out.println(Integer.toBinaryString(evenBits >> 1 | oddBits << 1));
    }

    private boolean isPalindrome(){
        int length = Integer.toBinaryString(myNumber).length();
        for (int i = 0; i < length/2; i++){
            if (isKthBitSet(myNumber, i) != isKthBitSet(myNumber, length-i-1)){
                return false;
            }
        }
        return true;
    }

    private boolean isKthBitSet(int x, int k){
        int kthBit = (x >> k) & 1;
        return (kthBit == 1);
    }
}
