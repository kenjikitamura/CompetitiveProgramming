package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC096B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int K = in.nextInt();
        int m = Math.max(A, Math.max(B, C));
        int n = A + B + C - m;
        for (int i = 0; i < K; i++) {
            m = m * 2;
        }
        out.println(m + n);
    }
}
