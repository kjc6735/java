package sort;
import java.util.*;

class Q1{
  public static void main(String[] args){
      int[] array = { 1, 5, 2, 6, 3, 7, 4 };
      int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
      int[] ans = new int[commands.length];
      for (int i = 0; i < commands.length; i++) {
          //   for (int k = 0; k < commands[i].length; k++) {
          //     int[] tmp = new 
          // }
          int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
          Arrays.sort(tmp);
          //   System.out.println(Arrays.toString(tmp)+ " " + (commands[i][2] -1));

          ans[i] = tmp[commands[i][2] - 1];
      }
      System.out.print(Arrays.toString(ans));
  }
}