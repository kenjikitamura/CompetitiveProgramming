package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC092B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int D = in.nextInt();
        int X = in.nextInt();
        int[] A = new int[N];
        int ans = X;
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
            int l = 0;
            for (int j = 0; j < D; j++) {
                if (l == 0) {
                    ans++;
                    l = A[i] -1;
                } else {
                    l --;
                }
            }
        }
        out.println(ans);
    }
}
