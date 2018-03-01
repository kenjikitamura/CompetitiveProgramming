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
        int K = scanner.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Point(scanner.nextLong(), scanner.nextLong()));
        }

        List<Long> xList = new ArrayList<>();
        List<Long> yList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Point p = list.get(i);
            xList.add(p.x);
            yList.add(p.y);
        }

        long min = Long.MAX_VALUE;
        for (long startX : xList) {
            for (long endX : xList) {
                for (long startY : yList) {
                    for (long endY : yList) {
                        long x1,x2,y1,y2;
                        x1 = Math.min(startX, endX);
                        y1 = Math.min(startY, endY);
                        x2 = Math.max(startX, endX);
                        y2 = Math.max(startY, endY);

                        // count
                        int count = 0;
                        for (int k = 0; k < N; k++) {
                            Point p = list.get(k);
                            if (p.x >= x1 && p.x <= x2 && p.y >= y1 && p.y <= y2) {
                                count++;
                            }
                        }
                        if (count >= K) {
                            long a = (x2 - x1) * (y2 - y1);
                            min = Math.min(min, a);
                        }
                    }
                }
            }
        }

        System.out.println(min);
    }

    class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
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
