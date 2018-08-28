import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    private Map<Integer, List<Integer>> map = new HashMap<>();
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt() -1;
            int y = scanner.nextInt() -1;
            List<Integer> list = map.get(x);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(x, list);
            }
            list.add(y);
        }

        int max = 1;
        LOOP:for (int i = 1; i < (1 << N); i++) {
            // check
            boolean ok = true;
            for (int l = 0; l < N; l++) {
                if ((i & (1 << l)) == 0) continue;

                for (int k = l; k < N; k++) {
                    if ((i & (1 << k)) == 0) continue;
                    if (l == k) continue;

                    int x = Math.min(l, k);
                    int y = Math.max(l, k);
                    List<Integer> list = map.get(x);
                    if (list == null) {
                        ok = false;
                        continue LOOP;
                    }
                    if (!list.contains(y)) {
                        ok = false;
                        continue LOOP;
                    }
                }
            }

            int count = 0;
            for (int l = 0; l < N; l++) {
                if ((i & (1 << l)) != 0) count++;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    private class MyScanner {
        String[] s;int i;BufferedReader br;String reg = " ";
        MyScanner () { s = new String[0];i = 0;br = new BufferedReader(new InputStreamReader(System.in)); }
        public String next() {
            try {
                if (i < s.length) return s[i++]; String line = br.readLine();
                while (line.equals("")) {line = br.readLine();}
                s = line.split(reg, 0); i = 0;return s[i++];
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
