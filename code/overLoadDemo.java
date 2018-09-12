public class overLoadDemo {

    // 打印两数之和 利用方法的重载
    // 当注释掉int类型参数后 ，调用 get(1, 2) 不会编译报错 因为int可以赋给double类型 反之失败
    // 重载和返回值的类型无关
    static void getSum (int x, int y) {
        System.out.println(x + y);
    }

    static void getSum (double x, double y) {
        System.out.println(x + y);
    }

    static void getSum (String x, String y) {
        System.out.println(x + y);
    }

    public static void main (String[] args) {
        overLoadDemo.getSum(1, 2);
        overLoadDemo.getSum(1.1, 2.2);
        overLoadDemo.getSum("hello", "world");
    }
}