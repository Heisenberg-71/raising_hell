

public class Insertion_sort {
     static int[] insertionSort(int[] arr,int n){

        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key ) {
                arr[j+1]=arr[j];
                j-=1;
            }
            arr[j+1]=key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={7,34,12,43,76,89,32,65,90,11,45,2,0};
        System.out.println("Original array:");
        for (int n:arr){
            System.out.print(n+" ");
        }
        System.out.println();
        arr=insertionSort(arr,arr.length);
        System.out.println("Sorted array:");
        for (int n:arr){
            System.out.print(n+" ");
        }
        System.out.println();

    }
}