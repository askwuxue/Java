import java.util.Scanner;
// 递归求斐波那契数列
public class recursionDemo {
    static int fn (int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fn(n -1) + fn(n -2);
        }
    }
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int input = scan.nextInt();
        int result = recursionDemo.fn(input);
        System.out.println("斐波那契数为：");
        System.out.println(result);
    }
}