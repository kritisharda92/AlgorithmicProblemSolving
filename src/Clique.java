public class Clique {

    public static int turanTheorem(int n, int r){
        int mod = n % r;
        int sub = r - mod;
        int dr = n / r;
        int dr1 = n / r + 1;
        return mod * dr1 * sub * dr + mod * (mod - 1) * dr1 * dr1 / 2 + sub * (sub - 1) * dr * dr / 2;
    }

    public static int clique(int n, int m) {
        int low = 1;
        int hi = n+1;

        while(low + 1 < hi){
            int mid = low + (hi - low) / 2;
            if (turanTheorem(n, mid) < m)
                low = mid;
            else hi = mid;
        }
        return hi;
    }

    public static void main(String[] args) {
        System.out.println(clique(4,5));
    }
}
