public class BST2<E extends Comparable<E>> {
    private class Node {
        public E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST2() {
        root = null;
        size = 0;
    }

    // 判断二叉树的节点个数
    public int size() {
        return size;
    }

    // 判断二叉树是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向二叉树添加元素 每一个节点都理解为一个二叉树
    public void add(E e) {
        // 根据递归函数的结果，不断的更新根节点
        root = add(root, e);
    }

    // 递归函数，将结果返回
    private Node add(Node node, E e) {
        // 如果当前的根节点为空，就将元素放在当前，然后将结果返回
        if (node == null) {
            return new Node(e);
        }
        // 如果传进来的元素，小于根节点,继续递归，然后维护当前的节点的左子树
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
            // 如果传进来的元素，大于根节点,继续递归，然后维护当前的节点的右子树
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        // 将整棵树返回
        return node;
    }

    // 查找元素中是否有某个元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 递归实现
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 先序遍历
    public void preOrder () {
        // 先序遍历的递归函数
        preOrder(root);
    }

    // 先序遍历的递归函数
    public void preOrder (Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 复写toString
    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    // 生成深度的字符串
    private String generateDepthString (int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}