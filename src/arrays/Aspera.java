package arrays;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Aspera {

    private static Set<String> set = new HashSet<String>(1000);
    private static Queue<String> newWords = new LinkedList<String>();

    public static void main(String[] args) throws IOException {
        readFile("//Users//maddy//Desktop//words.txt");
        //System.out.println(set);
        System.out.println(wordCreation());
    }

    private static void readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String line = br.readLine();

            while (line != null) {
                set.add(line.trim());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    private static int wordCreation() {
        int maxLength = -1;
        for (String str : set) {
            if (str.length() > 0) {
                for (String s : set) {
                    if (s.length() > 0) {
                        String newWord = str + s;
                        if (set.contains(newWord)) {
                            newWords.add(newWord);
                            maxLength = newWord.length() > maxLength ? newWord.length() : maxLength;
                        }
                    }
                }
            }
        }
        while (!newWords.isEmpty()) {
            int i = 0;
            for (String s : set) {
                String newWord = newWords.poll() + s;
                if (set.contains(newWord)) {
                    newWords.add(newWord);
                    maxLength = newWord.length() > maxLength ? newWord.length() : maxLength;
                }
            }
        }
        return maxLength;
    }


}
