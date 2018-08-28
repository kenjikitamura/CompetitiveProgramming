import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    int D;
    int G;
    int[] p;
    int[] c;
    int minCount = Integer.MAX_VALUE;
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        D = scanner.nextInt();
        G = scanner.nextInt();
        p = new int[D];
        c = new int[D];
        for (int i = 0; i < D; i++) {
            p[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }

        int ans = 10000000;
        for (int i = 0; i < (1 << D); i++) {
            int count = 0;
            long score = 0;
            for (int j = 0; j < D; j++) {
                if (((i >> j) & 1) == 1) {
                    score += c[j];
                    score += p[j] * (j+1) * 100;
                    count += p[j];
                }
            }
            if (score < G) {
                for (int j = D -1; j >= 0; j--) {
                    if (((i >> j) & 1) == 0) {
                        for (int k = 1; k < p[j]; k++) {
                            score += (j+1) * 100;
                            count++;
                            if (score >= G) {
                                ans = Math.min(ans, count);
                            }
                        }
                    }
                }
            } else {
                ans = Math.min(ans, count);
            }
        }
        System.out.println(ans);
    }

    private class MyScanner {
        String[] s;int i;BufferedReader br;String reg = " ";
        MyScanner () { s = new String[0];i = 0;br = new BufferedReader(new InputStreamReader(System.in)); }
        public String next() {
            try {
                if (i < s.length) return s[i++]; String line = br.readLine();
                while (line.equals("")) {line = br.readLine();}
                s = line.split(reg, 0); i = 0;return s[i++];
            } catch (Exception e) {e.printStackTrace();}
            return null;
        }
        public int nextInt() {
            try {return Integer.parseInt(next());} catch (Exception e) {e.printStackTrace();}
            return -1;
        }
        public double nextDouble() {
            try {return Double.parseDouble(next());} catch (Exception e) {e.printStackTrace();}
            return -1;
        }
        public long nextLong()  {
            try {return Long.parseLong(next());} catch (Exception e) {e.printStackTrace();}
            return -1;
        }
    }
}

