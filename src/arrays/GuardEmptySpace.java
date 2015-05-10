package arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GuardEmptySpace {

    /*char[][] museum = {
            {'.', '#', '.', 'G', '.'},
            {'.', '.', '#', '.', '.'},
            {'G', '.', '.', '.', '.'},
            {'.', '.', '#', '.', '.'}
    };*/

    char[][] museum = {
            {'.', '.', '.', 'G'},
            {'.', '.', '.', '.'},
            {'G', '#', '#', '.'},
            {'.', 'G', '#', '.'}
    };
    int[][] space = new int[museum.length][museum[0].length];

    Queue<String> q;
    Set<String> set;

    public static void main(String[] args) {
        GuardEmptySpace ges = new GuardEmptySpace();
        ges.findSpace();
    }

    private void findSpace() {
        for (int i = 0; i < museum.length; i++) {
            for (int j = 0; j < museum[0].length; j++) {
                if (museum[i][j] == 'G') {
                    //set n, s, e, w to be accessible in just one unit of space if they are not having #
                    setSpace(i, j);
                    space[i][j] = Integer.MIN_VALUE;
                } else if (museum[i][j] == '#') {
                    space[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < museum.length; i++) {
            for (int j = 0; j < museum[0].length; j++) {
                q = new LinkedList<String>();
                set = new HashSet<String>();
                if (space[i][j] == 0) {
                    set.add(i + "," + j);
                    q.add(i + "," + j);
                    setPath(performBFS());
                }
            }
        }

        for (int i = 0; i < museum.length; i++) {
            for (int j = 0; j < museum[0].length; j++) {
                if (space[i][j] == Integer.MIN_VALUE) {
                    System.out.print("G");
                } else if (space[i][j] == Integer.MAX_VALUE) {
                    System.out.print("#");
                } else {
                    System.out.print(space[i][j]);
                }
            }
            System.out.println();
        }
    }

    private void setPath(String s) {
        String[] split = s.split(";");
        int k = 1;
        for (int i = split.length - 2; i >= 0; i--, k++) {
            String[] split2 = split[i].split(",");
            space[Integer.parseInt(split2[0])][Integer.parseInt(split2[1])] = k;
        }
    }

    private String performBFS() {
        int i, j;
        while (!q.isEmpty()) {
            StringBuilder sb = new StringBuilder(q.poll());
            String str = getIndexString(sb.toString());
            String[] split = str.split(",");
            i = Integer.parseInt(split[0]);
            j = Integer.parseInt(split[1]);
            if (museum[i][j] == 'G') {
                return sb.toString();
            } else {
                changeQueue(sb.toString(), i - 1, j);
                changeQueue(sb.toString(), i + 1, j);
                changeQueue(sb.toString(), i, j - 1);
                changeQueue(sb.toString(), i, j + 1);
            }
        }
        return "";
    }

    private void changeQueue(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        if (isGoodCell(i, j)) {
            q.add(sb.append(";").append(i).append(",").append(j).toString());
            set.add(i + "," + j);
        }
    }

    private String getIndexString(String str) {
        String[] split = str.split(";");
        int size = split.length;
        return split[size - 1];
    }

    private boolean isGoodCell(int i, int j) {
        if ((i < museum.length && i >= 0) && (j < museum[0].length && j >= 0)) {
            if ((!set.contains(i + "," + j)) && (space[i][j] != Integer.MAX_VALUE)) {
                return true;
            }
        }
        return false;
    }

    private void setSpace(int i, int j) {
        // set north
        if ((i - 1 >= 0) && (space[i - 1][j] != '#')) {
            space[i - 1][j] = 1;
        }
        // set south
        if ((i + 1 < museum.length) && (space[i + 1][j] != '#')) {
            space[i + 1][j] = 1;
        }
        //set east
        if ((j - 1 >= 0) && (space[i][j - 1] != '#')) {
            space[i][j - 1] = 1;
        }
        if ((j + 1 < museum[0].length) && (space[i][j + 1] != '#')) {
            space[i][j + 1] = 1;
        }
    }
}
