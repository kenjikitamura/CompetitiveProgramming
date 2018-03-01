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
        String string = scanner.next();
        int N = string.length();
        int[] hash = new int[N];
        for (int i = 0; i < N; i++) {
            hash[i] = hash(string.substring(0,i+1));
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Integer.toBinaryString(hash[i]));
        }
    }

    private int hash(String str) {
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - 'a';
            int bit = 1 << a;
            ret ^= bit;
        }
        return ret;
    }

    /*

    String str;
    int min = Integer.MAX_VALUE;
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        String string = scanner.next();
        String str = string;
        int ret = 0;
        while(str.length() != 0) {
            //System.out.println("---- str="+str);
            for (int i = 0; i < str.length(); i++) {
                String s = str.substring(0, str.length() - i);
                //System.out.println("s="+s + " check="+check(s));
                if (check(s)) {
                    //System.out.print(s+",");
                    str = str.substring(str.length() - i);
                    //System.out.println("new str=" + str);
                    ret++;
                }
            }
        }

        int r1 = ret;
        ret = 0;
        str = string;
        while(str.length() != 0) {
            System.out.println("---- str="+str);
            for (int i = str.length() -1; i >= 0; i--) {
                String s = str.substring(i, str.length());
                System.out.println("s="+s + " check="+check(s));
                if (check(s)) {
                    System.out.print(s+",");
                    str = str.substring(0, i);
                    System.out.println("new str=" + str);
                    ret++;
                }
            }
        }
        System.out.println("ret="+ret);
        System.out.println(Math.min(ret, r1));
    }

    private void dfs(int start, int end, int splitCount) {
        if (end == str.length()) {
            min = Math.min(min, splitCount);
            return;
        }
    }

    private boolean check(String s) {
        boolean flag = s.length() % 2 == 1;
        boolean[] checked = new boolean[30];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (checked[c - 'a']) {
                continue;
            }
            checked[c - 'a'] = true;
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                if (flag) {
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
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
