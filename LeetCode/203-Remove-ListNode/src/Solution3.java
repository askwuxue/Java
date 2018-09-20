public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        /*
        * 根绝递归解决问题，首先要关注基本问题。将大的问题，
        * 转化为基本为题的求解
        * 将链表的每一个节点转化为一个链表的情况
        * */

        // 先判断链表是否为空,基本的问题
        if (head == null) {
            return head;
        }

        // remove方法 对当前节点的下一个节点进行求解
        head.next = removeElements(head.next, val);

        // 根据当前节点的值与给定的值比较，判断是返回当前节点还是返回当前节点的下一个节点

        return head.val == val ? head.next : head;

    }
}
