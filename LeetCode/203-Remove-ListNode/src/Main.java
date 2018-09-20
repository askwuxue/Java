import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        /*
           删除节点是根据找到当前节点的前一个元素，然后将前一个节点的next指向下一个节点的
        * 1 判断给定节点是不是头结点且不为空，是否删除
        * 2 判断链表是否为空  如果所有的元素都是要删除的元素
        * 3 循环，将满足节点的元素删除
        * */

        // 是否当前删除的是头结点且是否为空
        while (head != null && head.val == val) {
            ListNode headDel = head;
            head = head.next;
            headDel.next = null;
        }

        // 判断链表是否为空
        while (head == null) {
            return null;
        }

        // 删除其他元素，先的当前节点的前一节点,从head开始
        ListNode prev = head;
        // 判断是否是链表的最后一个元素
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode nodeDel = prev.next;
                prev.next = nodeDel.next;
                nodeDel.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}