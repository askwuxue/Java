import java.util.ArrayList;
import java.util.TreeSet;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();

        // 将nums1 的元素放进set中，去重
        for (int num: nums1) {
            set.add(num);
        }

        // 创建动态数组，存储交集元素
        ArrayList<Integer> list = new ArrayList<>();

        // 遍历nums，将存在set中的元素，交集元素放进动态数组
        for (int num: nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}