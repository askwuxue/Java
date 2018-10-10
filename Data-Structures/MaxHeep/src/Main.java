import java.util.Random;
public class Main {

    private static double testHeap (Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeep<Integer> maxHeep;
        if (isHeapify) {
            maxHeep = new MaxHeep<>(testData);
        } else {
            maxHeep = new MaxHeep<>();
            for(int num: testData) {
                maxHeep.add(num);
            }
        }

        int arr[] = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeep.extractMax();
        }
        System.out.println("test");
        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeep completed");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
	// write your code here


        int n = 1000000;
//        MaxHeep<Integer> maxheep = new MaxHeep<>();
        Random random = new Random();

        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");
        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");



//        for (int i = 0; i < n; i++) {
//            maxheep.add(random.nextInt(Integer.MAX_VALUE));
//        }
//        int arr[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxheep.extractMax();
//        }
//        System.out.println("test");
//        for (int i = 1; i < n; i++) {
//            if (arr[i - 1] < arr[i]) {
//                throw new IllegalArgumentException("Error");
//            }
//        }
//        System.out.println("Test MaxHeep completed");
    }
}
