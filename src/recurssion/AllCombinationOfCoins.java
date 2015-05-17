package recurssion;

import java.util.Arrays;
import java.util.Collections;

public class AllCombinationOfCoins {

    private Integer[] denominationAvailable = {1, 5, 10, 25, 100};
    public static void main(String[] args) {
        AllCombinationOfCoins obj = new AllCombinationOfCoins();
        obj.recursivePrint(320, "");
    }

    public AllCombinationOfCoins(){
        Arrays.sort(denominationAvailable, Collections.reverseOrder());
    }

    private void recursivePrint(int sum, String combination){
        if (sum == 0){
            System.out.println(combination);
        } else {
            for (int denomination : denominationAvailable) {
                if (sum - denomination >= 0) {
                    recursivePrint(sum - denomination, combination + denomination + ",");
                }
            }
        }
    }
}
