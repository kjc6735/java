package kakao2022;

import java.net.ContentHandler;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
    public static void main(String[] args) {
        Character[] c = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };
        
        Map<Character, Integer> m = new HashMap<>();
        Map<Integer, Integer> score = new HashMap<>();
        score.put(1, 3);
        score.put(2, 2);
        score.put(3, 1);
        score.put(4, 0);
        score.put(5, 1);
        score.put(6, 2);
        score.put(7, 3);
        for (Character t : c) {
            m.put(t, 0);
        }
        String[] str = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices = { 5, 3, 2, 7, 5 };
        
        int len = str.length;
        for (int i = 0; i < len; i++) {
            Character first = str[i].charAt(0);
            Character second = str[i].charAt(1);
            if (!m.containsKey(first))
                m.put(first, 0);
            if (!m.containsKey(second))
                m.put(second, 0);
            if (choices[i] == 4)
                continue;
            Integer add = score.get(choices[i]);
            if (choices[i] < 4) {
                m.put(first, m.get(first) + add);
            } else {
                m.put(second, m.get(second) + add);
            }
        }
        String result = "";
        result = m.get('R') >= m.get('T') ? result.concat("R") : result.concat("T");
        result = m.get('C') >= m.get('F') ? result.concat("C") : result.concat("F");
        result = m.get('J') >= m.get('M') ? result.concat("J") : result.concat("M");
        result = m.get('A') >= m.get('N') ? result.concat("A") : result.concat("N");
        System.out.println(result);
    }
}
