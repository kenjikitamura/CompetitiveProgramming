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
        int N = scanner.nextInt();
        int[] list = new int[N];
        int[] list2 = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            list[i] = scanner.nextInt();
        }
        System.arraycopy(list, 0, list2, 0,N);
        Arrays.sort(list2);
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(list2[i])) {
                map.put(list2[i], i);
            }
        }

        for (int i = 0; i < N; i++) {
            int removeValue = list[i];
            int index = map.get(removeValue);
            if (index <= N/2) {
                System.out.println(list2[((list2.length+1)/2)]);
            } else {
                System.out.println(list2[(list2.length/2)]);
            }
        }
    }

    private class MyScanner {
        String[] s;int i;BufferedReader br;String reg = " ";
        MyScanner () {
            s = new String[0];i = 0;br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next() {
            try {
                if (i < s.length) return s[i++];
                String line = br.readLine();
                while (line.equals("")) {line = br.readLine();}
                s = line.split(reg, 0);
                i = 0;return s[i++];
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
