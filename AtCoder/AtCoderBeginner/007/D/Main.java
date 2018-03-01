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
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long count = 0;
        for (long i = A; i <= B; i++) {
            String s = ""+i;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '4' || s.charAt(j) == '9') {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }


    /*
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        long A = scanner.nextLong();
        long B = scanner.nextLong();

        String strA = "" + A;
        String strB = "" + B;
        while (strB.length() != strA.length()) {
            strB = "0" + strB;
        }


        int count = 0;
        for (int i = 0; i < strA.length(); i++) {
            int a = strA.charAt(i) - '0';
            int b = strB.charAt(i) - '0';

            
            for (int j = b; i < a; i++) {
                if (j == 4 || j == 9) {
                    count++;
                }
            }
        }

        System.out.println(count);
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
