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
        long[] list = new long[N];
        for (int i = 0; i < N; i++) {
            list[i] = scanner.nextLong() - i;
        }

        Arrays.sort(list);
        long mid = list[list.length/2];

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.abs(list[i] - (mid));
        }

        System.out.println(ans);
    }

    private long search(long v, long[] list) {
        long ans = 0;
        for (int i = 0; i < list.length; i++) {
            ans += Math.abs(v - list[i]);
            v++;
        }
        return ans;
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
