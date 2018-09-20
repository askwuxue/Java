public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        // 设立虚拟头结点，虚拟头结点next指向head，根据元素的node进行删除
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        // 相当于从head开始遍历
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode nodeDel = prev.next;
                prev.next = nodeDel.next;
                nodeDel.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
