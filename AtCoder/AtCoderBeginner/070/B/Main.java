import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        boolean a = false;
        boolean b = false;
        int ans = 0;
        for (int i = 0; i <= 100; i++) {
            if (i == A) {
                a = true;
            }
            if (i == B) {
                a = false;
            }
            if (i == C) {
                b = true;
            }
            if (i == D) {
                b = false;
            }
            if (a && b) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static gcd(long m, long n) {
        if (m < n) return gcd(n, m);
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    public static lcmImpl(long m, long n) {
        return m * n / gcd(m, n);
    }

    public static lcm(... long arr) {
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return lcmImpl(arr[0], arr[1]);
        long[] newArr = new long[arr.length];
        System.arraycopy(arr, 2, newArr, 1, arr.length - 2);
        newArr[0] = lcmImpl(arr[0], arr[1]);
        return lcm(newArr);
    }

    private class MyScanner {
        String[] s;
        int i;
        BufferedReader br;
        String reg = " ";

        MyScanner () {
            s = new String[0];
            i = 0;
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                if (i < s.length) return s[i++];
                String line = br.readLine();
                while (line.equals("")) {
                    line = br.readLine();
                }
                s = line.split(reg, 0);
                i = 0;
                return s[i++];
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public int nextInt() {
            try {
                return Integer.parseInt(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

        public double nextDouble() {
            try {
                return Double.parseDouble(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

        public long nextLong()  {
            try {
                return Long.parseLong(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }
    }
}
