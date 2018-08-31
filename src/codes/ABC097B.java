package codes;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class ABC097B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int X = in.nextInt();
        boolean[] b = new boolean[X+1];
        b[1] = true;
        for (int c = 2; c <= X; c++) {
            int v = c * c;
            while (v <= X) {
                b[v] = true;
                v *= c;
            }
        }
        for (int i = X; i >= 1; i--) {
            if (b[i]) {
                out.println(i);
                return;
            }
        }
        return;
    }

    public static boolean isPower(int num) {
        if (num == 1) return true;
        for (int n = 2; Math.pow(num, 1.0 / n) >= 2.0; n++) {
            double nThRoot = Math.pow(num, 1.0 / n);
            if (nThRoot - Math.floor(nThRoot) < 0.00001)
                return true;
        }
        return false;
    }
}
