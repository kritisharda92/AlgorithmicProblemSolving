import java.util.*;
import java.lang.*;

class SnakesAndTheirCoupAgainstTheMongoose
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while(test>0) {

            char[][] sArray = new char[sc.nextInt()][2];

            String row1 = sc.next();
            String row2 = sc.next();

            int ans = 1, r1 = 0, r2 = 0;
            boolean flag1 = false, flag2 = false;
            int r1Len = row1.length();

            for(int i = 0; i < r1Len; i++) {
                sArray[i][0] = row1.charAt(i);
                if(sArray[i][0] == '*') {
                    r1++; flag1 = true;
                }

                sArray[i][1] = row2.charAt(i);
                if(sArray[i][1] == '*') {
                    r2++; flag2 = true;
                }
            }
            if(flag1 && flag2) {
                r1 = 0; r2 = 0;
                for (int i = 0; i < r1Len; i++) {
                    if (sArray[i][0] == '*') r1++;
                    if (sArray[i][1] == '*') r2++;
                    if (r1 == 2 || r2 == 2) {
                        ans++;
                        r1 = 0; r2 = 0;
                        i--;
                    }
                }
            }

            else ans = Math.max(r1, r2) - 1;
            System.out.println(Math.max(ans, 0));
            test--;
        }
    }
}
