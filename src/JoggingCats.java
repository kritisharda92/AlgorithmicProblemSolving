import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JoggingCats {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = 150;
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] edgesList = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            edgesList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; ++i) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            edgesList[u].add(v);
            edgesList[v].add(u);
        }

        int[][] edges = new int[n][];
        for (int i = 0; i < n; ++i) {
            edges[i] = new int[edgesList[i].size()];
            for (int it = 0; it < edges[i].length; ++it) {
                edges[i][it] = edgesList[i].get(it);
            }
            Arrays.sort(edges[i]);
        }
        long[] ar = new long[m * K];
        int arLen = 0;
        long ans = 0;
        boolean[] col = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (edges[i].length <= K) {
                for (int it = 0; it < edges[i].length; ++it) {
                    for (int jt = it + 1; jt < edges[i].length; ++jt) {
                        ar[arLen++] = n * edges[i][it] + edges[i][jt];
                    }
                }
            } else {
                Arrays.fill(col, false);
                for (int j : edges[i]) {
                    col[j] = true;
                }
                for (int j = 0; j < n; ++j) {
                    if (edges[j].length > K && j <= i) {
                        continue;
                    }
                    long cnt = 0;
                    for (int k : edges[j]) {
                        if (col[k]) {
                            cnt++;
                        }
                    }
                    ans += cnt * (cnt - 1) / 2;
                }
            }
        }
        Arrays.sort(ar, 0, arLen);
        for (int i = 0; i < arLen; ) {
            int j = i;
            while (j < ar.length && ar[i] == ar[j]) {
                ++j;
            }
            long cnt = j - i;
            ans += cnt * (cnt - 1) / 2;
            i = j;
        }
        if (ans % 2 != 0) {
            throw new AssertionError();
        }
        System.out.println(ans/2);
    }
}
