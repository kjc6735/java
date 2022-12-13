package kakao2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CrawMachine {
    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
        int len = board[0].length;
        Queue<Integer>[] arr = new Queue[10];

        for (int i = 0; i < len; i++){
            arr[i] = new LinkedList<>();
        }
        Stack<Integer> bucket = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            for (int k = 0; k < len; k++) {
                if (board[i][k] != 0) {
                    arr[k].offer(board[i][k]);
               }
            }
        }
        int count = 0;
        for (int move : moves) {
            if (arr[move - 1].isEmpty())
                continue;

            Integer getItem = arr[move - 1].poll();
            
            if (bucket.isEmpty() || getItem != bucket.peek()) {
                bucket.push(getItem);
                continue;
            }
            count++;
            while (getItem == bucket.peek()) {
                System.out.println( "test : " + getItem);
                count++;
                bucket.pop();
            }
        }
        System.out.println(count);
        // while (!bucket.isEmpty()) {
        //     System.out.println(bucket.peek());
        //     bucket.pop();
        // }
    }
}
