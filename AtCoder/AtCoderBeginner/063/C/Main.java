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
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int s = scanner.nextInt();
            list.add(s);
            sum+=s;
        }
        
    }

    /*
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int s = scanner.nextInt();
            list.add(s);
            sum+=s;
        }
        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            if (sum % 10 != 0) {
                System.out.println(sum);
                return;
            }
            sum -= list.get(i);
        }
        System.out.println(sum);
    }
    */

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
