import java.util.*;

public class AshtonAndString {

    private static class Suffix implements CharSequence, Comparable<CharSequence> {
        private final String word;
        private final int index;
        private final int length;

        static Suffix init(String word, int index) {
            int length = word.length();
            return new Suffix(word, index, length);
        }

        static Suffix get(String word, int index, int end) {
            return new Suffix(word, index, end);
        }

        Suffix(String word, int index, int end) {
            this.word = word; this.index = index;
            this.length = end - index;
        }

        @Override
        public int length() {
            return length;
        }

        @Override
        public char charAt(int index) {
            int idx = this.index + index;
            char c = word.charAt(idx);
            return c;
        }

        @Override
        public CharSequence subSequence(int index, int end) {
            int idx = this.index + index;
            int e = this.index + end;
            return Suffix.get(word, idx, e);
        }

        @Override
        public int compareTo(CharSequence sequence) {
            int l1 = length;
            int l2 = sequence.length();
            for (int i = 0; i < l1 && i < l2; i++) {
                if (charAt(i) - sequence.charAt(i) != 0) {
                    return charAt(i) - sequence.charAt(i);
                }
            }
            return l1 - l2;
        }

        @Override
        public String toString() {
            return word.substring(index, index + length);
        }
    }

    static char ashtonString(String s, int k) {

        SortedSet<Suffix> set = new TreeSet<>();
        int t, counter = 0;

        for (int i = 0; i < s.length(); i++) {
            set.add(Suffix.init(s, i));
        }

        Suffix curr = Suffix.get(s, 0, 0);
        Suffix prev;

        for (Suffix suffix : set) {
            t = 0;
            prev = curr;
            curr = suffix;

            while (prev.length() >= t
                    && curr.length() >= t
                    && curr.charAt(t) == prev.charAt(t))
                t++;

            int l = curr.length - t;
            for (int i = 1; i <= l; i++) {
                counter = counter + t + i;
                if (counter >= k) {
                    int idx = k - 1 - (counter - t - i);
                    return curr.subSequence(0, t + i).charAt(idx);
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(ashtonString(s,sc.nextInt()));
            test--;
        }
    }
}
