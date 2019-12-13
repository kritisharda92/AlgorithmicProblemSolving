import java.util.*;
import java.lang.*;

public class FindingHardestSumValue
{
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] dp1 = new int[n][m];
            for (int i = 0; i < n; i++)
                dp1[i][0] = arr[i][0];
            for(int i = 0; i<n ; i++){
                for (int j = 1; j < m; j++) {
                    dp1[i][j] = Math.min(arr[i][j], arr[i][j] + dp1[i][j - 1]);
                }
            }

            int[][] dp2 = new int[n][m];
            for (int i = 0; i < n; i++)
                dp2[i][m - 1] = arr[i][m - 1];
            for(int i=0; i<n ; i++) {
                for (int j = m - 2; j >= 0; j--) {
                    dp2[i][j] = Math.min(arr[i][j], arr[i][j] + dp2[i][j + 1]);
                }
            }

            int[][] dp3 = new int[n][m];
            for (int i = 0; i < m; i++)
                dp3[0][i] = arr[0][i];
            for(int i = 0; i<m; i++) {
                for (int j = 1; j < n; j++) {
                    dp3[j][i] = Math.min(arr[j][i], arr[j][i] + dp3[j - 1][i]);
                }
            }

            int[][] dp4 = new int[n][m];
            for (int i = 0; i < m; i++)
                dp4[n - 1][i] = arr[n - 1][i];
            for(int i = 0; i<m ; i++){
                for (int j = n - 2; j >= 0; j--) {
                    dp4[j][i] = Math.min(arr[j][i], arr[j][i] + dp4[j + 1][i]);
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int val = dp1[i][j] + dp2[i][j] + dp3[i][j] + dp4[i][j] - 3 * arr[i][j];
                    min = Math.min(val,min);
                }
            }
            System.out.println(min);
            test--;
        }
    }
}
