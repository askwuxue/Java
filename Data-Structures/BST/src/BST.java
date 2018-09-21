public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        private Node left, right;

        public Node (E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST () {
        root = null;
        size = 0;
    }

    // 判断二叉树的节点个数
    public int size () {
        return size;
    }

    // 判断二叉树是否为空
    public boolean isEmpty () {
        return size == 0;
    }

    // 向二叉树添加元素
    public void add (E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            // 递归调用
            add(root, e);
        }
    }

    // 递归函数
    private void add (Node node, E e) {
        // 如果此节点和当前的节点相等，不处理这种情况
        if (e.equals(node.e)) {
            return;
            // 判断递归调用的节点和此二叉树根节点的关系，小于且根节点的左子树为空，处理
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
            // 判断递归调用的节点和此二叉树根节点的关系，大于且根节点的右子树为空，处理
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
            // 小于左子树，但是左子树不为空
        } else if (e.compareTo(node.e) < 0) {
            add(node.left, e);
            // 大于右子树，但是右子树不为空
        } else if (e.compareTo(node.e) > 0) {
            add(node.right, e);
        }
    }


}
