class Servent {
    String name;
    int age;

    void shopping () {
        System.out.println("���.....");
    };

    void cook () {
        System.out.println("����.....");
    };
 };

 class Cooder {
     void cooding () {
         System.out.println("����Ա�ô���");
     }
 };

public class PersonDemo {
    public static void main (String[] args) {
        Servent s = new Servent();
        s.name = "��Ӷ";
        s.age = 20;
        s.shopping ();
        s.cook();
        Cooder cod = new Cooder();
        cod.cooding();
    }
}