public class FraudulentActivityNotifications {

    public static void main(String[] args) {
        int[] exp1 = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int[] exp2 = {1, 2, 3, 4, 4};
        System.out.println(activityNotifications(exp1, 5));
    }

    static int activityNotifications(int[] expenditures, int d) {
        int[] exp = new int[201];
        int ans = 0;

        for(int i = 0; i < d; i++) exp[expenditures[i]]++;

        for(int i = d; i < expenditures.length; i++) {
            int low, up, leftNum, rightNum;
            for(low=0,leftNum=0; (leftNum + exp[low]) * 2 <= d; low++ )
                leftNum += exp[low];
            for(up=exp.length - 1,rightNum=0; (rightNum + exp[up]) * 2 <= d; up-- )
                rightNum += exp[up];

            if(expenditures[i] >= low+up) ans++;

            exp[expenditures[i - d]]--;
            exp[expenditures[i]]++;
        }
        return ans;
    }
}
