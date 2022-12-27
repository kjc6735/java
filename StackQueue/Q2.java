package StackQueue;

import java.util.*;

public class Q2{
   

    public static void main(String[] args) {
        String s = "()()";
        Stack<Boolean> a = new Stack<>();

        Boolean ans = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                a.push(true);
            } else {

                if (a.size() == 0) {
                    ans = false;
                    break;
                }
                a.pop();
            }
        }
        if (a.size() != 0)
            ans = false;
        System.out.print(ans);
    }
}
