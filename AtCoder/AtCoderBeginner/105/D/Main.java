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
        int M = scanner.nextInt();
        int[] A = new int[N];
        int[] m = new int[N+1];
        m[0] = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt() % M;
            m[i+1] = (m[i] + A[i]) % M;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[N+1];
        long sum = 0;
        for (int i = 0; i < N + 1; i++) {
            Integer i2 = map.get(m[i] % M);
            if (i2 == null) {
                i2 = 0;
                map.put(m[i], i2);
            }
            sum += i2;
            map.put(m[i], i2 + 1);
        }

        System.out.println(sum);
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
