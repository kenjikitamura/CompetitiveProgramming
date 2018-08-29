package codes;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class ABC093C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] v = new int[3];
        for (int i = 0; i < 3; i++) {
            v[i] = in.nextInt();
        }
        Arrays.sort(v);
        int a = v[2] - v[0];
        int b = v[2] - v[1];
        int ans = 0;
        ans += a / 2;
        a = a % 2;
        ans += b / 2;
        b = b % 2;
        if (a == 0 && b == 0) {
            // do nothing.
        } else if (a == 1 && b == 1) {
            ans++;
        } else {
            ans += 2;
        }
        out.println(ans);
    }
}
