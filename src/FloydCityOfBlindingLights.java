import java.util.*;

public class FloydCityOfBlindingLights {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        int[][] adj = new int[nodes+1][nodes+1];

        for (int i = 1; i <= nodes; i++) {
            for (int j = 1; j <= nodes; j++) {
                if (i == j) adj[i][j] = 0;
                else adj[i][j] = 100000;
            }
        }

        for (int i = 0; i < edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            adj[from][to] = weight;
        }

        for (int i = 1; i <= nodes; i++) {
            for (int j = 1; j <= nodes; j++) {
                for (int k = 1; k <= nodes; k++) {
                    int x = adj[j][i]+adj[i][k];
                    if(x < adj[j][k])
                    {
                        adj[j][k]=x;
                    }
                }
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();

            if (adj[to][from] == 100000) System.out.println("-1");
            else System.out.println(adj[to][from]);
        }
    }
}
