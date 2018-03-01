import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    public void solve(String[] args) {
        int[][] g =
            {
                {1, 3, 5, 7, 8, 10, 12},
                {4, 6, 9, 11},
            };
        MyScanner scanner = new MyScanner();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        for (int i = 0; i < 2; i++) {
            boolean findX = false;
            boolean findY = false;
            for (int j = 0; i < g[i].length; l++) {
                if (g[i][l] == x) findX = true;
                if (g[i][l] == y) findY = true;
            }
            if (findX && findY) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
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

        public String next() throws IOException {
            if (i < s.length) return s[i++];
            String line = br.readLine();
            while (line.equals("")) {
                line = br.readLine();
            }
            s = line.split(reg, 0);
            i = 0;
            return s[i++];
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
