package binaryheap;

public class practiceh {
    void buildheap(int arr [] , int size){
       for(int i = size/2 ; i>=0 ; i--){
         heapify(arr, i , size);
       }
    }
    void heapify(int arr[], int index , int size){
      int left = (index*2)+1;
      int right = left +1;
      int max = index;
      if(left<=size && arr[left]>arr[max]){
       max =left;
      }
      if(right <=size && arr[right]>arr[max]){
        max = right;
      }
      if(index != max){
        int temp = arr[max];
        arr[max] = arr[index];
        arr[index] = temp;
       heapify(arr, max, size);
      }

    }
   
    public int  delete(int arr[] , int size){
      int temp = arr[0];
      arr[0] = arr[size-1];
      arr[size-1] = temp;
       size--;
       heapify(arr, 0, size);
      return size;
    }
    void display(int arr [] , int size){
        for (int i =0 ; i<size ; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String [] args){
         practiceh h = new  practiceh();
         int arr [] = new int[] {23,43,54,12,33,2,1,3};
         h.buildheap(arr, arr.length-1);
         h.display(arr, arr.length);
         h.delete(arr, arr.length);
         h.display(arr,  h.delete(arr, arr.length-1));
    }
}
