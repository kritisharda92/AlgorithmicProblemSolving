import java.util.HashMap;

public class BearAndSteadyGene {

    static int steadyGene(int len, String gene) {

        HashMap<Character,Integer> map = new HashMap<>();

        // Initially put all the character and frequencies in a map.
        for(int i=0;i<len;i++){
            char c = gene.charAt(i);
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        // Use left and right pointers to find the length of the smallest substring
        // that can be exchanged to obtain a steady gene
        int min = Integer.MAX_VALUE, l=0;
        for(int r = 0; r < len-1; ) {
            char c = gene.charAt(r++);
            map.put(c,map.get(c)-1);
            while(checkMap(map,len)){
                min = Math.min(min,r-l);
                char ch = gene.charAt(l++);
                map.put(ch,map.get(ch)+1);
            }
        }
        return min;
    }

    static boolean checkMap(HashMap<Character,Integer> map, int len){
        // Checks if the hashmap is steady
        for (Integer val : map.values())
            if (val > len / 4) return false;
        return true;
    }

    public static void main(String args[]) {
        int len1 = 8;
        String gene1 = "GAAATAAA";

        int len2 = 40;
        String gene2 = "TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC";

        System.out.print(steadyGene(len1,gene1));
    }
}
