import java.io.*;
import java.util.*;

public class RustAndMurder {
    
    static int[] rustMurderer(int s, ArrayList<Integer>[] data) {
        Map<Integer, Integer> dist = new TreeMap<>();
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(s);
        dist.put(s, 0);

        while (q.size() != 0) {
            int hold = q.poll();

            for (int i = 0; i < data.length; i++) {
                if (!dist.containsKey(i) && !data[hold].contains(i)) {
                    q.add(i);
                    dist.put(i, dist.get(hold) + 1);
                }
            }
            if (dist.size() == data.length)
                return getOutput(dist, data.length);
        }

        return getOutput(dist, data.length);
    }

    static int[] getOutput(Map<Integer, Integer> dist, int length) {
        int[] d = new int[length];
        for (Integer key : dist.keySet()) {
            d[key] = dist.get(key);
        }
        return d;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0].trim());

            int m = Integer.parseInt(nm[1].trim());

            ArrayList<Integer>[] data = new ArrayList[n];
            for (int j = 0; j < n; j++) {
                data[j] = new ArrayList<Integer>();
            }

            for (int roadsRowItr = 0; roadsRowItr < m; roadsRowItr++) {
                String[] roadsRowItems = scanner.nextLine().split(" ");
                int c = Integer.parseInt(roadsRowItems[0]) - 1;
                int d1 = Integer.parseInt(roadsRowItems[1]) - 1;

                data[c].add(d1);
                data[d1].add(c);
            }

            int s = Integer.parseInt(scanner.nextLine().trim()) - 1;

            int[] result = rustMurderer(s, data);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                if(resultItr != s){
                    bufferedWriter.write(String.valueOf(result[resultItr]));

                    if (resultItr != result.length - 1) {
                        bufferedWriter.write(" ");
                    }
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
