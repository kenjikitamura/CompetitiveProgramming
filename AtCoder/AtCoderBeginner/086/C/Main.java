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
        int N = scanner.nextInt();
        int x = 0;
        int y = 0;
        int t = 0;
        for (int i = 0; i < N; i++) {
            int nextt = scanner.nextInt();
            int nextX = scanner.nextInt();
            int nextY = scanner.nextInt();
            int diff = Math.abs(nextX -x) + Math.abs(nextY -y);
            int tdiff = nextt - t;
            if (tdiff < diff) {
                System.out.println("No");
                return;
            }
            diff = tdiff - diff;
            if (diff < 0) {
                System.out.println("No");
                return;
            } else if (diff % 2 != 0){
                System.out.println("No");
                return;
            }
            x = nextX;
            y = nextY;
            t = nextt;
        }
        System.out.println("Yes");
    }

    static boolean isSquare(int n){
        double fsqrt = Math.sqrt(n);
        int m = (int) fsqrt;
        return m*m == n;
    }


    private class MyScanner {
        String[] s;int i;BufferedReader br;String reg = " ";
        MyScanner () {
            s = new String[0];i = 0;br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next() {
            try {
                if (i < s.length) return s[i++];
                String line = br.readLine();
                while (line.equals("")) {line = br.readLine();}
                s = line.split(reg, 0);
                i = 0;return s[i++];
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
