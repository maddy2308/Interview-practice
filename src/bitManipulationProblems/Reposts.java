package bitManipulationProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reposts {

    static int max = 0;
    static String[] arr;
    static String previous = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        try {
            String line = br.readLine();
            while (line != null) {
                int numberOfPosts = Integer.parseInt(line);
                line = br.readLine();
                arr = line.split("reposted");
                reInit();
                for (int i = 1; i < numberOfPosts; i++) {
                    line = br.readLine();
                    arr = line.split("reposted");
                    if ((arr.length == 2) && (arr[1].toLowerCase().trim().equals(previous.toLowerCase()))) {
                        previous = arr[0].toLowerCase().trim();
                        max++;
                    } else {
                        reInit();
                    }
                }
                System.out.println(max);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
    }

    private static void reInit() {
        if ((arr.length == 2) && (arr[1].toLowerCase().trim().equals("polycarp"))) {
            previous = arr[0].toLowerCase().trim();
            max = 2;
        }
    }
}
