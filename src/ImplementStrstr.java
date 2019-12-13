public class ImplementStrstr {

    public int strStr(String haystack, String needle) {

        int h_len = haystack.length();
        int n_len = needle.length();

        if(n_len == 0) return 0;
        if(n_len > h_len) return -1;
        if(n_len == h_len) {
            if(haystack.equals(needle)) return 0;
            return -1;
        }

        for(int i=0; i<=h_len-n_len; i++) {
            if(haystack.substring(i,i+n_len).equals(needle))
                return i;
        }

        return -1;
    }

    public static void main(String args[]) {
        ImplementStrstr obj = new ImplementStrstr();

        String s1 = "hello";
        String s2 = "ll";

//        String s1 = "hello";
//        String s2 = "bye";
//
//        String s1 = "hello";
//        String s2 = "";
//
//        String s1 = "mississippi";
//        String s2 = "pi";

        System.out.print(obj.strStr(s1,s2));

    }
}
