package StackQueue;
import java.util.*;

class Q5{
  public static void main(String[] args){
    //   int bridge_length = 2;
    //   int weight = 10;
    //   int[] truck_weights = { 7, 4, 5, 6 };

    // int bridge_length = 100;
    // int weight = 100;
    // int[] truck_weights = { 10 };

    int bridge_length = 100;
    int weight = 100;
    int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };




      int time = 0;

      Queue<Integer> waiting = new LinkedList<>();
      for(int a : truck_weights) waiting.offer(a);
        Queue<Map<String, Integer>> ing = new LinkedList<>();
        int totalWeight = 0;
        while (!waiting.isEmpty()) {
            time++;
            if (!ing.isEmpty() && ing.peek().get("end") == time) {
                // System.out.println("끝남..: "+ing.poll().get("end"));

                totalWeight -= ing.poll().get("weight");
            }
            Integer truck_wait = waiting.peek();
            if (totalWeight + truck_wait <= weight && ing.size() + 1 <= bridge_length) {
                Map<String, Integer> item = new HashMap<>();
                item.put("end", time + bridge_length);
                item.put("weight", waiting.poll());
                ing.add(item);
                totalWeight += truck_wait;

            }
        }
        while (ing.size() >  1)
            ing.poll();
        System.out.println(ing.peek().get("end"));


  }
}