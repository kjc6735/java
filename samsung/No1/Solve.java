import java.util.*;
import java.io.*;


class Solve {
    BufferedReader sc;
    int max = 0;
    Solve(BufferedReader sc) {
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

    void init() {
        for (int i = 0; i < 20; i++) {
            for (int k = 0; k < 20; k++) {
               this. map[i][k] = null;
            }
        }
        this.max = 0;
    }

    int solve() throws Exception {
        String[] args = sc.readLine().split(" ");
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        
        boolean v[][] = new boolean[a][b];
        Map<Character, Boolean> al = new HashMap<>();
        //Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < a; i++) {
            String t = sc.readLine();
            // System.out.println(t);
            for (int k = 0; k < t.length(); k++) {
                map[i][k] = t.charAt(k);
            }
        }
        dfs(0, 0, v, al);

        return max;
    }

    void dfs(int x, int y, boolean visited[][], Map<Character, Boolean> alphabet) {
       // queue.add(map[x][y]);
        visited[x][y] = true;
        alphabet.put(map[x][y], true);
        max = max > alphabet.size() ? max : alphabet.size();
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

                // Queue<Character> nq = new LinkedList<>(queue);

                // while (!nq.isEmpty()) {
                //     System.out.print(nq.poll() + " -> ");
                // }
                continue;
            }
            // boolean newVisited[][] = new boolean[a][b];
            // for (int z = 0 ; z < visited.length; z++) {
            //     for (int k = 0; k < visited[z].length;  k++) {
            //         newVisited[z][k] = visited[z][k];
            //     }
            // }

            // //Queue<Character> newQueue = new LinkedList<>(queue);
            // Map<Character, Boolean> newMap = new HashMap<Character, Boolean>(alphabet);
            dfs(xx, yy, visited, alphabet);


        }
        visited[x][y] = false;
        alphabet.remove(map[x][y]);
    }
}


public class Solution
{
   public static void main(String args[]) throws Exception
   {
      // System.setIn(new FileInputStream("input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
      int T = Integer.parseInt(bf.readLine());
        Solve solve = new Solve(bf);

      for(int test_case = 1; test_case <= T; test_case++)
        {
            solve.init();   
            System.out.println("#"+test_case +" "+ solve.solve());
      }
   }
}