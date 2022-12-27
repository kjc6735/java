package StackQueue;

import java.util.Arrays;

public class Q1 {
   

    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };
        int[] count = new int[100];
        int k = 1;
        for (int i = 0; i < progresses.length; i++) {
            for (; progresses[i] + speeds[i]*k < 100; k++) {}
            count[k - 1]++; 
        }
        int[] ans = Arrays.stream(count).filter(i -> i != 0).toArray();
        System.out.println(Arrays.toString(ans));
        // int[] dayOfend = new int[100];
        // int day = -1;
        // for(int i=0; i<progresses.length; i++) {
        //     while (progresses[i] + (day * speeds[i]) < 100) {
        //         day++;
        //     }
        //     System.out.println(day);
        //     dayOfend[day]++;
        // }
       
        //  int[] ans =  Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
        // System.out.println(Arrays.toString(ans));
    }
}
