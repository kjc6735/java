
import java.util.*;
import java.io.File;
import java.io.FileInputStream;


class Solve {
    class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    Scanner sc;
    int max = 0;
    Solve(Scanner sc) {
        this.sc = sc;
    }
    
    Character map[][] = new Character[20][20];
    Boolean visited[][] = new Boolean[20][20];

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
                this.map[i][k] = null;
                this.visited[i][k] = false;
            }
        }
        this.max = 0;
    }

    int solve() {
        a = sc.nextInt();
        b = sc.nextInt();
        //
        System.out.println(Arrays.deepToString(visited));

        Map<Character, Boolean> exist = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < a; i++) {
            String t = sc.next();
            for (int k = 0; k < t.length(); k++) {
                map[i][k] = t.charAt(k);
            }
        }

        visited[0][0] = true;
        exist.put(map[0][0], true);
        queue(new Pos(0, 0));
        while (!queue.isEmpty()) {
            Pos curr = queue.poll();

            //주변탐색
            for (int i = 0; i < 4; i++) {
                int xx = curr.x + forward[i][0];
                int yy = curr.y + forward[i][1];
                if (!visited[xx][yy] && xx >= 0 && yy >= 0 && xx < a && yy < b) {
                    queue.offer(new Pos(xx, yy));
                }
            }
        }
        return max;
    }

}

public class Solution2 {
    public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
        T = sc.nextInt();
        Solve solve = new Solve(sc);

		for(int test_case = 1; test_case <= T; test_case++)
        {
            solve.init();
            solve.solve();
            // System.out.println("#"+test_case +" "+ solve.solve());
		}
	}
}
