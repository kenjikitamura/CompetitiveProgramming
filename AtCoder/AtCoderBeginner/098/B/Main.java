import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        String S = scanner.next();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String s1 = S.substring(0,i);
            String s2 = S.substring(i,S.length());
            int count = 0;
            String s3 = "";
            for (int j = 0; j < s1.length(); j++) {
                char ch = s1.charAt(j);
                if (s2.indexOf(ch) != -1) {
                    if (s3.indexOf(ch) == -1) {
                        s3 += ch;
                    }
                }
            }
            count = s3.length();
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
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
