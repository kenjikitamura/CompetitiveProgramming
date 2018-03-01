import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    int[] w = { 2, 1, 3, 2};
    int[] v = { 3, 2, 4, 2};
    int W = 7;
    int[][] dp = new int[100][100];
    
    public void solve(String[] args) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println("ans="+res(0, W));
    }

    public int res(int i, int W) {
        if (i >= w.length) return 0;
        if (W < w[i])      return 0;
        int ret = max(res(i+1, W - w[i]) + w[i], res(i+1, W));
        dp[i][
        return ret;
    }

    /*
    // ナップサック問題(メモ化再帰)
    // 蟻本53ページ
    int[] w = { 2, 1, 3, 2};
    int[] v = { 3, 2, 4, 2};
    int W = 7;
    public void solve(String[] args) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("ans="+res(0, W));
    }
    int[][] dp = new int[100][100];
    public int res(int i, int W) {
        if (dp[i][W] != -1) {
            return dp[i][W];
        }
        if (i >= w.length) {
            return 0;
        }
        if (w[i] > W) {
            return 0;
        }
        int ret = max(res(i+1, W - w[i]) + w[i], res(i+1, W));
        dp[i][W] = ret;
        return ret;
    }
    */


    /*
    // Longest Common Subsequence
    // 蟻本56ページ
    public void solve(String[] args) {
        String s = "abcd";
        String t = "becd";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = max(dp[i + 1][j],dp[i][j + 1]) ;
                }
            }
        }
        System.out.println(dp[4][4]);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }
    }
    */

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

        public String next() throws IOException {
            if (i < s.length) return s[i++];
            String line = br.readLine();
            while (line.equals("")) {
                line = br.readLine();
            }
            s = line.split(reg, 0);
            i = 0;
            return s[i++];
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
