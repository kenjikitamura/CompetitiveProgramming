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
        int[] A = new int[N];
        int one = 0;
        int ret = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            if (A[i] == 1) {
                one = i;
            }
        }

        if (one != 0) {
            int i = 0;
            while (i < one) {
                ret++;
                for (int j = 0; j < K && i < N; j++) {
                    A[i] = 1;
                    i++;
                }
                if (i <= one) {
                    i--;
                }
            }
        }

        // update
        for (int i = 0; i < N; i++) {
            if (A[i] == 1) {
                one = i;
            }
        }

        if (one != (N-1)) {
            int i = N -1;
            while (i > one) {
                ret++;
                for (int j = 0; j < K && i >= 0; j++) {
                    A[i] = 1;
                    i--;
                }
                if (i >= one) {
                    i++;
                }
            }
        }
        System.out.println(ret);
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
