import java.util.ArrayList;
import java.util.List;

public class TheCoinChangeProblem {

    public static long getWays(int n, List<Long> c) {
        long listLen = c.size();
        long[] mem = new long[n+1];
        mem[0] = (long)1;

        for(int i = 0; i<listLen; i++) {
            int l = Math.toIntExact(c.get(i));
            for(int j=l; j<n+1; j++){
                mem[j] = mem[j] + mem[j-l];
            }
        }
        return mem[n];
    }

    public static void main(String[] args) {
        TheCoinChangeProblem obj = new TheCoinChangeProblem();
        int n = 10;
        List<Long> c = new ArrayList<>();
        c.add((long)2);
        c.add((long)5);
        c.add((long)3);
        c.add((long)6);
        System.out.println(getWays(n, c));
    }
}
