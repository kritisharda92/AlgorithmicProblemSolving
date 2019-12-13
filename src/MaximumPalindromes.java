import java.util.*;

public class MaximumPalindromes {

    static int mul(int a, int b) {
        long l = (long) a;
        return (int) (l * b % (int) (1e9 + 7));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int[][] count = precalculateOccurences(s, n);

        int q = sc.nextInt();

        int[] fact = new int[n + 1];
        int[] invFact = new int[n + 1];
        int[] inv = new int[n + 1];
        generateVals(n, fact, invFact, inv);
        calculateAns(sc, count, q, fact, invFact);
    }

    private static void generateVals(int n, int[] fact, int[] invFact, int[] inv) {
        inv[1] = 1;
        int iter = 2;
        while(iter <= n) {
            inv[iter] = mul((int) (1e9 + 7) - (int) (1e9 + 7) / iter, inv[(int) (1e9 + 7) % iter]);
            iter++;
        }

        fact[0] = 1;
        invFact[0] = 1;
        iter = 1;
        while(iter <= n) {
            fact[iter] = mul(fact[iter - 1], iter);
            invFact[iter] = mul(invFact[iter - 1], inv[iter]);
            iter++;
        }
    }

    private static int[][] precalculateOccurences(String s, int n) {
        int[][] count = new int[26][n];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a'][i]++;
        }

        for (int j = 0; j < 26; j++) {
            for (int i = 1; i < n; i++) {
                count[j][i] += count[j][i - 1];
            }
        }
        return count;
    }

    private static void calculateAns(Scanner sc, int[][] count, int q, int[] fact, int[] invFact) {
        for (int query = 1; query <= q; query++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int odd = 0;
            int ans = 1;
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                int d = count[i][end];
                if (start > 0) {
                    d -= count[i][start - 1];
                }
                odd += d & 1;
                d /= 2;
                sum += d;
                ans = mul(ans, invFact[d]);
            }

            ans = mul(ans, fact[sum]);
            if (odd > 0) {
                ans = mul(ans, odd);
            }
            System.out.println(ans + "");
        }
    }
}
