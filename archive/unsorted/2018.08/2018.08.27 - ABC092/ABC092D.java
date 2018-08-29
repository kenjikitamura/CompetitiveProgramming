package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC092D {
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

        for (int i = 0; i < B -1; i++) {
            int height = i / 50;
            m[height*2][i%50 *2] = 1;
        }

        for (int i = 0; i < A -1; i++) {
            int height = i / 50;
            m[99-height*2][i%50 *2] = 0;
        }

        out.println("100 100");
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
