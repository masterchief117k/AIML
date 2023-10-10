import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class simpleSearch {

    public static List<List<String>> findPaths(Map<String, Object> tree) {
        List<List<String>> paths = new ArrayList<>();
        findPathsDFS(tree, new ArrayList<>(), paths);
        return paths;
    }

    public static void findPathsDFS(Map<String, Object> node, List<String> currentPath, List<List<String>> paths) {
        for (Map.Entry<String, Object> entry : node.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            currentPath.add(key);

            if (value instanceof Map) {
                // If the value is a map (subtree), recursively search it
                findPathsDFS((Map<String, Object>) value, currentPath, paths);
            } else {
                // If the value is not a map, it's a leaf node
                // So, add the current path to the list of paths
                paths.add(new ArrayList<>(currentPath));
            }

            // Remove the last key to backtrack
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        Map<String, Object> tree = new HashMap<>();
        Map<String, Object> nodeA = new HashMap<>();
        Map<String, Object> nodeB = new HashMap<>();
        Map<String, Object> nodeC = new HashMap<>();
        Map<String, Object> nodeD = new HashMap<>();
        Map<String, Object> nodeE = new HashMap<>();
        Map<String, Object> nodeF = new HashMap<>();

        tree.put("A", nodeA);
        nodeA.put("B", nodeB);
        nodeB.put("D", nodeD);
        nodeB.put("E", nodeE);
        nodeA.put("C", nodeC);
        nodeC.put("F", nodeF);

        List<List<String>> paths = findPaths(tree);

        for (List<String> path : paths) {
            System.out.println(String.join(" -> ", path));
        }
    }
}


