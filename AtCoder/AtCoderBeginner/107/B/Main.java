import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            list.add(scanner.next());
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.indexOf("#") == -1) {
                it.remove();
            }
        }
        for (int i = 0; i < W; i++) {
            boolean f = true;
            for (int j = 0; j < list.size(); j++) {
                String s = list.get(j);
                if (s.charAt(i) == '#') {
                    f = false;
                }
            }
            if (f) {
                for (int j = 0; j < list.size(); j++) {
                    String s = list.get(j);
                    String s2 = s.substring(0,i) + "!" + s.substring(i+1,s.length());
                    list.set(j, s2);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            boolean printed = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '!') {
                    System.out.print(s.charAt(j));
                    printed = true;
                }
            }
            if (printed) {
                System.out.println();
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
