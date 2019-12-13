import java.util.*;

public class SupermanCelebratesDiwali {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int I = sc.nextInt();
        int[][] build = new int[N][H+1];
        int[][] dp = new int[N][H+1];
        int[] dpMax = new int[H+1];
        int maxSave = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++)
                build[i][sc.nextInt()]++;
        }

        for (int i = 0; i < N; i++) {
            dp[i][H] = build[i][H];
            if (dp[i][H] > dpMax[H])
                dpMax[H] = dp[i][H];
        }

        for (int j = H - 1; j >= 0; j--) {
            for (int i = 0; i < N; i++) {
                int tmp = 0;
                if (j + I <= H && dpMax[j + I] > tmp) tmp = dpMax[j + I];
                if (dp[i][j + 1] > tmp) tmp = dp[i][j + 1];
                dp[i][j] = tmp + build[i][j];
                if (dp[i][j] > dpMax[j]) dpMax[j] = dp[i][j];
            }
        }

        for (int i = 0; i < N; i++)
            if (dp[i][0] > maxSave) maxSave = dp[i][0];
        System.out.println(maxSave);
    }
}

