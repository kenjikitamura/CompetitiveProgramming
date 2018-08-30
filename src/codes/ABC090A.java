package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC090A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        for (int i = 0; i < 3; i++) {
            String s = in.next();
            out.print(s.charAt(i));
        }
    }
}
