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
        String str = "" + A;
        int N = str.length();
        for (int i = 0; i < N /2; i++) {
            if (str.charAt(i) != str.charAt(N - i - 1)) {
                System.out.println("No");
                return ;
            }
        }
        System.out.println("Yes");
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
