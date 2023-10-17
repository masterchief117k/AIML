package binaryheap;

public class heap {
    void builtheap(int arr[] , int size){
        int i = size/2;
        for(;i>=0;i--){
            heapify(arr,i,size);
        }
    }
    void heapify(int arr[] ,int index, int size){
        int left=2*index+1;
        int right = left+1;
        int max = index;
        if(left<=size && arr[left]>arr[max]){
            max = left;
        }
        if(right<=size&& arr[right]>arr[max]){
            max = right;
        }
        if(index!=max){
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            heapify(arr, max, size);
        }
    }

    void sortheap(int arr[] , int size){
        builtheap(arr, size);
        while(size>0){
            int t = arr[0];
            arr[0]=arr[size];
            arr[size]=t;
            size --;
            heapify(arr, 0, size);
        }
    }

    void print(int arr[], int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
    public static void main(String[]args){
        heap h = new heap();  
        int arr[]={32,22,43,54,65,76,11};
        System.out.println("The entered heap is ");
        h.print(arr,arr.length);
        System.out.println("The heap is "); 
        h.builtheap(arr, arr.length-1);
        h.sortheap(arr, arr.length-1); 
        
        h.print(arr,arr.length);  
    }
}
