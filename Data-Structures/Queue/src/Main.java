public class Main {

    public static void main(String[] args) {
	// write your code here
       LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10 ; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 0) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
