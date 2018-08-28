import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Kenji
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ABC092D solver = new ABC092D();
        solver.solve(1, in, out);
        out.close();
    }

    static class ABC092D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int A = in.nextInt();
            int B = in.nextInt();

            int[][] m = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (i < 50) {
                        m[i][j] = 0;
                    } else {
                        m[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < B - 1; i++) {
                int height = i / 50;
                m[height * 2][i % 50 * 2] = 1;
            }

            for (int i = 0; i < A - 1; i++) {
                int height = i / 50;
                m[99 - height * 2][i % 50 * 2] = 0;
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (m[i][j] == 0) {
                        out.print('.');
                    } else {
                        out.print('#');
                    }
                }
                out.println();
            }
        }

    }
}

