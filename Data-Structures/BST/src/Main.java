import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BST2<Integer> bst = new BST2<>();
        int[] nums = {5,3,2,8,1,4};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
//        bst.preOrder();
//        System.out.println(bst);
          bst.preOrder();
        bst.remove(1);
        System.out.println(bst);
//        Random random = new Random();
//
//        int n = 100;
//
//        for (int i = 0; i < n; i++) {
//            bst.add(random.nextInt(1000));
//        }
//
//        ArrayList<Integer> nums = new ArrayList<>();
//
//        while (!bst.isEmpty()) {
//            nums.add(bst.removeminimum());
//        }
//
//        System.out.println(nums);

    }
}
