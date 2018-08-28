import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int K = scanner.nextInt();

        int A = 10000000;
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            String s = ""+i;
            long a = 0;
            for (int j = 0; j < s.length(); j++) {
                a += s.charAt(j) - '0';
            }
            double sunuke = (double)i / (double)a;
            //System.out.println("i="+i+ " sunuke="+sunuke );
            list.add(sunuke);
        }

        for (int i = 0; i < A-1; i++) {
            double sunuke = list.get(i);
            boolean f = true;
            for (int j = i+1; j < A; j++) {
                if (sunuke > list.get(j)) {
                    f = false;
                    break;
                }
            }
            if (f) {
                System.out.println(i+" is sunuke. "+sunuke);
            }
        }


        /*
        long j = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= K; i++) {
            String s = "" + j;
            if (s.replaceAll("9","").length() == 0) {
                j += (long)Math.pow(10, s.length());
            } else {
                j += (long)Math.pow(10, s.length() - 1);
            }
            System.out.println(j);
        }
        */
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
