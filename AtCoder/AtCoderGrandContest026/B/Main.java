import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            long A = scanner.nextLong();
            long B = scanner.nextLong();
            long C = scanner.nextLong();
            long D = scanner.nextLong();

            if (A < B) {
                System.out.println("No");
                continue;
            }

            A = (A % B) + B;
            boolean f = true;
            for (int l = 0; l < 1000; l++) {
                A -= B;
                if (A < 0) {
                    System.out.println("No");
                    f = false;
                    break;
                }
                if (A <= C) {
                    if (D/B >= 1) {
                        A += (D % B) + B;
                        if ((A + (D % B)) <= C && (D % B) != 0) {
                            A += (D % B) * (C-A / (D % B));
                            System.out.println("!!!");
                        }
                    } else {
                        A += D;
                    }
                }
            }
            if (f) {
                System.out.println("Yes");
            }
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

/*
1
10 10 7 11
 */
