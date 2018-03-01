import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    int[] dp = new int[16000];
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        String s = scanner.next();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int x = 8000;
        boolean forward = true;
        boolean isX = true;
        int step = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'T') {
                step(step);
                isX = !isX;
            } else {
                step++;
            }
        }
        System.out.println(ret);
    }

    private void step(int step) {
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                dp[i - step] = 1;
                dp[i + step] = 1;
                dp[i] = 0;
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
