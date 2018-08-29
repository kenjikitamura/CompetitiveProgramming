package codes;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Task {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();
        int K = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = A; i < A + K && (i <= B); i++) {
            if (i > B) continue;
            set.add(i);
        }
        for (int i = B - K + 1; i <= B; i++) {
            if (i < A) continue;
            set.add(i);
        }
        for (Integer i : set) {
            out.println(i);
        }
    }
}
