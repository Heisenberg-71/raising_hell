//Algorithm Overview
//Quick sort is a divide-and-conquer algorithm that works as follows:
//Choose a pivot element from the array
//Partition the array:
//Elements smaller than pivot go to its left
//Elements greater than pivot go to its right
//Recursively apply the same process to the left and right sub-arrays

public class QuickSort {
    static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pivotindex=partition(arr,low,high);
            quickSort(arr,low,pivotindex-1);
            quickSort(arr,pivotindex+1,high);
        }

    }

    static int partition(int[] arr, int low, int high) {
        int i=low-1;
        int pivot=arr[high];
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;

                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }



     static void printArray(int[] arr) {
        for (int n:arr){
            System.out.print(n+" ");
        }
         System.out.println();
    }
}