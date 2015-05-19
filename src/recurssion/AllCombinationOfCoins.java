package recurssion;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AllCombinationOfCoins {

    private Integer[] denominationAvailable = {1, 5, 10, 25, 100};
    private Set<String> set = new HashSet<String>();

    public static void main(String[] args) {
        AllCombinationOfCoins obj = new AllCombinationOfCoins();
        obj.recursivePrint(320, "");
        for (String s : obj.set) {
            System.out.println(s);
        }
    }

    public AllCombinationOfCoins() {
        Arrays.sort(denominationAvailable, Collections.reverseOrder());
    }

    private void recursivePrint(int sum, String combination) {
        if (sum == 0) {
            String[] arr = (combination.split(","));
            Arrays.sort(arr);
            set.add(Arrays.toString(arr));
            //System.out.println(combination);
        } else {
            for (int denomination : denominationAvailable) {
                if (sum - denomination >= 0) {
                    recursivePrint(sum - denomination, combination + denomination + ",");
                }
            }
        }
    }
}
