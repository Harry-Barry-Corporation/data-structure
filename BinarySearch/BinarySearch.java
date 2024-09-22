package BinarySearch;

public class BinarySearch {
    // Binary search method
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not present in array
        return -1;
    }

    // Main method with sample data
    public static void main(String[] args) {
        int[] sampleArray = { 1, 5, 7, 10 };
        int target1 = 12;
        int target2 = 7;

        int result1 = binarySearch(sampleArray, target1);
        int result2 = binarySearch(sampleArray, target2);

        System.out.println("Sample array: " + java.util.Arrays.toString(sampleArray));

        if (result1 != -1) {
            System.out.println("Target " + target1 + " found at index: " + result1);
        } else {
            System.out.println("Target " + target1 + " not found in the array");
        }

        if (result2 != -1) {
            System.out.println("Target " + target2 + " found at index: " + result2);
        } else {
            System.out.println("Target " + target2 + " not found in the array");
        }
    }
}
