package topCoderPracticeProblems;

public class Singing {

    public static void main(String[] args){
        int[] pitch  = {1,4,3,5,2,5,7,5,9};
        System.out.println(new Singing().solve(10, 4, 5, pitch));
    }
    public int solve(int N, int low, int high, int[] pitch){
        int maxWhenBobStarts = 0, maxWhenAliceStarts = 0;
        boolean isBobSinging = true;
        // start with bob first
        for (int p : pitch){
            if (isBobSinging &&!(canBobSing(p, 1, high))){
                maxWhenBobStarts++;
                isBobSinging = false;
            } else {
                if (!isBobSinging && !canAliceSing(p, low, N)){
                    maxWhenBobStarts++;
                    isBobSinging = true;
                }
            }
        }
        boolean isAliceSinging = true;
        // start with Alice first
        for (int p : pitch){
            if (isAliceSinging &&!(canAliceSing(p, 1, high))){
                maxWhenAliceStarts++;
                isAliceSinging = false;
            } else {
                if (!isAliceSinging && !canBobSing(p, low, N)){
                    maxWhenAliceStarts++;
                    isAliceSinging = true;
                }
            }
        }
        return maxWhenBobStarts > maxWhenAliceStarts ? maxWhenAliceStarts : maxWhenBobStarts;
    }

    private boolean canBobSing(int pitch, int low, int high){
        return pitch >= low && pitch <= high;
    }

    private boolean canAliceSing(int pitch, int low, int high){
        return pitch >= low && pitch <= high;
    }

}
