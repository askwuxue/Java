import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> {
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

    public BST() {
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
            size++;
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

    // 现需遍历的非递归实现
    public void preOrderN () {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.e);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    // 中序序遍历
    public void inOrder () {
        //中序遍历的递归
        inOrder(root);
    }

    // 中序遍历的递归函数
    private void inOrder (Node node) {
        // 当前节点为空
        if (node == null) {
            return;
        } else {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    // 后序遍历
    public void postOrder () {
        // 后序遍历的递归
        postOrder(root);
    }

    // 后续遍历的递归函数
    private void postOrder (Node node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }

    }

    // 广度优先遍历 层级优先
    public void levelOrder () {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node curr = q.remove();
            System.out.println(curr.e);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    // 寻找最小元素
    public E minimum () {
        if (size == 0) {
            throw new IllegalArgumentException("BST is not empty");
        }
        return minimum(root).e;
    }

    // 寻找最小元素的递归
    private Node minimum (Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 寻找最大元素
    public E maximum () {
        if (size == 0) {
            throw new IllegalArgumentException("BST is not empty");
        }
        return maximum(root).e;
    }

    // 寻找最大元素的递归
    private Node maximum (Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    // 删除最小元素
    public E removeminimum () {
        E result = minimum();

        root = removeminimum(root);

        return result;
    }

    // 删除最小元素的递归处理
    // 返回删除节点后的二叉树的根
    private Node removeminimum (Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left  = removeminimum(node.left);
        return node;
    }

    // 删除最大元素
    public E removemaximum () {
        E result = maximum();

        root = removemaximum(root);

        return result;
    }

    // 删除最大元素的递归代码
    private Node removemaximum (Node node) {
        if (node.left == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removemaximum(node.right);
        return node;
    }

    // 删除任意元素
    public void remove (E e) {
        root = remove(root, e);
    }

    // 删除任意元素的递归，返回删除后的根节点
    private Node remove (Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {    // e == node.e
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeminimum(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
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