package Mergesort;

public class mergsort {
    static void mergeSort(int arr [] , int start , int end){
        if(start<end){
        int mid = (start +end)/2;
        mergeSort(arr, start , mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, end, mid);
      }
    }
    static void merge(int[] arr , int start , int end, int mid){
        int temp[] = new int[end+1-start];
        int i,j,k;
        i=start;
        j=mid+1;
        k=0;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }
            else {
                temp[k]=arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            temp[k]=arr[i];
            k++;
            i++;
        }
        while(j<=end){
            temp[k]=arr[j];
            k++;
            j++;
        }
        k=0;
        for( i = start ; i<=end;i++){
          arr[i]=temp[k++];
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int arr [] = new int[]  {23,32,54,23,3,94};
        mergeSort(arr,0, n-1);
        for(int i = 0 ; i<n ; i++) {
            System.out.println(arr[i]);
        }
    }
    
}
                          