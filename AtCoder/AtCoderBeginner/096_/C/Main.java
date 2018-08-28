import java.io.*;
import java.util.*;
import static java.lang.Math.*;

// C - Grid Repainting 2
public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    List<String> list = new ArrayList<>();
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        for (int i = 0; i < H; i++) {
            list.add(scanner.next());
        }

        boolean ans = true;
        for (int i = 0; i < H; i++) {
            for (int l = 0; l < W; l++) {
                if (list.get(i).charAt(l) == '#') {
                    boolean ok = false;
                    if (i != 0 && list.get(i-1).charAt(l) == '#') {
                        ok = true;
                    }
                    if (l + 1 < W && list.get(i).charAt(l+1) == '#') {
                        ok = true;
                    }
                    if (i + 1 < H  && list.get(i+1).charAt(l) == '#') {
                        ok = true;
                    }
                    if (l != 0 && list.get(i).charAt(l-1) == '#') {
                        ok = true;
                    }
                    if (!ok) {
                        ans = false;
                    }
                }
            }
        }
        if (ans) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
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
