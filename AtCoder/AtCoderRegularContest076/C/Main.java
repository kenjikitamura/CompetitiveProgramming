import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    private long MOD = 1000000007;

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        long N = (long)scanner.nextInt();
        long M = (long)scanner.nextInt();

        if (abs(N - M) > 1) {
            System.out.println(0);
            return;
        }
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans = ans * i;
            ans = ans % MOD;
        }
        for (int i = 1; i <= M; i++) {
            ans = ans * i;
            ans = ans % MOD;
        }
        if (N == M) ans = ans * 2;
        ans = ans % MOD;
        System.out.println(ans);
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
