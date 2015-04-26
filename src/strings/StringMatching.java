package strings;

public class StringMatching {

    private String text;
    private String pattern;
    private int[][] dfaTable;
    private static final int totalUniqueCharactersInText = 26;

    public static void main(String[] args) {
        StringMatching strMatching = new StringMatching("AbccbcbababaDcababaD", "ABABAD");
        System.out.println(strMatching.kmpAlgo());
    }

    public StringMatching(String text, String pattern) {
        this.text = text.toLowerCase();
        this.pattern = pattern.toLowerCase();
        dfaTable = new int[totalUniqueCharactersInText][pattern.length()];
    }

    private int kmpAlgo() {
        createDfaTable();
        return processText();
    }

    private int processText() {
        int stateReached = 0;
        int indexStartedFrom = 0;
        for (int i = 0; i < text.length(); i++) {
            stateReached = dfaTable[text.charAt(i) - 97][stateReached];
            if (stateReached == pattern.length()) {
                return indexStartedFrom + 1;
            } else if (stateReached == 0) {
                indexStartedFrom = i;
            }
        }
        return -1;
    }

    private void createDfaTable() {
        int patternLength = pattern.length();
        int prevState = 0;

        // for filling the match transition
        for (int i = 0; i < patternLength; i++) {
            dfaTable[pattern.charAt(i) - 97][i] = i + 1;
        }

        // for filling the mis-match transition
        for (int i = 1; i < patternLength; i++) {
            //System.arraycopy(dfaTable[prevState], 0, dfaTable[i], 0, 25);
            for (int row = 0; row < totalUniqueCharactersInText; row++) {
                dfaTable[row][i] = (row != pattern.charAt(i) - 97) ? dfaTable[row][prevState] : dfaTable[row][i];
            }
            prevState = dfaTable[pattern.charAt(i) - 97][prevState];
        }
    }

}
