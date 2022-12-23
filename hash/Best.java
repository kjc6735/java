package hash;

import java.util.*;

import javax.print.event.PrintEvent;

class Best {

    static class Member implements Comparable<Member>{
        public Integer idx;
        public Integer playCount;

        Member(Integer idx, Integer playCount) {
            this.idx = idx;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Member target) {
            if (this.playCount < target.playCount)
                return 1;
            if (this.playCount > target.playCount)
                return -1;
            if (this.idx > target.idx)
                return 1;
            return 0;
        }
    }

    static String[] genres = { "classic", "pop", "classic", "classic", "pop" };
    static int[] plays = { 500, 600, 150, 800, 2500 };

    public static void main(String[] args) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, PriorityQueue<Member>> member = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (count.get(genres[i]) == null) {
                count.put(genres[i], plays[i]);

                PriorityQueue<Member> pq = new PriorityQueue<>();
                pq.offer(new Member(i, plays[i]));
                member.put(genres[i], pq);
            } else {
                count.put(genres[i], count.get(genres[i]) + plays[i]);
                member.get(genres[i]).offer(new Member(i, plays[i]));
            }
        }

        //맵 정렬
        List<Map.Entry<String, Integer>> entriesList = new LinkedList<>(count.entrySet());
        entriesList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : entriesList){
            Queue<Member> queue = member.get(entry.getKey());
            result.add(queue.poll().idx);
            if (!queue.isEmpty())
                result.add(queue.poll().idx);
        }
        int[] ans = result.stream().mapToInt(i -> i).toArray();
    }

}