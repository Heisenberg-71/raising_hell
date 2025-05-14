public class BinarySearch {

    // Recursive Binary Search
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: Not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right); // Search right half
        } else {
            return binarySearch(arr, target, left, mid - 1); // Search left half
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 56;

        int result = binarySearch(arr, target, 0, arr.length - 1);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}