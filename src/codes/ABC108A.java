package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC108A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int K = in.nextInt();
        int ans = 0;
        for (int i = 1; i <= K -1; i++) {
            for (int j = i+1; j <= K; j++) {
                if ((i + j) % 2 == 1) {
                    ans++;
                }
            }
        }
        out.println(ans);
    }
}
