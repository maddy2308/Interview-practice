package recurssion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anagrams {

    private List<String> list = new ArrayList<String>();
    private final int LENGTH;

    public Anagrams(String str) {
        LENGTH = str.length();
        getAnagrams(str, "");
        Collections.sort(list);
        StringBuilder builder = new StringBuilder();
        for (String value : list) {
            builder.append(value).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        //Anagrams obj = new Anagrams("abc");
        getAllSubSequences("abc", "");

    }

    private void getAnagrams(String str, String anagram) {
        System.out.println(anagram);
        if (anagram.length() == LENGTH) {
            //System.out.println(anagram);
            //list.add(anagram);
        } else {
            for (int index = 0; index < str.length(); index++) {
                String s = str.substring(0, index) + str.substring(index + 1);
                getAnagrams(s, anagram + str.charAt(index));
            }
        }
    }

    private static void getAllSubSequences(String str, String subSequence) {
        System.out.println(subSequence);
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(0, i) + str.substring(i + 1);
            getAllSubSequences(s, subSequence + str.charAt(i));
        }
    }


}
