import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        long N = scanner.nextLong();
        long C = scanner.nextLong();
        long[] x = new long[N];
        long[] v = new long[N];
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextLong();
            v[i] = scanner.nextLong();
        }
        if (N > 100) break;
        for (int i = -1; i < N; i++) {
            int A = 0;
            if (i != -1) {
                A = x[i];
            }
            for (int l = -1; l < N; l++) {
                int B = 0;
                if (l != -1) {
                    B = x[l];
                }
                for (int i = 0; i < N; i++) {
                }
            }
        }
    }

    private class MyScanner {
        String[] s;int i;BufferedReader br;String reg = " ";
        MyScanner () {
            s = new String[0];i = 0;br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next() {
            try {
                if (i < s.length) return s[i++];
                String line = br.readLine();
                while (line.equals("")) {line = br.readLine();}
                s = line.split(reg, 0);
                i = 0;return s[i++];
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
