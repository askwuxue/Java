public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer> linkedlist = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedlist.addFirst(i);
            System.out.println(linkedlist);
        }

        linkedlist.add(5, 6);
        System.out.println(linkedlist);

        linkedlist.remove(1);
        System.out.println(linkedlist);

        linkedlist.removeFirst();
        System.out.println(linkedlist);
    }
}
