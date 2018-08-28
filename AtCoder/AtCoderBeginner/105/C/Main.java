import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        long A = scanner.nextLong();

        List<List<Long>> list = new ArrayList<>();
        long min = 0;
        long max = 0;
        for (int i = 0; i < 40; i++) {
            long v = (long)Math.pow(-2, i);
            if (v > 0) {
                max += v;
            } else {
                min += v;
            }
            List<Long> l = new ArrayList<>();
            l.add(min);
            l.add(max);
            list.add(l);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0) {
                if (A == 0) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                List<Long> current = list.get(i);
                List<Long> prev = list.get(i-1);
                if (current.get(0) <= A
                    && current.get(1) >= A
                    && !(prev.get(0) <= A &&
                         prev.get(1) >= A)) {
                    sb.append("1");
                    A -= (long)Math.pow(-2, i);
                } else {
                    if (sb.length() != 0) {
                        sb.append("0");
                    }
                }
            }
        }
        System.out.println(sb);
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
