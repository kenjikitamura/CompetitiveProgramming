package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC108C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long N2 = in.nextLong();
        long K = in.nextLong();
        for (int N = 1; N < 40; N++) {
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {

                        if ((i + j) % K == 0 &&
                                (j + k) % K == 0 &&
                                (k + i) % K == 0) {
                            //System.out.println("("+i+","+j+","+k+")");
                            //System.out.println("hit!!");
                            ans++;
                        }
                    }
                }
            }
            System.out.println("N="+ N+ " K="+ K+ " 全部=" + (N * N * N) + " 解=" + ans);
            long a = N / K;
            long ans3 = (a * a * a) * 2;
            long ans4 = (a * a * a) * 2 + a * 2;
            System.out.println("解? " + ans3 + " 差 " + ((ans - ans3) -1) / K);
        }
    }
}
