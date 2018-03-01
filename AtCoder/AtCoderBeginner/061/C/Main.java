
import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.solve(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void solve(String[] args) throws Exception {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        long K = scanner.nextLong();

        HashMap<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Long j = map.get(a);
            if (j == null) {
                map.put(a, (long)b);
            } else {
                map.put(a, (long)b + (long)j);
            }
        }

        // キーでソートする
        Object[] mapkey = map.keySet().toArray();
        Arrays.sort(mapkey);
        for (int i = 0; i < mapkey.length; i++) {
            Integer nKey = (Integer)mapkey[i];
            Long c = map.get(nKey);
            K = K - c;
            if (K <= 0) {
                System.out.println(nKey);
                return;
            }
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
