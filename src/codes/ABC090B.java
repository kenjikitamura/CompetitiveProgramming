package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC090B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();
        int ans = 0;
        for (int i = A; i <= B; i++) {
            String s = "" + i;
            if (s.charAt(0) == s.charAt(4)
                    && s.charAt(1) == s.charAt(3)) {
                ans++;
            }
        }
        out.println(ans);
    }
}
