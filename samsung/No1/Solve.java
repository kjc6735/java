package No1;

import java.util.*;

public class Solve {
    Scanner sc;
    int max = 0;
    Solve(Scanner sc) {
        this.sc = sc;
    }

    Character map[][] = new Character[20][20];
    int forward[][] = {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 },
    };
    int a, b;

    int solve() {
        a = sc.nextInt();
        b = sc.nextInt();

        boolean v[][] = new boolean[a][b];
        Map<Character, Boolean> al = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        
        for (int i = 0; i < a; i++) {
            String t = sc.next();
            // System.out.println(t);
            for (int k = 0; k < t.length(); k++) {
                map[i][k] = t.charAt(k);
            }
        }
        dfs(0, 0, v, al, q);

        return max;
    }

    void dfs(int x, int y, boolean visited[][], Map<Character, Boolean> alphabet, Queue<Character> queue) {
        queue.add(map[x][y]);
        visited[x][y] = true;
        alphabet.put(map[x][y], true);
        for (int i = 0; i < forward.length; i++) {
            int xx = forward[i][0] + x;
            int yy = forward[i][1] + y;
            
            if (!(xx >= 0 && yy >= 0 && xx < a && yy < b)) {
                // System.out.println("out of range : " + xx + " " + yy);
                continue;
            }
            if (visited[xx][yy]) {
                // for (boolean v[] : visited) {
                //     for (boolean v2 : v) {
                //         System.out.print(v2 == true ? 1 : 0);
                //     }
                //     System.out.println();
                // }
                // System.out.println(alphabet.toString() +  "contain key [" + map[xx][yy] + "]");
                // System.out.println("visited : " + xx + " " + yy + " " + map[xx][yy]);
                continue;
            }
       
            if (alphabet.containsKey(map[xx][yy])) {
                max = max > alphabet.size() ? max : alphabet.size();

                // Queue<Character> nq = new LinkedList<>(queue);

                // while (!nq.isEmpty()) {
                //     System.out.print(nq.poll() + " -> ");
                // }
                continue;
            }
            boolean newVisited[][] = new boolean[a][b];
            for (int z = 0 ; z < visited.length; z++) {
                for (int k = 0; k < visited[z].length;  k++) {
                    newVisited[z][k] = visited[z][k];
                }
            }
            Queue<Character> newQueue = new LinkedList<>(queue);
            Map<Character, Boolean> newMap = new HashMap<Character, Boolean>(alphabet);
            dfs(xx, yy, newVisited, newMap, newQueue);
        }
    }
}
