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
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) continue;
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if ((i % j) == 0) {
                    count++;
                }
            }
            if (count == 8) {
                ans++;
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
