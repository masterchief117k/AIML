package Assingment_11;

public class bubblesort {
    public static void bubblesort(int arr[]){
        int n = arr.length;  
        for(int i=0 ; i<n-1 ; i++){
           for (int j=0;j<n-1-i; j++){
            if(arr[j]>arr[j+1]){
                int  t = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = t;
            }
           }
          }
    }
    public static void main(String[] args){
        int arr [] = new int [] {1,56,76,45,34,23};
        bubblesort(arr);
        for(int i=0 ; i<arr.length ; i++){
            System.out.println(arr[i]);
        }
        
    }
}
