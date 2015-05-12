package epic;

import java.util.ArrayList;
import java.util.List;

public class AnagramsWithFixedPosition {

    private List<String> list;
    private List<List<String>> listOfListOfAnagrams = new ArrayList<List<String>>();
    private List<Integer> listOfBreaks = new ArrayList<Integer>();
    private String targetString;
    private int LENGTH;

    public static void main(String[] args) {
        AnagramsWithFixedPosition obj = new AnagramsWithFixedPosition("ABC");
    }

    public AnagramsWithFixedPosition(String str) {
        String[] split = breakString(str);
        this.targetString = str;
        for (String s : split) {
            list = new ArrayList<String>();
            LENGTH = s.length();
            getAnagrams(s, "");
            System.out.println(list);
            listOfListOfAnagrams.add(list);
        }
        LENGTH = targetString.length();
        createStrings(0, "");
    }

    private void createStrings(int index, String str) {
        if (str.length() == LENGTH) {
            System.out.println(str);
        } else {
            if (listOfListOfAnagrams.size() <= index) {
                String s1 = targetString.charAt(listOfBreaks.get(index)) + "";
                createStrings(index + 1, str + s1);
            } else {
                List<String> temp = listOfListOfAnagrams.get(index);
                for (String s : temp) {
                    String s1;
                    if (listOfBreaks.size() <= index) {
                        s1 = s;
                    } else {
                        if (listOfBreaks.get(index) < s.length()) {
                            s1 = targetString.charAt(listOfBreaks.get(index)) + s;
                        } else {
                            s1 = s + targetString.charAt(listOfBreaks.get(index));
                        }
                    }
                    createStrings(index + 1, str + s1);
                }
            }
        }
    }


    private String[] breakString(String str) {
        int i = 0;
        for (char ch : str.toCharArray()) {
            if (ch >= 65 && ch <= 91) {
                listOfBreaks.add(i);
            }
            i++;
        }
        return str.split("[A-Z]");
    }

    private void getAnagrams(String str, String anagram) {
        if (anagram.length() == LENGTH) {
            list.add(anagram);
            return;
        } else {
            for (int index = 0; index < str.length(); index++) {
                String s = str.substring(0, index) + str.substring(index + 1);
                getAnagrams(s, anagram + str.charAt(index));
            }
        }
    }
}
