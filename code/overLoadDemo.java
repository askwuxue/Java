public class overLoadDemo {

    // ��ӡ����֮�� ���÷���������
    // ��ע�͵�int���Ͳ����� ������ get(1, 2) ������뱨�� ��Ϊint���Ը���double���� ��֮ʧ��
    // ���غͷ���ֵ�������޹�
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