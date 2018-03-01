import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    int[] array;
    int N ;
    long count = 0;
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        N = scanner.nextInt();
        array = new int[N];
        int 
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        dfs(0, 1);
        System.out.println(count);
    }

    private void dfs(int depth, long v) {
        if (depth == N) {
            if (v % 2 == 0) {
                count++;
            }
            return;
        }
        for (int i = -1; i < 2; i++) {
            dfs(depth+1, v * (array[depth] + i));
        }
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
