
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
        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = scanner.nextInt();
        }

        int A = 0;
        int B = 0;


        for (int i = 0; i < N; i++) {
            int rightIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (X[j] -  X[i] >= D) {
                    rightIndex = j - 1;
                    break;
                }
            }
            if (rightIndex - i >= 2) {
                A += nCr(rightIndex - i, 2);
            }
        }
        System.out.println("A=" + A);

        int right = 0;
        int left = 0;
        for (int m = 0; m < N; m++) {
            // right
            for (int j = right; j < N; j++) {
                if (X[j] -  X[m] >= D) {
                    right = j - 1;
                    break;
                }
            }
            
            // left
            while (X[m] -  X[left] >= D) {
                left++;
            }

            B += (m - left) * (right * m);
        }
        System.out.println(B - A);
    }

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
