import java.util.Scanner;

public class InsertionSortAdvAnalysis {

    static long result;

    static void merge(int[] arr, int left, int right){
        int nLeft = ((left+right)/2) + 1;
        int nRight = right+1;
        int start = left;
        int[] newArr = new int[right-left+1];
        right = nLeft;

        int i;
        for(i = 0; left < nLeft && right < nRight; i++) {
            if(arr[left]<=arr[right]) {
                newArr[i]=arr[left];
                left++;
            }
            else {
                newArr[i]=arr[right];
                result+=(nLeft-left);
                right++;
            }
        }

        while (left < nLeft) {
            newArr[i] = arr[left];
            left++; i++;
        }
        while(right < nRight){
            newArr[i] = arr[right];
            right++; i++;
        }
        for(i=0;start<nRight;start++,i++)
            arr[start]=newArr[i];
    }

    static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int querries = sc.nextInt();
        while (querries>0) {
            result = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            mergeSort(arr, 0, n-1);
            querries--;
            System.out.println(result);
        }
    }

}
