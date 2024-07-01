import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SortAndSearchProgram {
    public static void main(String[] args) {
        try {
            // Read the list of items from the input file
            int[] items = readItemsFromFile("C:\\Users\\User\\Downloads\\assingment3508\\INPUT.TXT");

            // Sort the items using selection sort
            int[] selectionSortedItems = Arrays.copyOf(items, items.length);
            selectionSort(selectionSortedItems);

            System.out.println("Selection Sort:");
            displaySortIterations(selectionSortedItems);

            // Sort the items using merge sort
            int[] mergeSortedItems = Arrays.copyOf(items, items.length);
            mergeSort(mergeSortedItems);

            System.out.println("Merge Sort:");
            displaySortIterations(mergeSortedItems);

            // Prompt the user to search for an item
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an item to search: ");
            int searchItem = scanner.nextInt();

            // Perform sequential search
            int sequentialComparisons = sequentialSearch(items, searchItem);
            if (sequentialComparisons != -1) {
                System.out.println("Sequential Search:");
                System.out.println("Item found at index " + sequentialComparisons);
                System.out.println("Number of comparisons: " + sequentialComparisons);
            } else {
                System.out.println("Sequential Search:");
                System.out.println("Item not found");
                System.out.println("Number of comparisons: " + items.length);
            }

            // Perform binary search
            int binaryComparisons = binarySearch(mergeSortedItems, searchItem);
            if (binaryComparisons != -1) {
                System.out.println("Binary Search:");
                System.out.println("Item found at index " + binaryComparisons);
                System.out.println("Number of comparisons: " + binaryComparisons);
            } else {
                System.out.println("Binary Search:");
                System.out.println("Item not found");
                System.out.println("Number of comparisons: " + (int) (Math.log(items.length) / Math.log(2)));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }

    // Read the list of items from the input file
    private static int[] readItemsFromFile(String fileName) throws FileNotFoundException {
        File inputFile = new File(fileName);
        Scanner scanner = new Scanner(inputFile);

        int[] items = new int[scanner.nextInt()];
        for (int i = 0; i < items.length; i++) {
            items[i] = scanner.nextInt();
        }

        scanner.close();
        return items;
    }

    // Selection sort algorithm
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Merge sort algorithm
    private static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    // Display the sorting iterations
    private static void displaySortIterations(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, i + 1)));
        }
        System.out.println();
    }

    // Sequential search algorithm
    private static int sequentialSearch(int[] arr, int searchItem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchItem) {
                return i;
            }
        }
        return -1;
    }

    // Binary search algorithm
    private static int binarySearch(int[] arr, int searchItem) {
        int left = 0;
        int right = arr.length - 1;
        int comparisons = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            comparisons++;

            if (arr[mid] == searchItem) {
                return comparisons;
            }

            if (arr[mid] < searchItem) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}