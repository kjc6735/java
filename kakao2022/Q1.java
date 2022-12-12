package kakao2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q1 {
    public static void main(String[] args) {
        // Integer[] q1 = { 3, 2, 7, 2 };
        // Integer[] q2 = { 4, 6, 5, 1 };
        Integer[] q1 = { 1, 2, 1, 2 };
        Integer[] q2 = { 1, 10, 1, 2 };

        Queue<Integer> queue1 = new LinkedList<Integer>(Arrays.asList(q1));
        Queue<Integer> queue2 = new LinkedList<Integer>(Arrays.asList(q2));
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < q1.length; i++)
            sum1 += q1[i]; 
        for (int i = 0; i < q2.length; i++)
            sum2 += q2[i];

       
        int i;
        for ( i = 0; sum1 != sum2 && i <= (q1.length + q2.length)*2; i++) {
            if (sum1 < sum2) {
                int value = queue2.poll();
                sum1 += value;
                sum2 -= value;
                queue2.offer(value);
            } else {
                int value = queue1.poll();
                sum1 -= value;
                sum2 += value;
                queue1.offer(value);
            }
        }
        System.out.println(i);
    }
}
