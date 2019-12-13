public class Rand10UsingRand7 {
    public int rand10() {
        int num;
        do {
            int row = rand7();
            int col = rand7();
            num = col + (row - 1) * 7;
        } while (num > 40);
        return 1 + (num - 1) % 10;
    }

    // predefined rand7 function
    public int rand7() {
        return (int)(Math.random() * ((7 - 1) + 1)) + 1;
    }

    public static void main(String args[]){
        Rand10UsingRand7 obj = new Rand10UsingRand7();
        System.out.println(obj.rand10());
        System.out.println(obj.rand10());
        System.out.println(obj.rand10());
        System.out.println(obj.rand10());
        System.out.println(obj.rand10());
        System.out.println(obj.rand10());
        System.out.println(obj.rand10());
    }
}
