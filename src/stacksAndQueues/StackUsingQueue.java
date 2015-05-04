package stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        new StackUsingQueue().recurseToMakeStack(q);
    }

    private void recurseToMakeStack(Queue<Integer> q){

        if (q.size() == 1){
            return;
        } else {
            int top = q.poll();
            recurseToMakeStack(q);
            q.add(top);
        }
    }
}
