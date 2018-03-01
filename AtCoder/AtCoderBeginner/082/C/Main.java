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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            if (map.get(a) == null) {
                map.put(a, 0);
            }
            Integer b = map.get(a);
            map.put(a, b + 1);
        }

        int ans = 0;
        for (int a:map.keySet()) {
            int count = map.get(a);
            if (a > count) {
                ans += count;
            } else if (a < count) {
                ans += count - a;
            }
        }
        System.out.println(ans);
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
