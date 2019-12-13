public class ChocolateInBox {

    static int chocolateInBox(int[] arr) {

        int len = arr.length;
        int ans = 0;
        int count = 0;

        for(int i=0; i<len; i++){
            ans ^= arr[i];
        }

        for(int i=0; i<len; i++) {
            if((ans^arr[i])<arr[i])
                count++;
        }
        return count;
    }

    public static void main(String args[]) {
        int[] arr = {2,3};
        System.out.print(chocolateInBox(arr));
    }
}
