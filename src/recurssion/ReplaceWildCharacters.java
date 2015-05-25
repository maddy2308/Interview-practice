package recurssion;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWildCharacters {

    private List<String> list = new ArrayList<String>();

    private void replaceAllWildCharacters(String str, int i) {
        if (!str.contains("?")) {
            list.add(str);
        } else {
            StringBuilder sb = new StringBuilder(str);
            for (; i <= str.indexOf('?'); i++) {
                if (str.charAt(i) == '?') {
                    char[] possibilities = new char[]{'0', '1'};
                    for (char ch : possibilities) {
                        sb.setCharAt(i, ch);
                        replaceAllWildCharacters(sb.toString(), i + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ReplaceWildCharacters obj = new ReplaceWildCharacters();
        obj.replaceAllWildCharacters("0??1??", 0);
        System.out.println(obj.list);
    }


}
