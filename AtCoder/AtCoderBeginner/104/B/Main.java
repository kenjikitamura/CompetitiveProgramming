import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        String s = scanner.next();
        if (s.charAt(0) == 'A') {
            int count = 0;
            for (int i = 2; i < s.length() -1; i++) {
                if (s.charAt(i) == 'C') {
                    count++;
                }
            }
            if (count == 1) {
                String s3 = s.replaceAll("A","").replaceAll("C","");
                int count2 = 0;
                for (int i = 0; i < s3.length(); i++) {
                    if (s3.charAt(i) >= 'a' && s3.charAt(i) <= 'z') {
                    } else {
                        count2++;
                    }
                }
                if (count2 == 0) {
                    System.out.println("AC");
                    return;
                }
            }
        }
        System.out.println("WA");
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
