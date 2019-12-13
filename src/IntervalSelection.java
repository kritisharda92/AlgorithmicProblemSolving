import java.util.Arrays;

public class IntervalSelection {

    public static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval i) {
            int val = Integer.compare(this.end, i.end);
            if (val == 0) return Integer.compare(this.start, i.start);
            return val;
        }
    }

    static int intervalSelection(int[][] intervals) {

        int len = intervals.length;
        int count;
        Interval[] intervalList = new Interval[len];

        for (int i = 0; i<len; i++){
            intervalList[i] = new Interval(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(intervalList);

        int curStart = 1;
        count = 1;
        Interval interval = intervalList[0];
        for (int i = 1; i<len; i++) {
            if (curStart <= intervalList[i].start) {
                if (intervalList[i].start <= interval.end) curStart = interval.end + 1;
                interval = intervalList[i];
                count++;
            }
        }
        return count;
    }


    public static void main( String args[] ) {
        int[][] inter = {{1,2},{2,3},{2,4}};
        System.out.println(intervalSelection(inter));
    }
}
