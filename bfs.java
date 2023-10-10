import java.util.LinkedList;
import java.util.Queue;
public class bfs {
    static final int v = 5;
    public void bfss(int [][] arr, int source){
         Queue<Integer> q = new LinkedList<>();
         boolean isVisited [] = new boolean[v];
         q.add(source);
         isVisited[source]= true;
         while(q.size()!=0){
            int node = q.poll();
            System.out.println("visited node "+ node);
            for(int index=0; index<v;index++){
                if(arr[node][index]==1 && isVisited[index]==false){
                    q.add(index);
                    isVisited[index]=true;
                    System.out.println(arr[node][index]);
                }
            }
         }
    }
    public static void main(String[] args) {
        int arr[][]={ 
        {0, 1, 1, 1, 0},
        {1, 0, 0, 1, 1},
        {1, 0, 0, 1, 0},
        {1, 1, 1, 0, 1},
        {0, 1, 0, 1, 0}
        };
        bfs  obj = new bfs();
        System.out.println("BFS of the given graph is : ");
        obj.bfss(arr,0);
    }
}
