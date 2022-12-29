package sort;
import java.util.*;

class Q2{
    public static void main(String[] args) {
        int[] numbers = { 3, 30, 34, 32, 5, 9 };
        String ans = "";
        String[] str =  new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        if (str[0].equals("0"))
            ans = "0";
        else {
            for (String s : str)
                ans += s;
        }
        System.out.print(ans);
        
  }
}