package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC108B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        int x3 = x2 - (y2-y1);
        int y3 = y2 + (x2-x1);
        int x4 = x3 - (x2-x1);
        int y4 = y3 - (y2-y1);
        out.println(x3 + " " + y3 + " " + x4 + " " + y4);
    }
}
