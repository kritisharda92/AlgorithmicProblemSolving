public class ArithmeticExpressions {

    private static String expList = "";

    private static String arithmeticExpressions(int[] arr){

        StringBuilder path = new StringBuilder();
        findExp(arr, "*", 1, arr[0]);
        findExp(arr, "+", 1, arr[0]);
        findExp(arr, "-", 1, arr[0]);

        for(int i=0; i<arr.length-1; i++){
            path.append(arr[i]).append(expList.charAt(i));
        }
        path.append(arr[arr.length - 1]);
        return path.toString();
    }

    private static void findExp(int[] arr, String exp, int i, int curr){
        if(expList.length() > 0) return;
        char c = exp.charAt(exp.length()-1);
        if(c == '*') curr = curr * arr[i];
        else if(c == '+') curr = curr + arr[i];
        else if(c == '-') curr = curr - arr[i];
        if(i == arr.length-1){
            if(curr % 101 == 0) expList = exp;
            return;
        }
        findExp(arr, exp+"*", i+1, curr);
        findExp(arr, exp+"+", i+1, curr);
        findExp(arr, exp+"-", i+1, curr);
    }

    public static void main(String[] args) {
        int[] arr = {22, 79, 21};
        int[] arr2 = {55, 3, 45, 33, 25};
        System.out.println(arithmeticExpressions(arr));
    }
}
