import java.util.Scanner;
// �ݹ���쳲���������
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
        System.out.println("������һ������");
        int input = scan.nextInt();
        int result = recursionDemo.fn(input);
        System.out.println("쳲�������Ϊ��");
        System.out.println(result);
    }
}