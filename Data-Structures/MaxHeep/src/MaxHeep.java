import javafx.scene.Parent;

public class MaxHeep<E extends Comparable<E>> {
     private Array<E> data;

     public MaxHeep (int capacity) {
         data = new Array<>(capacity);
     }

     public MaxHeep () {
         data = new Array<>();
     }

     // heapify 设置为构造函数
    public MaxHeep(E[] arr) {
         data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

     // 返回堆中的元素个数
    public int size () {
         return data.getSize();
    }

    // 判断堆是否为空
    public boolean isEmpty () {
         return data.isEmpty();
    }

    // 返回index元素表示的元素的父节点的索引
    private int parent (int index) {
         if (index == 0) {
             throw new IllegalArgumentException("index-0 cannot is parent");
         }
         return (index - 1) / 2;
    }

    // 返回index元素表示的元素的左孩子的索引
    private int leftChild (int index) {
         return index * 2 + 1;
    }

    // 返回index元素表示的元素的右孩子的索引
    private int rightChild (int index) {
         return index * 2 + 2;
    }

    // Sift UP 向 添加一个元素
    public void add (E e) {
         data.addLast(e);
         siftUp(data.getSize() - 1);
    }

    // Sift Up的具体过程
    private void siftUp (int k) {
         while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
             data.swap(k, parent(k));
             // 上浮
             k = parent(k);
         }
    }

    // 查看堆中最大元素
    public E findMax () {
         if (data.getSize() == 0) {
             throw new IllegalArgumentException("Can not findMax when heep is empty");
         }
         return data.get(0);
    }

    // 取出堆中最大的元素
    public E extractMax () {
         E ret = findMax();
         data.swap(0, data.getSize() - 1);
         data.removeLast();

         // 进行下沉操作
        siftDown(0);

        return ret;
    }

    private void siftDown (int k) {
         // 循环终止条件， 当元素是叶子节点的时候终止
         while (leftChild(k) < data.getSize()) {
             int j = leftChild(k);
             // 判断右子树是否存在且是否值比左孩子大
             if (j + 1 < data.getSize() &&
             data.get(j + 1).compareTo(data.get(j)) > 0) {
                 j = rightChild(k);
             }
             // data[j] 是leftChild和rightChild的最大值
             // 判断是否需要下沉
             if (data.get(k).compareTo(data.get(j)) >= 0) {
                 break;
             }
             data.swap(k, j);
             //将k 下移
             k = j;
         }
    }

    // 去除最大元素，替换成元素e
    public E replace(E e) {
         E ret = findMax();
         data.set(0, e);
         siftDown(0);
         return ret;
    }




}
