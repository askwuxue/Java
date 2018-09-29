public class LinkedList<E> {
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

        public Node() {
            this(null, null);
        }

        @Override
        public String toString () {
            return e.toString();
        }
    }

    // 设立虚拟节点
    private Node dummyHead;
    private int size;

    public LinkedList () {
        dummyHead = new Node (null, null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize () {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty () {
        return size == 0;
    }

    // 在链表中间添加元素
    public void add (int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
            Node prev = dummyHead;
            // 找到index前面节点
            for (int i = 0; i < index ; i++) {
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            // prev.next = new Node(e, prev.next);
            size++;
    }

    // 在链表头添加新的元素
    public void addFirst (E e) {
        add(0, e);
    }

    // 向链表的末尾添加元素
    public void addLast (E e) {
        add(size, e);
    }

    // 获得链表的第index个操作
    public E get (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get field，index is illeega");
        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.e;
    }

    // 获得链表的第一个元素
    public E getFirst () {
        return get(0);
    }

    // 获得元素的最后一个元素
    public E getLast () {
        return get(size - 1);
    }

    // 更新元素
    public void set (int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get field，index is illeega");
        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.e = e;
    }

    // 查找链表中是否有某个元素
    public boolean contains (E e) {
        Node curr = dummyHead.next;
        while (curr != null) {
            if (curr == e) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // 根据索引删除链表中的某个元素
    public E remove (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, Index is illegal");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

//    删除某个元素
    public void removeElement (E e) {
        if (isEmpty()) {
            return;
        }
        if (!contains(e)) {
            return;
        }
        Node prev = dummyHead;
        for (int i = 0; i < size; i++) {
            if (prev.next == e) {
                Node retNode = prev.next;
                prev.next = retNode.next;
                retNode.next = null;
                size--;
            } else {
                prev = prev.next;
            }
        }
    }


    // 删除链表的第一个元素
    public E removeFirst () {
        return remove(0);
    }

    // 删除链表的最后一个元素
    public E removeLast () {
        return remove(size - 1);
    }

    // 复写toString
    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        Node curr = dummyHead.next;
        while (curr != null) {
            res.append(curr.e + "->");
            curr = curr.next;
        }
        res.append("NUll");
        return res.toString();
    }
}
