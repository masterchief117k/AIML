package Assingment_11;

public class bubblesortpractice {
    public static void bubblesort(int arr[] , int size){
         for(int i =0 ; i<size ; i++){
         for(int j = 0 ; j< size-1-i;j++){
           if( arr[j]<arr[j+1]){
            int temp =arr[j];
            arr[i]=arr[j+1];
            arr[j+1]=temp;
           }
         }
         }
    }
    public static void main(String[]args){
       int arr [] = new int[] {34,65,87,23,87,324,87,23,3};
       bubblesort(arr, arr.length);
       for(int i =0 ; i<arr.length;i++){
        System.out.println(arr[i]);
       }
    }
}
