import java.util.*;

class SuffixRotation {

    private static String[] stringArr;
    private static int[] sizeArr;
    private static int[][] visitArr, shiftArr;

    public static int dp(int ch, int pos) {
        int chunk = 0;
        String curr = stringArr[ch];
        int len = stringArr[ch].length();
        int ans = 100000;

        if(sizeArr[ch] == 0) return  dp(ch + 1, pos);
        if(sizeArr[ch] == len) return chunk;
        if(visitArr[ch][pos] == 1) return shiftArr[ch][pos];

        List<Integer> startList = new ArrayList();
        List<Integer> endList = new ArrayList();
        int count[] = new int[len + 1];
        int index = 1;
        int start = 0, end = len - 1;

        char checkChar = (char)(ch + 'a');
        for(char c : curr.toCharArray()) {
            if(c == checkChar) {
                count[index] = count[index - 1] + 1;
            } else {
                count[index] = count[index - 1];
            }
            index++;
        }
        if(curr.charAt(end) == checkChar ) {
            for (;curr.charAt(end) == checkChar;end-- );
            for (;curr.charAt(start)  == checkChar; start++ );
            startList.add(start);
            endList.add((end + 1)%len);
            start++; chunk++;
            if(endList.get(0) == pos) chunk --;
        }

        for(int i = start; i <= end; i++) {

            if(curr.charAt(i) == checkChar && curr.charAt((i+len-1)%len) != checkChar) {
                startList.add(i);
                if(i == pos) chunk --;
            }
            if(curr.charAt(i) != checkChar && curr.charAt((i+len-1)%len) == checkChar) {
                endList.add(i);
                chunk++;
            }
        }
        if(endList.size() > 1) {
            for(int i = 0; i < endList.size(); i++) {
                if((endList.get(i) != ((end + 1)%len) && startList.get(i) == pos)
                        || (i == 0 && startList.get(i) == start - 1 && endList.get(i) == ((end + 1)%len)
                        && endList.get(i) == pos)) {
                    continue;
                }
                if(i == 0 && startList.get(i) == start - 1 && endList.get(i) == ((end + 1)%len)) {
                    ans = Math.min(ans, chunk + dp(ch + 1, 0));
                } else {
                    ans = Math.min(ans, chunk + dp(ch + 1, (endList.get(i) - count[endList.get(i) + 1])%(len-1)));
                }
            }
        } else {
            visitArr[ch][pos] = 1;
            if(startList.get(0) == start - 1 && endList.get(0) == ((end + 1)%len)) {
                ans = chunk + dp(ch + 1, 0);
            } else {
                ans = chunk + dp(ch + 1, (endList.get(0) - count[endList.get(0) + 1])%(len-1));
            }
        }

        visitArr[ch][pos] = 1;
        shiftArr[ch][pos] = ans;
        return shiftArr[ch][pos];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int alp = 26;
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int q = 0; q < t; q++) {
            String str = sc.nextLine();
            int len = str.length();
            int i = 0;

            stringArr = new String[alp];
            sizeArr = new int[alp];
            visitArr = new int[alp+1][len+1];
            shiftArr = new int[alp+1][len+1];

            while (i<len) {
                if(str.charAt(i) == 'a') sizeArr[0] ++;
                i++;
            }
            stringArr[0] = str;

            while(i<len) i++;
            i = 1;

            while (i<26){
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0; j < stringArr[i-1].length(); j++) {
                    if(stringArr[i-1].charAt(j) == ('a' + i)) sizeArr[i]++;
                    if(stringArr[i-1].charAt(j) != ('a' + i - 1)) stringBuilder.append(stringArr[i-1].charAt(j));
                }
                stringArr[i] = stringBuilder.toString();
                i++;
            }

            System.out.println(dp(0,0));
        }
    }
}
