import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    int[] saikoro = new int[6];
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        saikoro[0] = scanner.nextInt();
        saikoro[5] = scanner.nextInt();
        saikoro[2] = scanner.nextInt();
        saikoro[4] = scanner.nextInt();
        saikoro[1] = scanner.nextInt();
        saikoro[3] = scanner.nextInt();

        int N = scanner.nextInt();
        int[] board = new int[N];
        for (int i = 0; i < N; i++) {
            board[i] = scanner.nextInt();
        }
        int currentSurface = getValueToSurface(board[N - 1]);
        int rotate = 0;
        for (int i = N -2; i >= 0; i--) {
            int nextValue = board[i];
            if (nextValue == getSurfaceToValue(currentSurface)) {
                // do nothing
            } else if (nextValue == getSurfaceToValue(getHantai(currentSurface))) {
                rotate += 2;
                currentSurface = getValueToSurface(nextValue);
            } else {
                rotate += 1;
                currentSurface = getValueToSurface(nextValue);
            }
        }
        System.out.println(rotate);
    }

    private int getSurfaceToValue(int surface) {
        return saikoro[surface];
    }

    private int getValueToSurface(int value) {
        for (int i = 0; i < 6; i++) {
            if (saikoro[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private int getHantai(int i) {
        switch (i) {
        case 0:
            return 5;
        case 1:
        case 2:
            return i + 2;
        case 3:
        case 4:
            return i - 2;
        case 5:
            return 0;
        }
        return 0;
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
