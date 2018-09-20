class Main {
    public static void main (String[] args) {
        Sum sum = new Sum();
        int[] arr = {1,2,3,4,5};
        int count = sum.sum(arr);
        System.out.println(count);
    }
}
public class Sum {
    public static int sum (int[] arr) {
        return sum(arr, 0);
    }

    private static int sum (int[] arr, int l) {
        if (arr.length == l) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}
