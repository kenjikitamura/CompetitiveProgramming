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
        int[][] map = new int[H][W];
        int space = 0;
        for (int i = 0; i < H; i++) {
            String s = scanner.next();
            for (int j = 0; j < W; j++) {
                char c = s.charAt(j);
                if (c == '#') {
                    map[i][j] = -1;
                } else {
                    space++;
                }
            }
        }
        boolean found = false;
        map[0][0] = 1;
        int[] dx = new int[]{ 0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1,  0};
        LOOP: do {
            found = false;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 1) {
                        found = true;
                        for (int k = 0; k < 4; k++) {
                            if (i + dy[k] >= 0 && i + dy[k] < H && j + dx[k] >= 0 && j + dx[k] < W && map[i + dy[k]][j + dx[k]] == 0) {
                                map[i + dy[k]][j + dx[k]] = -2;
                            }
                        }
                        map[i][j] = map[i][j] + 1;
                    } else if (map[i][j] > 0){
                        map[i][j] = map[i][j] + 1;
                    }
                }
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == -2) {
                        map[i][j] = 1;
                        if (i == H - 1 && j == W - 1) {
                            break LOOP;
                        }
                    }
                }
            }
        } while (found);
        if (map[H-1][W-1] == 0 || map[H-1][W-1] == -1) {
            System.out.println("-1");
        } else {
            System.out.println(space - map[0][0]);
        }
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
