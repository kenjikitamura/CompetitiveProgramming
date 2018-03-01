import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        int W = scanner.nextInt();
        List<Integer> bug = new ArrayList<>();
        for (int i = 0; i <= W; i++) {
            bug.add(0);
        }

        for (int i = 0; i < N; i++) {
            int w = scanner.nextInt();
            int v = scanner.nextInt();
            List<Integer> nextbug = new ArrayList<>();
            for (int l = 0; l <= W; l++) {
                int index = l - w;
                if (index < 0) {
                    nextbug.add(bug.get(l));
                } else {
                    int nextV1 = bug.get(index) + v;
                    int nextV2 = bug.get(l);
                    nextbug.add(Math.max(nextV1, nextV2));
                }
            }
            bug = nextbug;
        }
        System.out.println(bug.get(bug.size() -1));
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
