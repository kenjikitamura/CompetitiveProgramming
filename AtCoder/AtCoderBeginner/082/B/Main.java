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
        String s = scanner.next();
        String t = scanner.next();
        char[] charray = s.toCharArray();
        Arrays.sort(charray);
        String s2 = new String(charray);
        charray = t.toCharArray();
        Arrays.sort(charray);
        reverse(charray);
        String t2 = new String(charray);
        if (s2.compareTo(t2) < 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static final void reverse(char[] arr) {
        final int len = arr.length;
        char tmp;
        for (int i = 0; i < len / 2; i++) {
            tmp = arr[i];arr[i] = arr[len - 1 - i];arr[len - 1 - i] = tmp;
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
