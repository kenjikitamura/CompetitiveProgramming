import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        new Main().main();
    }

    private void main() {
        int N, C, K;
        MyScanner scanner = new MyScanner();
        N = scanner.nextInt();
        C = scanner.nextInt();
        K = scanner.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        int busCount = 0;
        int current = 0;
        int time = -1;
        for (int i: list) {
            if (time == -1) {
                time = i;
                busCount++;
            }
            if ((time + K) < i) {
                busCount++;
                current = 0;
                time = i;
            }
            if (current >= C) {
                current = 0;
                busCount++;
                time = i;
            }
            current++;
        }
        System.out.println(busCount);
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
            return 0;
        }

        public double nextDouble() {
            try {
                return Double.parseDouble(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }

        public long nextLong() {
            try {
                return Long.parseLong(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}
