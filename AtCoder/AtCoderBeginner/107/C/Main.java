import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        long[] x = new long[N];
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextLong();
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i <= N - K; i++) {
            int l = i;
            int r = i + K -1;
            min = Math.min(min,
                           Math.min(Math.abs(x[l]) + Math.abs(x[r] - x[l]),
                                    Math.abs(x[r]) + Math.abs(x[l] - x[r])
                                    ));
        }
        System.out.println(min);
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
