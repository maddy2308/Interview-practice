package hackerank.hash_table;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

    private Map<String, Integer> magazineMap;
    private Map<String, Integer> noteMap;

    private RansomNote(String magazine, String note) {
        magazineMap = createMap(magazine.split(" "));
        noteMap = createMap(note.split(" "));
    }

    private boolean solve() {
        for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
            if (!magazineMap.containsKey(entry.getKey()) || !(magazineMap.get(entry.getKey()) >= entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        if (m < n) {
            System.out.println("No");
        } else {
            // Eat whitespace to beginning of next line
            scanner.nextLine();

            RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
            scanner.close();
            boolean answer = s.solve();
            if (answer)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private Map<String, Integer> createMap(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            int freq = 1;
            if (map.containsKey(word)) {
                freq = map.get(word) + 1;
            }
            map.put(word, freq);
        }
        return map;
    }
}
