package practiceProblems;


import java.util.ArrayList;
import java.util.List;

public class Employee {

    public void main(String[] args) {
        System.out.println(-13 % 64);

        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("234");
        list.add("345");
        list.add("456");

        int i = 0;
        for (String str : list) {
            list.set(i, str + " " + i++);
        }

        for (String str : list) {
            System.out.println(str);
        }
    }
}