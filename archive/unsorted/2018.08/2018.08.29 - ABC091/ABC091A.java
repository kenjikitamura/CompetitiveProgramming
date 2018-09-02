package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC091A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        if (A + B >= C) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }
}
