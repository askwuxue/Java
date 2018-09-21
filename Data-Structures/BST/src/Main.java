public class Main {

    public static void main(String[] args) {
	// write your code here
        BST2<Integer> bst = new BST2<>();

        int[] nums = {5, 3, 6, 8, 4, 2};

        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }

        System.out.println(bst.contains(8));
//        bst.preOrder();
        System.out.println(bst);
    }
}
