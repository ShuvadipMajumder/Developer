import java.util.Arrays;

public class InsertionSort {

    /**
     * Sorts an array of integers using the Insertion Sort algorithm in ascending order.
     *
     * @param arr The array of integers to be sorted.
     */
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // The element to be inserted
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // Place the key in its correct position
        }
    }

    public static void main(String[] args) {
        int [] data = {3, 5, 1, 7, 5, 9,2};
        InsertionSort sorter = new InsertionSort();

        System.out.println("Original Array: " + Arrays.toString(data));
        sorter.sort(data);
        System.out.println("Sorted Array (Ascending): " + Arrays.toString(data));

    }
}