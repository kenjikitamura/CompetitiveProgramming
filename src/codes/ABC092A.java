package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC092A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();
        out.println(Math.min(A,B) + Math.min(C,D));
    }
}
