class Point {
    private int x;
    private int y;

    // ʹ���Զ��幹������ֵ����x y
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ������ĺ�������
    public int getX () {
        return x;
    }
    public int getY () {
        return y;
    }
}

class Circle {
    int r;

    Circle (int r) {
        this.r = r;
    }

    /* �жϵ���뾶�Ĺ�ϵ
    1: ��Բ��
    0 ��Բ��
    -1 ��԰��
     */
    public int judge (Point p) {
        // ��ȡ���������ʾ���ߵĳ��ȵ�ƽ��
        int xxyy = p.getX() * p.getX() + p.getY() * p.getY();
        // ��ȡ�뾶��ƽ��
        int rr = this.r * this.r;
        // �жϹ�ϵ
        if (xxyy > rr) {
            return 1;
        } else if (xxyy == rr) {
            return 0;
        } else {
            return -1;
        }
    }
}

public class PointDemo {
    public static void main (String[] args) {
        Point p = new Point(3, 4);
        Circle c = new Circle(6);
        System.out.println(c.judge(p));
    }
}