package strings;

public class ParenthesisCombination {

    public static void main(String[] args) {
        new ParenthesisCombination().printParenthesis(2, 2, "");
    }

    public void printParenthesis(int left, int right, String str){
        if (right == 0){
            System.out.println(str);
            return;
        }
        if (left > 0){
            printParenthesis(left - 1, right, str + "(");
            if (left < right)
                printParenthesis(left, right - 1, str + ")");
        } else {
            printParenthesis(left, right - 1, str + ")");
        }
    }
}
