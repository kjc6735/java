package StackQueue;
import java.util.*;


class Q6 {
  public static void main(String[] args) {
    int[] prices = { 1, 2, 3, 2, 3 };
    int[] ans = new int[prices.length];
    Map<Integer, Queue<Integer>> m = new HashMap<>();
    for (int i = 0; i < prices.length; i++) {
      if (m.containsKey(prices[i])) {
        m.get(prices[i]).offer(i);
      } else {
        Queue<Integer> tmp = new LinkedList<>();
        tmp.add(i);
        m.put(prices[i], tmp);
      }
      for(int k = prices[i]+1; k <= 10000; k++){
        if(m.containsKey(k)){
          Queue<Integer> tmp = m.get(k);
          while (!tmp.isEmpty()) {
                  int idx = tmp.poll();
                  ans[idx] = i - idx;
                }
        }
      }
      // for (Map.Entry<Integer, Queue<Integer>> entry : m.entrySet()) {
      //   if (prices[i] < entry.getKey()) {
      //     Queue<Integer> tmp = entry.getValue();
      //     while (!tmp.isEmpty()) {
      //       int idx = tmp.poll();

      //       ans[idx] = i - idx;

      //     }
      //   }
      // }

    }
    for (Map.Entry<Integer, Queue<Integer>> entry : m.entrySet()) {
      for (int a : entry.getValue()) {
        ans[a] = prices.length - (a+1);
      }
    }
    System.out.println(Arrays.toString(ans));
    
    // for (Map.Entry<Integer, Queue<Integer>> entry : m.entrySet()) {
    //   System.out.print(entry.getKey() + "  =  [");
    //   for (int a : entry.getValue()) {
    //     System.out.print(a + " ");

    //   }
    //   System.out.print(" ]");
    //   System.out.println();
      
    // }
  }
}