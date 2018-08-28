import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    long mod = 1000000007;
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        long[] A = new long[N];
        long[] SUM = new long[N+1];
        SUM[0] = 0;
        for (int i = 0; i < N; i++) {
            long a = scanner.nextLong();
            A[i] = a;
            SUM[i+1] = SUM[i] + a;
        }
        for (int i = 1; i < N-2; i++) {
            long a = SUM[i+1];
            long b = SUM[N] - SUM[i+1];
            System.out.println("SUM i="+i+ " a="+ a + " b=" +b);
        }

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
