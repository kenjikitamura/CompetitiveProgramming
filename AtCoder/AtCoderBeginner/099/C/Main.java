import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    List<Integer> list = new ArrayList<>();
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int A = scanner.nextInt();
        int ans = 0;
        list.add(0);
        list.add(1);
        int a = 0;
        {
            int i = 1;
            do {
                a = (int)Math.pow(6, i++);
                if (a>100000) break;
                list.add(a);
            } while (a<100000);
            i = 1;
            do {
                a = (int)Math.pow(9, i++);
                if (a>100000) break;
                list.add(a);
            } while (a<100000);
            Collections.sort(list);
        }
        int dp[] = new int[100001];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j + list.get(i) <= A; j++) {
                dp[j + list.get(i)] = Math.min(dp[j + list.get(i)], dp[j] + 1);
            }
        }
        System.out.println(dp[A]);
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
