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
        String S = scanner.next();
        int[] E = new int[N];
        int[] W = new int[N];
        int e = 0;
        int w = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'E') {
                e++;
            } else {
                w++;
            }
            E[i] = e;
            W[i] = w;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int change = 0;
            if (i != 0) {
                change += W[i-1];
            }
            change += E[N-1] - E[i];
            ans = Math.min(ans, change);
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
