import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    private int a(int i) {
        int ret = 0;
        while (i % 100 == 0) {
            i = i / 100;
            ret++;
        }
        return ret;
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int D = scanner.nextInt();
        int N = scanner.nextInt();


        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 1010000; i++) {
            int i1 = i % 100;
            int i2 = (i % 100) % 100;

            int i3 = a(i);
            if (i3 == D) {
                list.add(i);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(N - 1));
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
