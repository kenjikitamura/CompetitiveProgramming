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
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            list.add(scanner.next());
        }

        int[] dx = {0,   1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1,  1,  0, -1};
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (list.get(i).charAt(j) == '#') {
                    System.out.print("#");
                    continue;
                }
                int sum = 0;
                for (int l = 0; l < dx.length; l++) {
                    if (dx[l] + j >= W || dx[l] + j < 0 || dy[l] + i >= H || dy[l] + i < 0) {
                        continue;
                    }
                    if (list.get(i + dy[l]).charAt(j + dx[l]) == '#') {
                        sum++;
                    }
                }
                System.out.print(sum);
            }
            System.out.println("");
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
