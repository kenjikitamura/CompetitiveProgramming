package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC092C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        int sum = 0;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(prev - A[i]);
            prev = A[i];
        }
        sum += Math.abs(prev);
        for (int i = 0; i < N; i++) {
            int ans = sum;
            int p = 0;
            int n = 0;
            if (i != 0) {
                p = A[i-1];
            }
            if (i != N-1) {
                n = A[i+1];
            }
            ans -= Math.abs(p - A[i]);
            ans -= Math.abs(n - A[i]);
            ans += Math.abs(p - n);
            out.println(ans);
        }
    }
}
