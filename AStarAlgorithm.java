package hashtable;
import java.util.*;

class Node implements Comparable<Node> {
    int row, col;
    int g, h, f;
    Node parent;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
        this.g = 0;
        this.h = 0;
        this.f = 0;
        this.parent = null;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.f, other.f);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return row == node.row && col == node.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

public class AStarAlgorithm {
    private static int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0}
    };

    private static int numRows = grid.length;
    private static int numCols = grid[0].length;

    public static void main(String[] args) {
        Node startNode = new Node(0, 0);
        Node goalNode = new Node(numRows - 1, numCols - 1);

        List<Node> path = astar(startNode, goalNode);

        if (path != null) {
            System.out.println("Shortest Path:");
            for (Node node : path) {
                System.out.println("(" + node.row + ", " + node.col + ")");
            }
        } else {
            System.out.println("No path found!");
        }
    }

    private static List<Node> astar(Node start, Node goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Set<Node> closedSet = new HashSet<>();

        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(goal)) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (Node neighbor : getNeighbors(current)) {
                if (closedSet.contains(neighbor) || grid[neighbor.row][neighbor.col] == 1) {
                    continue;  // Ignore obstacles and already evaluated nodes
                }

                int tentativeG = current.g + 1;

                if (!openSet.contains(neighbor) || tentativeG < neighbor.g) {
                    neighbor.g = tentativeG;
                    neighbor.h = heuristic(neighbor, goal);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = current;

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    private static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();

        while (current != null) {
            path.add(current);
            current = current.parent;
        }

        Collections.reverse(path);
        return path;
    }

    private static int heuristic(Node a, Node b) {
        // Manhattan distance heuristic
        return Math.abs(a.row - b.row) + Math.abs(a.col - b.col);
    }

    private static List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = node.row + dr[i];
            int newCol = node.col + dc[i];

            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                neighbors.add(new Node(newRow, newCol));
            }
        }

        return neighbors;
    }
}

