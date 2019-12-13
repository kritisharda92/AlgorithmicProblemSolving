import java.util.*;
import java.lang.*;

class BearAndSpecies
{
    static char[][] graph;
    static boolean[][] visited;
    private static int size, G, B, P, Q, total;

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 0; i < test; i++) {
            size = sc.nextInt();

            graph = new char[size][size];
            visited = new boolean[size][size];

            for(int j = 0; j < size; j++) {
                String ip = sc.next();
                char[] ipArr = ip.toCharArray();

                for(int k = 0; k < ipArr.length; k++) {
                    graph[j][k] = ipArr[k];
                }
            }

            bearAndSpecies();
        }
        sc.close();
    }

    static void bearAndSpecies() {
        long result = 1;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!(i == size || j == size || i == -1 || j == -1 || visited[i][j] || graph[i][j] == '.')) {
                    result = (result * getCount(i,j)) % 1000000007;
                    if(result == 0) break;
                }
            }
        }
        System.out.println(result);
    }

    public static int getCount(int i, int j) {
        G = 0; B = 0; P = 0; Q = 0; total = 0;
        dfs(i, j);
        if(total == 1 && Q > 0) return 3;
        if(total == 1) return 1;
        if(G > 0 || (B > 0 && P > 0)) return 0;
        if(Q > 0 && !(B > 0 || P > 0)) return 2;
        return 1;
    }

    public static void dfs(int x, int y) {
        if(x == size || y == size || x == -1 || y == -1 || visited[x][y] || graph[x][y] == '.')
            return;
        total++;
        visited[x][y] = true;

        if(graph[x][y] == 'B') B++;
        if(graph[x][y] == 'G') G++;
        if(graph[x][y] == 'P') P++;
        if(graph[x][y] == '?') Q++;

        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x,y+1);
        dfs(x,y-1);
    }

}
