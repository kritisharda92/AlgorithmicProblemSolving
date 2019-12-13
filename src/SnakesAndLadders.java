import java.util.*;

public class SnakesAndLadders {
    static int[] board, mem;

    static void quickestWayUp(int pos, int n) {
        if (pos > 99) return;
        pos = board[pos];

        if (mem[pos] != -1 && mem[pos] <= n) return;
        mem[pos] = n;

        int dice=1;
        while(dice<7) {
            quickestWayUp(pos + dice, n + 1);
            dice++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCases = sc.nextInt();
        int t = 0;
        while(t<TestCases) {
            board = new int[100];
            for (int i = 0; i < 100; i++) board[i] = i;

            mem = new int[100];
            for (int i = 0; i < 100; i++) mem[i] = -1;

            int ladders = sc.nextInt();
            for (int i = 0; i < ladders; i++)
                board[sc.nextInt() - 1] = sc.nextInt() - 1;

            int snakes = sc.nextInt();
            for (int i = 0; i < snakes; i++)
                board[sc.nextInt() - 1] = sc.nextInt() - 1;

            quickestWayUp(0, 0);
            System.out.println("Minimum number of rolls for test case = "+ mem[99]);
            t++;
        }
    }
}
