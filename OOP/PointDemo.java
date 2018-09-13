class Point {
    private int x;
    private int y;

    // 使用自定义构造器赋值给点x y
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 导出点的横纵坐标
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

    /* 判断点与半径的关系
    1: 在圆外
    0 在圆上
    -1 在园内
     */
    public int judge (Point p) {
        // 获取横纵坐标表示的线的长度的平方
        int xxyy = p.getX() * p.getX() + p.getY() * p.getY();
        // 获取半径的平凡
        int rr = this.r * this.r;
        // 判断关系
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