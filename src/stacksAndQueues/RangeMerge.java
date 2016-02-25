package stacksAndQueues;

import java.util.*;

public class RangeMerge {

    //private List<Time> timeList = Arrays.asList(new Time(1, 9), new Time(2, 4), new Time(6, 8), new Time(4, 7));
    private List<Time> timeList = Arrays.asList(new Time(1, 3), new Time(2, 4), new Time(6, 8), new Time(4, 7));
    //private List<Time> timeList = Arrays.asList(new Time(1, 3), new Time(7, 9), new Time(4, 6), new Time(10, 13));
    private TimeComparator myComparator = new TimeComparator();

    public static void main(String[] args) {
        RangeMerge obj = new RangeMerge();
        obj.printList(obj.merge());
    }

    private Stack<Time> merge() {
        Collections.sort(timeList, myComparator);
        printList(timeList);
        Stack<Time> stack = new Stack<Time>();
        for (Time t : timeList) {
            if (isMergePossible(stack, t)) {
                int topEnd = stack.peek().end;
                stack.peek().end = Math.max(t.end, topEnd);
            } else {
                stack.push(t);
            }
        }
        return stack;
    }

    private boolean isMergePossible(Stack<Time> stack, Time t) {
        if (stack.isEmpty())
            return false;
        else {
            Time top = stack.peek();
            return (top.start <= t.start && t.start <= top.end);
        }
    }

    private void printList(List<Time> time) {
        for (Time t : time) {
            System.out.print(t.start + " " + t.end + ", ");
        }
        System.out.println();
    }

    private class Time {
        private int start;
        private int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    private class TimeComparator implements Comparator<Time> {

        @Override
        public int compare(Time first, Time second) {
            return first.start - second.start;
        }
    }
}
