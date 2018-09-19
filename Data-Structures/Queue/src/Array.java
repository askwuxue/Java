import javax.crypto.interfaces.PBEKey;

public class Array<E> {
    private E[] data;
    private int size;

    // 构造函数，传入容量构造数组
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组容量 10
    public Array() {
        this(10);
    }

    // 获取元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组中的第一个位置添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 向数组中最后位置添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 向数组中的制定位置添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, require index 》 0 || index <= size");
        }
        // 如果当前的数组中元素满了，重新设置数组
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; index <= i; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Index is illegal");
        }
        return data[index];
    }

    // 获取数组中的第一个元素
    public E getFirst () {
        return get(0);
    }

    //获取数组中最后一个元素
    public E getLast () {
        return get(size - 1);
    }

    // 设置元素值
    public void set (int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Index is illegal");
        }
        data[index] = e;
    }

    // 获取元素在数组中的位置
    public int find (E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 获取数组中是否存在元素
    public boolean contains (E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 删除数数值指定位置的元素
    public E remove (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed. Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        // 缩容
        if (size == data.length / 4 && data.length != 0) {
            resize(data.length / 2);
        }
        // loitering objects != memory leak
        return ret;
    }

    //删除数组中的首个元素
    public E removeFirst () {
        return remove(0);
    }

    // 删除数组中的最后一个元素
    public E removeLast () {
        return remove(size - 1);
    }

    // 重新设置数组的大小
    private void resize (int newCapacaty) {
        E[] newArr = (E[]) new Object[newCapacaty];
        for (int i = 0; i < size; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    // 重写object类的toString方法
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity: %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
