class Servent {
    String name;
    int age;

    void shopping () {
        System.out.println("Âò²Ë.....");
    };

    void cook () {
        System.out.println("×ö·¹.....");
    };
 };

 class Cooder {
     void cooding () {
         System.out.println("³ÌÐòÔ±ÇÃ´úÂë");
     }
 };

public class PersonDemo {
    public static void main (String[] args) {
        Servent s = new Servent();
        s.name = "·ÆÓ¶";
        s.age = 20;
        s.shopping ();
        s.cook();
        Cooder cod = new Cooder();
        cod.cooding();
    }
}