import java.util.Random;

public class KSort {
    private SortingAlgorithm sa;

    public KSort(SortingAlgorithm sa) {
        this.sa = sa;
    }

    public double kSortedSingleTest(int size) {
        int[] arr = generateKSorted(size);
        long startTime = System.nanoTime();
        sa.sorty(arr);
        long endTime = System.nanoTime();
        return ((endTime - startTime) / 1_000_000.0); // Convert nanoseconds to milliseconds
    }

    public String kSortedTest(int iterations, int size) {
        double total = 0;
        for (int i = 0; i < iterations; i++) {
            total += kSortedSingleTest(size);
        }
        double average = total / iterations;
        return ("Sorted " + size + " elements in " + average + "ms (avg)");
    }

    public static int[] generateKSorted(int size) {
        int k = 10;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = i + random.nextInt(2 * k + 1) - k;
        }
        return arr;
    }
}


