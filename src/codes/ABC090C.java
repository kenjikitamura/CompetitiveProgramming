package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC090C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long N = in.nextInt();
        long M = in.nextInt();
        long ans = 0;
        if (N == 1 && M == 1) {
            ans = 1;
        } else if (N == 1 || M == 1) {
            ans = Math.max(N, M) - 2;
            ans = ans < 0 ? 0 : ans;
        } else {
            ans = (N - 2) * (M - 2);
        }
        out.println(ans);
    }
}
