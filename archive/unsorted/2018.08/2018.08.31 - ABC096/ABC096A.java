package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC096A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int ans = (a - 1) + (a <= b ? 1 : 0);
        out.println(ans);
    }
}
