
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    int R,M,N;
    int[] r;
    int res = Integer.MAX_VALUE;
    boolean[] used = new boolean[9];
    int[][] dp;

    public void dfs(int c, int las, int dist) {
        if (c == R+1) {
            if (res > dist) {
                res = dist;
            }
            return;
        }
        for (int i = 1; i <= R; i++) {
            if (!used[i]) {
                used[i] = true;
                if (las == -1) dfs(c+1, i,0);
                else dfs(c+1, i, dist+dp[r[las]][r[i]]);
                used[i] = false;
            }
        }
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        N = scanner.nextInt();
        M = scanner.nextInt();
        R = scanner.nextInt();
        r = new int[9];

        for (int i = 1; i <= R; i++) {
            r[i] = scanner.nextInt();
        }

        dp = new int[201][201];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j != i) dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (dp[a][b] > c) {
                dp[a][b] = c;
                dp[b][a] = c;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        dfs(1, -1, 0);
        System.out.println(res);
    }

    private class MyScanner {
        String[] s;
        int i;
        BufferedReader br;
        String reg = " ";

        MyScanner () {
            s = new String[0];
            i = 0;
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                if (i < s.length) return s[i++];
                String line = br.readLine();
                while (line.equals("")) {
                    line = br.readLine();
                }
                s = line.split(reg, 0);
                i = 0;
                return s[i++];
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public int nextInt() {
            try {
                return Integer.parseInt(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

        public double nextDouble() {
            try {
                return Double.parseDouble(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

        public long nextLong()  {
            try {
                return Long.parseLong(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }
    }
}
