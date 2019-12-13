import java.util.*;

public class PerfectRectangles {
    Map<String, Integer> map = new HashMap<>();

    public boolean isRectangleCover(int[][] rectangles) {
        int row = rectangles.length;
        if (row == 0 || rectangles[0].length==0) return false;

        int top_left, bot_left, top_right, bot_right, sum = 0;
        top_left = Integer.MAX_VALUE;
        top_right = Integer.MIN_VALUE;
        bot_left = Integer.MAX_VALUE;
        bot_right = Integer.MIN_VALUE;

        for (int[] rec : rectangles) {
            top_left = Math.min(top_left, rec[0]);
            bot_left = Math.min(bot_left, rec[1]);
            top_right = Math.max(top_right, rec[2]);
            bot_right = Math.max(bot_right, rec[3]);
            sum += (rec[2] - rec[0]) * (rec[3] - rec[1]);

            if (coverRegion(rec[0] + " " + rec[1], 1)
                    || coverRegion(rec[0] + " " + rec[3], 2)
                    || coverRegion(rec[2] + " " + rec[1], 4)
                    || coverRegion(rec[2] + " " + rec[3], 8)

            )
                return false;
        }
        int count = 0;

        for(int i : map.values()) {
            if (i != 15 && i != 12 && i != 10 && i != 9 && i != 6 && i != 5 && i != 3) count++;
        }

        return count == 4 && sum == (top_right - top_left) * (bot_right - bot_left);
    }

    private boolean coverRegion(String corner, Integer num) {
        int val = 0;
        if (map.containsKey(corner)) {
            val = map.get(corner);
            if((val&num) != 0)
                return true;
        }
        val = val | num;
        map.put(corner, val);
        return false;
    }

    public static void main(String[] args) {
        PerfectRectangles obj = new PerfectRectangles();
        int[][] rect = {{1, 1, 3, 3},{3, 1, 4, 2},{3, 2, 4, 4},{1, 3, 2, 4},{2, 3, 3, 4}};
        System.out.println(obj.isRectangleCover(rect));
    }
}
