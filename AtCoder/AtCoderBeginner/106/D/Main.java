import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();main.solve(args);
    }

    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Q = scanner.nextInt();
        int[] L = new int[M];
        int[] R = new int[M];
        int[] p = new int[Q];
        int[] q = new int[Q];
        List<Train> trainList = new ArrayList<>();
        List<Que> qList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            L[i] = scanner.nextInt();
            R[i] = scanner.nextInt();
            Train t = new Train();
            t.S = L[i];
            t.E = R[i];
            trainList.add(t);
        }
        for (int i = 0; i < Q; i++) {
            p[i] = scanner.nextInt();
            q[i] = scanner.nextInt();
            Que que = new Que();
            que.S = p[i];
            que.E = q[i];
            qList.add(que);
        }

        trainList.sort();
        
        System.out.println(ret);
    }

    private class Train implements Comparator {
        int S;
        int E;
    }

    private class Que {
        int S;
        int E;
        List<Train> trainList = new ArrayList<>();
    }

    /*
開始と終了をソートしておく
質問の開始もソートしておく

開始が小さい順にループ
質問に該当する範囲であれば、「現在の質問」リストに追加する。
現在の質問には、対応する列車を追加していく。
列車の終了が来れば、現在の質問から削除する。
質問の終了には、現在の質問から質問を削除する。
最後に、各質問にある列車数を出力する。

     */

    private class MyScanner {
        String[] s;int i;BufferedReader br;String reg = " ";
        MyScanner () { s = new String[0];i = 0;br = new BufferedReader(new InputStreamReader(System.in)); }
        public String next() {
            try {
                if (i < s.length) return s[i++]; String line = br.readLine();
                while (line.equals("")) {line = br.readLine();}
                s = line.split(reg, 0); i = 0;return s[i++];
            } catch (Exception e) {e.printStackTrace();}
            return null;
        }
        public int nextInt() {
            try {return Integer.parseInt(next());} catch (Exception e) {e.printStackTrace();}
            return -1;
        }
        public double nextDouble() {
            try {return Double.parseDouble(next());} catch (Exception e) {e.printStackTrace();}
            return -1;
        }
        public long nextLong()  {
            try {return Long.parseLong(next());} catch (Exception e) {e.printStackTrace();}
            return -1;
        }
    }
}
