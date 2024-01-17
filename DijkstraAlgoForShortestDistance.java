package AIML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraAlgoForShortestDistance {

    static class Node implements Comparable<Node> {
        int v, distance;

        public Node(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.distance, n.distance);
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        boolean[] visited = new boolean[V];
        HashMap<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> q = new PriorityQueue<>();

        map.put(S, new Node(S, 0));
        q.add(new Node(S, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();
            int v = n.v, distance = n.distance;
            visited[v] = true;

            for (ArrayList<Integer> adjLink : adj.get(v)) {
                int neighbor = adjLink.get(0), weight = adjLink.get(1);

                if (!visited[neighbor]) {
                    int newDistance = distance + weight;

                    if (!map.containsKey(neighbor) || newDistance < map.get(neighbor).distance) {
                        map.put(neighbor, new Node(v, newDistance));
                        q.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        return map.values().stream().mapToInt(node -> node.distance).toArray();
    }

    public static void main(String[] args) {
        int V = 6;
        int E = 5;
        int[] u = {0, 0, 1, 2, 4};
        int[] v = {3, 5, 4, 5, 5};
        int[] w = {9, 4, 4, 10, 3};

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            adj.get(u[i]).add(new ArrayList<>(Arrays.asList(v[i], w[i])));
            adj.get(v[i]).add(new ArrayList<>(Arrays.asList(u[i], w[i])));
        }

        int S = 1;

        int[] result = dijkstra(V, adj, S);
        System.out.println(Arrays.toString(result));
    }
}

