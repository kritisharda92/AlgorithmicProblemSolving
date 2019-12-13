class RotateString {
    public static boolean rotateString(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();

        if (lenA != lenB) return false;
        if(lenA == 0) return true;

        int dp[] = new int[lenA];
        dp[0] = 0;

        for (int i=1, len=0; i<lenA;) {
            if (A.charAt(i) == B.charAt(len))
                dp[i++] = ++len;
            else {
                if (len != 0)
                    len = dp[len - 1];
                else
                    dp[i++] = 0;
            }
        }

        for (int k = dp[lenA - 1], i=0; k < lenB; k++) {
            if (B.charAt(k) != A.charAt(i++))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("geeks","eksge"));
    }
}
