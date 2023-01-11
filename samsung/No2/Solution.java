package com.spring.data;

import java.util.*;
import java.io.*;

class Solution
{
   public static void main(String args[]) throws Exception
   {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
         int T = Integer.parseInt(br.readLine());

        Solve solve = new Solve();

        for(int test_case = 1; test_case <= T; test_case++)
      {
         String[] s = br.readLine().split(" ");

            int x = Integer.parseInt(s[1]), y = Integer.parseInt(s[2]);

            //결과 받아옴
            String result = solve.solve(s[0], x, y);

            //문자열 앞의 0 제거
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length(); i++) {
                if (sb.length() > 0 || result.charAt(i) != '0') sb.append(result.charAt(i));
            }

            //비어있으면 -1
            if (sb.length() == 0) sb.append("-1");

            System.out.println("#"+test_case +" "+ sb.toString());
      }
   }
}

class Solve
{
    //String의 repeat 메서드가 java8 에 없어서 만듦...
    public void repeat(StringBuilder sb, Object o, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(o);
        }
    }

    public String solve(String N, int x, int y)
    {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N.length(); i++)
        {
            int n = N.charAt(i) - '0';

            //다섯가지 경우를 따져봄
            //1) n > y
            //2) n == y
            //3) x > n > y
            //4) n == x
            //5) n < x

            if (n == y) sb.append(y);
            else if (n == x) sb.append(x);
            else if (n > y) {
                //n이 y보다 크면 남은 자릿수는 y로 채움
                repeat(sb, y, N.length() - i);

                break;
            }
            else if (n > x) {
                //n이 x보다 크면 x를 넣고 남은 자릿수는 y로 채움
                sb.append(x);
                repeat(sb, y, N.length() - i - 1);

                break;
            }
            else {
                //이게 제일 까다로운 경우인데... n < x인 경우

                while (sb.length() > 0) {
                    //끝자리부터 제거해감. 처음으로 y가 나올때까지 제거
                    boolean b = sb.charAt(sb.length() - 1) - '0' == y;

                    sb.deleteCharAt(sb.length() - 1);

                    if (b) break;
                }

                if (sb.length() == 0) {
                    //만약 sb가 비어있다면(y를 제거할 수 없었다면) 자릿수보다 1개 적은 자릿수를 y로 채움
                    repeat(sb, y, N.length() - sb.length() - 1);
                } else {
                    //y를 제거하는데 성공했다면, x를 넣고 남은 자릿수를 y로 채움
                    sb.append(x);
                    repeat(sb, y, N.length() - sb.length());
                }

                break;
            }
        }

        return sb.toString();
    }

}