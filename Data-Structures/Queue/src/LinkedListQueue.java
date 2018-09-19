public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;
        public Node (E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node (E e) {
            this(e, null);
        }

        public Node () {
            this(null,null);
        }

        @Override
        public String toString () {
            return e.toString();
        }
    }

    private Node head, tail;
    private  int size;

    public LinkedListQueue () {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize () {
        return size;
    }

    @Override
    public boolean isEmpty () {
        return size == 0;
    }

    @Override
    public void enqueue (E e) {
        // 说明链表为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue () {
        if (isEmpty()) {
            throw new IllegalArgumentException("connot dequeue,queue should't is empty");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        // 如果链表为空，将链表的尾指向空
        if (head == null) {
            tail = head;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront () {
        if (isEmpty()) {
            throw new IllegalArgumentException("get failed, queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append("Queue: First: ");
        Node curr = head;
        while (curr != null) {
            res.append(curr + "->");
            curr = curr.next;
        }
        res.append("NUll tail ");
        return res.toString();
    }


}
