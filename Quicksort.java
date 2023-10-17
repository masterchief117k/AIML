package Quicksort;

public class Quicksort {
    void swap(int index1, int index_2, int arr[]) {
        int temp = arr[index1];
        arr[index1] = arr[index_2];
        arr[index_2] = temp;
    }

    public int partition(int arr[], int start, int end) {
        int pindex = start;
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(i, pindex, arr);
                pindex++;
            }
        }
        swap(end, pindex, arr);
        return pindex;
    }
    void quicksort(int arr[], int start, int end){
         if(start < end){
            int pi = partition(arr, start, end);
            quicksort(arr, start, pi-1);
            quicksort(arr, pi+1, end);

         }
    }
    public static void main(String[] args){
        Quicksort qs = new Quicksort();
        int n = 5;
        int [] arr= new int[]{10,25,3,50,20};
        System.out.println("array in sorted order is ");
        qs.quicksort(arr, 0, n-1);
        for(int i = 0 ; i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }

}
