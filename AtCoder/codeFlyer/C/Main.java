
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
        int D = scanner.nextInt();
        int[] X = new int[N + 1];
        for (int i = 0; i < N; i++) {
            X[i] = scanner.nextInt();
        }
        X[N] = Integer.MAX_VALUE;

        long A = 0;
        long B = 0;


        int right = 0;
        for (int i = 0; i < N; i++) {
            while (X[right] - X[i] <= D) {
                right++;
            }
            if (right - i >= 2) {
                A += nCr(right - i, 2);
            }
        }

        right = 1;
        int left = 0;
        for (int m = 1; m < N; m++) {
            // right
            while (X[right] - X[m] <= D) {
                right++;
            }

            // left
            while (X[m] - X[left] > D) {
                left++;
            }

            B += ((long)m - (long)left) * ((long)right - (long)m);
        }
        System.out.println(B - A);
    }

    /*
5 7
11 13 17 19 23

A(0) = 1
A(1) = 1
A(2) = 1


4 10
0 3 6 10
A(0) = 3
A(1) = 1



     */

    public long nCr(long n, long r) {
        long t = 1;
        for (int i = 0; i < r; i++) {
            t *= n-i;
            t /= i+1;
        }
        return t;
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
