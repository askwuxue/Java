class Person {
    String name;
    int age;

    // 自定义的构造器
    Person (String n, int a) {
        name = n;
        age = a;
    }

    // static 属于类 不属于对象 访问应该借助类名访问 而不是对象 即使是对象访问static属性成员 底层也是类访问的
    static int totalPerson = 5;

    // 人类死亡是整个人类的特性 不是某一个对象的特性 属于类
    static void die () {
        totalPerson--;
        System.out.println("死亡....");
    }

    // 人类灭亡
    static void destory () {
        totalPerson = 0;
        System.out.println("人类灭亡....");
    }

    // 属于对象的方法
    void live () {
        System.out.println("人要生活....");
    }
}




public class PersonDemo {
    public static void main (String[] args) {
        System.out.println("属于类的static: " + Person.totalPerson);
        Person p1 = new Person("askwuxue", 18);
        p1.live();
        Person.die();
        Person.destory();
        // Person.live();  非static 不能使用 类访问
        System.out.println(Person.totalPerson);
    }
}