import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsDFS {
    public static void findAllPathsDFS(Map<String, List<String>> graph, String start, String end, List<String> currentPath, List<List<String>> allPaths) {
        currentPath.add(start);

        if (start.equals(end)) {
            allPaths.add(new ArrayList<>(currentPath)); // Found a path, add it to the list of all paths
        } else {
            for (String neighbor : graph.get(start)) {
                if (!currentPath.contains(neighbor)) {
                    findAllPathsDFS(graph, neighbor, end, currentPath, allPaths);
                }
            }
        }

        currentPath.remove(currentPath.size() - 1);  // Backtrack, even if it's not the destination
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", List.of("B", "C", "D"));
        graph.put("B", List.of("A", "C", "D"));
        graph.put("C", List.of("A", "B", "D"));
        graph.put("D", List.of("A", "B", "C"));

        String start = "A";
        String end = "D";

        List<String> currentPath = new ArrayList<>();
        List<List<String>> allPaths = new ArrayList<>();

        findAllPathsDFS(graph, start, end, currentPath, allPaths);

        System.out.println("All Paths from " + start + " to " + end + ":");
        for (List<String> path : allPaths) {
            System.out.println(path);
        }
    }
}
