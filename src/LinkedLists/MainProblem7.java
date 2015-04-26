package LinkedLists;

public class MainProblem7 {

    public static void main(String[] args) {
        Problem7 runner = new Problem7();
        runner.createList("abcd");
        System.out.println(runner.isPalindrome());

        runner = new Problem7();
        runner.createList("xcvjhxcvbjhxcbvjhxchxcv");
        System.out.println(runner.isPalindrome());

        runner = new Problem7();
        runner.createList("1234321");
        System.out.println(runner.isPalindrome());

        runner = new Problem7();
        runner.createList("12344321");
        System.out.println(runner.isPalindrome());
    }

}
