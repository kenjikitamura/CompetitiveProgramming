package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class Task {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        if (s.indexOf("a") != -1
                && s.indexOf("b") != -1
                && s.indexOf("c") != -1) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }
}
