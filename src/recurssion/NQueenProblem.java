package recurssion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
The following algorithm follows a backtracking approach to place N queens in a chessboard of N*N size such that no queen
is attacking another Queen. The valid moves for the queen are move any number of square in horizontal, vertical or
diagonal direction. It is one of the classical problems of recursion. It uses the technique of trying to place a queen
in each column. If the program is successful in doing that then it returns the changed array, by placing queen numbered
from "0 to N" and all other cells marked as "-1" representing empty cell. If the program is unsuccessful then it prints
out "Not possible to place the N-Queens".
*/

public class NQueenProblem {

    private Set<String> queenAdded = new HashSet<String>();
    private int[][] chess;

    public NQueenProblem(int n){
        chess = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = -1;
            }
        }
    }

    public static void main(String[] args){
        int n = 8;
        NQueenProblem obj = new NQueenProblem(n);
        if (obj.setNQueens(0)){
            for (int i = 0; i < obj.chess[0].length; i++){
                System.out.println(Arrays.toString(obj.chess[i]));
            }
        } else {
            System.out.println("Not possible to place the " + n + "-Queens");
        }
    }

    public boolean setNQueens(int queens) {
        boolean flag;
        if (queens == chess[0].length) {
            return true;
        } else {
            for (int j = 0; j < chess[0].length; j++) {
                String queenPosn = j + "," + queens;
                if (isSafe(j, queens)) {
                    chess[j][queens] = queens;
                    queenAdded.add(queenPosn);
                    flag = setNQueens(queens+1);
                    if (!flag){
                        chess[j][queens] = -1;
                        queenAdded.remove(queenPosn);
                    } else{
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private boolean isSafe(int i, int j) {
        for (String str : queenAdded) {
            String[] arr = str.split(",");
            if ((Integer.parseInt(arr[0]) == i) || (Integer.parseInt(arr[1]) == j)) {
                return false;
            }
            if (Math.abs(i - Integer.parseInt(arr[0])) == Math.abs(j - Integer.parseInt(arr[1]))){
                return false;
            }
        }
        return true;
    }
}
