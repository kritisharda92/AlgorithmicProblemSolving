public class TheIndianJob {

    static int dp[][];

    static void buildDP(int g, int[] arr) {
        int len = arr.length;
        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= g; j++) {
                if(arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1]] + arr[i - 1]);
            }
        }
    }

    static String indianJob(int g, int[] arr) {
        int len = arr.length;
        int sum = 0;
        for(int i=0; i<len; i++){
            sum = sum+arr[i];
        }
        if(sum>2*g) return "NO";
        dp = new int[len+1][g+1];
        buildDP(g, arr);
        return ((sum - dp[len][g] <= g) ? "YES" : "NO");
    }

    public static void main(String[] args) {
        int g = 4;
        int[] arr = {2, 4, 2};
        System.out.println(indianJob(g, arr));
    }
}
