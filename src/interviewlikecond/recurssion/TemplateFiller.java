package interviewlikecond.recurssion;

import java.util.ArrayList;
import java.util.List;

public class TemplateFiller {
    private List<String> list = new ArrayList();

    public void makeStatements(List<List<String>> lor, int lIndex, String str) {

        if (lIndex == lor.size()) {
            list.add(str);
        } else {
            for (String s : lor.get(lIndex)) {
                String temp = str.replaceFirst(lIndex + "", s);
                makeStatements(lor, lIndex + 1, temp);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lor = new ArrayList<List<String>>();
        List<String> replacement = new ArrayList<String>();
        String template = "0 went to the 1";

        replacement.add("sam");
        replacement.add("bob");
        replacement.add("frank");
        lor.add(replacement);

        replacement = new ArrayList<String>();
        replacement.add("beach");
        replacement.add("park");
        replacement.add("zoo");
        lor.add(replacement);

        TemplateFiller tf = new TemplateFiller();
        tf.makeStatements(lor, 0, template);
        System.out.println(tf.list.toString());
    }

}
