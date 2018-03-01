import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    int A = 0;
    int B = 0;
    List<Integer> list = new ArrayList<>();

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        A = scanner.nextInt();
        B = scanner.nextInt();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int h = scanner.nextInt();
            list.add(h);
        }
        int t = bsearch(0, 100000000);
        System.out.println(t);
    }

    private int bsearch(int min, int max) {
        if (max < min) {
            return min;
        } else {
            int mid = min + (max - min) / 2;
            boolean flag = enough(mid);
            System.out.println("min="+min+" max="+max+" mid="+mid+ " enough="+flag);
            if (flag) {
                return bsearch(mid + 1, max);
            } else {
                return bsearch(min, mid -1);
            }
        }
    }

    private boolean enough(int t) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            l.add(list.get(i) - (t * B));
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int diff = l.get(i);
            if (diff <= 0) {
                continue;
            }
            count+= diff / (A-B);
            if (diff % (A-B) != 0) {
                count++;
            }
        }
        System.out.println("count="+count+ " t="+t);
        return count <= t;
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
