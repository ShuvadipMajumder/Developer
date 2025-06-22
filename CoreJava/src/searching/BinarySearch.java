package searching;

import java.util.Arrays; // Required for sorting the array

public class BinarySearch {

    //Performs a binary search on a sorted array to find the target element.

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            if (arr[mid] == target) {
                return mid; // Target found, return its index
            } else if (arr[mid] < target) {
                left = mid + 1; // Target is in the right half, adjust 'left' pointer
            } else {
                right = mid - 1; // Target is in the left half, adjust 'right' pointer
            }
        }
        return -1; // Target not found in the array
    }

    public static void main(String[] args) {
        int[] numbers = {10, 5, 20, 15, 25, 30}; // Unsorted array

        // Binary search requires a sorted array
        Arrays.sort(numbers); // Sort the array in ascending order
        System.out.println("Sorted Array: " + Arrays.toString(numbers)); // Print the sorted array

        int target1 = 20;
        int result1 = binarySearch(numbers, target1);
        if (result1 != -1) {
            System.out.println("Target " + target1 + " found at index: " + result1);
        } else {
            System.out.println("Target " + target1 + " not found in the array.");
        }
    }
}
