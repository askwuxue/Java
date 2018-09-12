class Person {
    String name;
    int age;

    // �Զ���Ĺ�����
    Person (String n, int a) {
        name = n;
        age = a;
    }

    // static ������ �����ڶ��� ����Ӧ�ý����������� �����Ƕ��� ��ʹ�Ƕ������static���Գ�Ա �ײ�Ҳ������ʵ�
    static int totalPerson = 5;

    // ����������������������� ����ĳһ����������� ������
    static void die () {
        totalPerson--;
        System.out.println("����....");
    }

    // ��������
    static void destory () {
        totalPerson = 0;
        System.out.println("��������....");
    }

    // ���ڶ���ķ���
    void live () {
        System.out.println("��Ҫ����....");
    }
}




public class PersonDemo {
    public static void main (String[] args) {
        System.out.println("�������static: " + Person.totalPerson);
        Person p1 = new Person("askwuxue", 18);
        p1.live();
        Person.die();
        Person.destory();
        // Person.live();  ��static ����ʹ�� �����
        System.out.println(Person.totalPerson);
    }
}