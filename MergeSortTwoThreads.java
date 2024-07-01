import java.util.Arrays;
import java.util.Random;

public class MergeSortTwoThreads {

    public static void main(String[] args) throws InterruptedException {
        // Specify the data size and thread count here
        int dataSize = 1000000; // Change this to your desired data size
        int threadCount = 4; // Change this to your desired thread count

        // Generate random data
        int[] globalArray = generateRandomData(dataSize);
        
        // Start time measurement
        long startTime = System.nanoTime();
        
        // Perform parallel merge sort
        mergeSortParallel(globalArray, threadCount);
        
        // End time measurement
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        
        // Convert elapsed time to seconds
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000.0;
        System.out.println("Threads: " + threadCount+" , Data Size: "+ dataSize );
        System.out.println("Total execution time: " + elapsedTimeInSeconds+ " seconds");
        System.out.println(" ");
    }

    private static void mergeSortParallel(int[] array, int threadCount) throws InterruptedException {
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * (array.length / threadCount);
            int endIndex = (i == threadCount - 1) ? array.length - 1 : (i + 1) * (array.length / threadCount) - 1;

            threads[i] = new Thread(() -> mergeSort(array, startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // Merge the sorted subarrays
        for (int i = 1; i < threadCount; i++) {
            int mid = i * (array.length / threadCount) - 1;
            merge(array, 0, mid, (i + 1) * (array.length / threadCount) - 1);
        }
    }

    private static int[] generateRandomData(int size) {
        Random random = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        // Merge logic remains the same
        // ...
    }
}