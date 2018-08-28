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
        long[] A = new long[N];
        long[] SUM;
        for (int i = 0; i < N; i++) {
            long a = scanner.nextLong();
            A[i] = a;
        }
        SUM = accumulate(A);
        int a = 0;
        int c = 2;
        for (int b = 1; b < N-2; b++) {

            long sum1 = SUM[a];
            long sum2 = SUM[b] - SUM[a];
            long sum3 = SUM[c] - SUM[b];
            long sum4 = SUM[N-1] - SUM[c];
            System.out.println("SUM b="+b+ " sum1="+sum1+" sum2=" + sum2 + " sum3=" + sum3 + " sum4="+ sum4);
        }
    }

    private long[] accumulate(long[] array) {
        long[] ret = new long[array.length];
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            ret[i] = sum;
        }
        return ret;
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
