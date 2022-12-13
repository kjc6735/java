package kakao2022;

import java.util.ArrayList;

import java.util.List;

public class FailureRate {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
        int[] ans = new int[N];
        int[] count = new int[N];
        List<double[]> rate = new ArrayList<>();
        for (int a : stages) if(N >= a) count[a-1]++;
        
        int len = stages.length;
        for (int i = 0; i < N; i++) {
            Double r = (double) count[i] / len;
            rate.add(new double[] { i, r });
            len -= count[i];
        }

        rate.sort((a, b) -> Double.compare(b[1], a[1]));

        for (int i = 0; i < rate.size(); i++) {
            ans[i] = (int) rate.get(i)[0] +1;
        }
        // for(int k : ans) System.out.println(k);
        
    }
}


/*
 * 
 * import java.util.ArrayList;

import java.util.List;
class Solution {
    public int[] solution(int N, int[] stages) {
         int[] ans = new int[N];
        int[] count = new int[N];
        List<double[]> rate = new ArrayList<>();
        for (int a : stages) if(N >= a) count[a-1]++;
        
        int len = stages.length;
        for (int i = 0; i < N; i++) {
            if(len == 0){
                rate.add(new double[] { i, 0 });
                continue;
            }
            Double r = (double) count[i] / len;
            rate.add(new double[] { i, r });
            len -= count[i];
        }

        rate.sort((a, b) -> Double.compare(b[1], a[1]));

        for (int i = 0; i < rate.size(); i++) {
            ans[i] = (int) rate.get(i)[0] +1;
        }
        return ans;
    }
}

 */