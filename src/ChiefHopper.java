
public class ChiefHopper {

    static int chiefHopper(int[] arr) {
        int len = arr.length-1;
        int energy = arr[len]/2 + arr[len]%2;
        for (int i = len-1; i>=0; i--) {
            System.out.println(energy+"....");
            energy = (arr[i] + energy)/2 + (arr[i] + energy)%2;
        }
        return energy;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,3,2,4};
        System.out.println(chiefHopper(arr));
    }
}
