import java.util.List;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
/*
* 从链表的头部开始循环，一直到尾部的前一个节点
* 设置虚拟头结点 虚拟头结点的next 指向 第一个元素
* */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null && node.next == null) {
            return;
        }
        // 当前元素的下一元素
        ListNode next = node.next;
        // 当前的元素的next 指向next 的 next
        node.next = next.next;
        node.val = next.val;
    }
}