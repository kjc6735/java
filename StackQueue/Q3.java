package StackQueue;
import java.util.*;

public class Q3 {
    
    static class Print {
        int index;
        int priority;
        Print(int index, int priority) {
                    this.index = index;
                    this.priority = priority;
                }
    }

    public static void main(String[] args) {
        int[] priorities = { 2, 1, 3, 2 };
        int location = 2;

        // int[] priorities = {1, 1, 9, 1, 1, 1	 };
        // int location = 0;


        int count = 0;
        Queue<Print> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Print(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            Boolean flag = false;

            Print current = q.peek();
            for (Print p : q) {
                if (p.priority > current.priority) {
                    flag = true;
                    break;
                }
            }

            Print tmp = q.poll();
            if (flag)
                q.add(tmp);
            else {
                count++;
                if (tmp.index == location) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
