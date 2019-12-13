import java.util.*;

public class SherlockAndTheValidSTring {

    public static String isValid(String s) {
        HashMap<Character,Integer> map = new HashMap();
        HashMap<Integer,Integer> max_freq = new HashMap();
        int len = s.length();

        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c,0);
            map.put(c,map.get(c)+1);
        }

        for(Integer i : map.values()) {
            if(!max_freq.containsKey(i))
                max_freq.put(i,0);
            max_freq.put(i,max_freq.get(i)+1);
            if(max_freq.size()>2) return "NO";
        }

        int f1 = 0;
        if(max_freq.size() == 1) return "YES";
        for(Integer i : max_freq.keySet()) {
            if(f1 == 0) {
                f1 = i;
                continue;
            }
            int freq, outlier;
            if(max_freq.get(f1)>=max_freq.get(i)) {
                freq = f1;
                outlier = i;
            }
            else {
                freq = i;
                outlier = f1;
            }
            if(Math.abs(freq-outlier)!=1 && outlier!=1) return "NO";
            if(max_freq.get(f1)!=1 && max_freq.get(i)!=1) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        System.out.print(isValid("abcdefghhgfedecba"));
    }
}
