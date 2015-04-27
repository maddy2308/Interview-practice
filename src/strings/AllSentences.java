package strings;

/*
You have list of list of string find out all combinations of sentences that could be formed from these lists.
List1 -> "hello how are" List2 -> "hi wow" List3 -> "world continent" .
Output -> hello hi world, hello hi continent, hello wow world and so on…
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSentences {

    private List<List<String>> input;
    private List<String> output;
    private int sizeOfSentence;

    public static void main(String[] args) {
        AllSentences obj = new AllSentences();
        obj.createSentence(0, "");
        System.out.println(obj.output);
    }

    public AllSentences() {
        input = new ArrayList<List<String>>();
        input.add(Arrays.asList("hello", "how", "are"));
        input.add(Arrays.asList("hi", "wow"));
        input.add(Arrays.asList("world", "continent"));
        sizeOfSentence = input.size();
        output = new ArrayList<String>();
    }

    private void createSentence(int listNumber, String sentenceSoFar) {
        if (sentenceSoFar.split(",").length == sizeOfSentence) {
            output.add(sentenceSoFar);
        } else {
            List<String> tempList = input.get(listNumber);
            for (String str : tempList) {
                createSentence(listNumber + 1, sentenceSoFar + str + ",");
            }
        }
    }
}
