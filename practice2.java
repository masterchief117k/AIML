package AIML;
import java.util.*;

public class practice2 {
    public static final int V = 5; 
   void bfs (int arr[][],int src){
     boolean visited[] = new boolean[V];
     Queue<Integer> q = new LinkedList<>();
     visited[src] = true;
     q.add(src);
     while(q.size() !=0){
        int node = q.poll();
        System.out.println(node);
        for(int i =0 ; i<V;i++){
            if(visited[i]==false && arr[node][i]==1){
                visited[i] = true;
                q.add(i);
            }
        }
     }
   }
   void dfs(int arr[][] , int src){
    boolean visited [] = new boolean[V];
    Stack<Integer> s = new Stack<>();
    s.push(src);
    visited[src]=true;
    while(!s.isEmpty()){
        int node = s.pop();
        System.out.println(node);
        for(int i =0; i<V; i++){
            if(visited[i]==false && arr[node][i]==1){
               visited[i]=true;
               s.push(i);
            }
        }
    }

   }

    public static void main(String[] args) {
        practice2 p = new practice2();
        int arr[][] = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {0, 1, 0, 1, 0} 
        };
        p.bfs(arr, 0);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        p.dfs(arr, 0);
    }
}
