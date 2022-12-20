package kakao2022;

import java.util.*;

class Q4 {
    static int[] fees = {
        180,	5000,	10,	600
    };
    static String[] records = {
        "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
    };

    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
       for(String item : records){
           String[] data = item.split(" ");
           if (data[2] == "IN") {
            String[] time = data[0].split(":");
            m.put(data[1], Integer.valueOf(time[0])* 60 + Integer.valueOf(time[1]));
           } else {
               m.put(data[1], m.get(data[1]) +  )
            }
       }
    }
}