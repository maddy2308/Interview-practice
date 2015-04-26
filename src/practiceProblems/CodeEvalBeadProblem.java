package practiceProblems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodeEvalBeadProblem {

    private static Boolean[] isPrime = new Boolean[30];
    private static Set<String> set = new HashSet<String>();
    private int size = 0;

    public CodeEvalBeadProblem() {
        isPrime[0] = true;
        isPrime[1] = true;
        isPrime[2] = true;
    }

    public static void main(String[] args) throws IOException {
        CodeEvalBeadProblem obj = new CodeEvalBeadProblem();
        List<Integer> list = new ArrayList<Integer>();
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            for (int i = 0; i < Integer.parseInt(line); i++) {
                list.add(i + 1);
                obj.size = i < 9 ? obj.size + 1 : obj.size + 2;
            }
            list.remove(0);
            obj.createNecklace(list, "1");
            System.out.println(set.size());
            obj.clear(list, set);
        }
        buffer.close();
    }

    private void clear(List<Integer> list, Set<String> set) {
        CodeEvalBeadProblem.set.clear();
        list.clear();
        size = 0;
    }

    private void createNecklace(List<Integer> list, String necklaceSoFar) {
        if (necklaceSoFar.length() == size) {
            if (checkIfDigitToAdd(new StringBuilder(necklaceSoFar), necklaceSoFar.charAt(0))) {
                addNewNecklace(necklaceSoFar);
            }
        } else if (!(list.isEmpty())) {
            for (int index = 0; index < list.size(); index++) {
                StringBuilder sb = new StringBuilder(necklaceSoFar);
                if (checkIfDigitToAdd(sb, list.get(index))) {
                    sb.append(list.get(index));
                    createNecklace(getSubList(list, index), sb.toString());
                }
            }
        }
    }

    private void addNewNecklace(String necklace) {
        if (set.isEmpty()) {
            set.add(necklace);
        } else {
            for (String s : set) {
                if (isSameCombination(s, necklace)) {
                    return;
                }
            }
            set.add(necklace);
            //System.out.println(necklace);
        }
    }

    private boolean checkIfDigitToAdd(StringBuilder sb, int toAdd) {
        int current = sb.length() > 0 ? sb.charAt(sb.length() - 1) - '0' : 0;
        int numberToCheck = current + toAdd;
        return checkIfPrime(numberToCheck);
    }

    private boolean checkIfDigitToAdd(StringBuilder sb, char toAdd) {
        return checkIfDigitToAdd(sb, toAdd - '0');
    }

    private List<Integer> getSubList(List<Integer> list, int index) {
        List<Integer> localList = new ArrayList<Integer>();
        localList.addAll(list);
        localList.remove(index);
        return localList;
    }

    private boolean checkIfPrime(int n) {

        if (n < isPrime.length && isPrime[n - 1] != null) {
            return isPrime[n - 1];
        } else {
            for (int number = 2; number <= (int) Math.sqrt(n); number++) {
                if (n % number == 0) {
                    isPrime[n - 1] = false;
                    return false;
                }
            }
            return true;
        }
    }

    // if is same combination returns true else false
    private boolean isSameCombination(String oldNecklace, String newNecklace) {
        StringBuilder sb = new StringBuilder(oldNecklace);
        sb.append(oldNecklace);
        return (sb.indexOf(newNecklace) != -1);
    }
}
