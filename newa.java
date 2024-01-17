package AIML;

import java.util.*;

public class newa {

    class Graph {
        private Map<Character, List<Pair<Character, Integer>>> adjacencyList;

        public Graph(Map<Character, List<Pair<Character, Integer>>> adjacencyList) {
            this.adjacencyList = adjacencyList;
        }

        public List<Pair<Character, Integer>> getNeighbors(Character v) {
            return adjacencyList.getOrDefault(v, new ArrayList<>());
        }

        public int h(Character n) {
            Map<Character, Integer> H = Map.of('A', 1, 'B', 1, 'C', 1, 'D', 1);
            return H.getOrDefault(n, 0);
        }

        public List<Character> aStarAlgorithm(Character startNode, Character stopNode) {
            Set<Character> openList = new HashSet<>();
            Set<Character> closedList = new HashSet<>();

            openList.add(startNode);

            Map<Character, Integer> g = new HashMap<>();
            g.put(startNode, 0);

            Map<Character, Character> parents = new HashMap<>();
            parents.put(startNode, startNode);

            while (!openList.isEmpty()) {
                Character n = null;

                for (Character v : openList) {
                    if (n == null || g.getOrDefault(v, 0) + h(v) < g.getOrDefault(n, 0) + h(n)) {
                        n = v;
                    }
                }

                if (n == null) {
                    System.out.println("Path does not exist!");
                    return null;
                }

                if (n.equals(stopNode)) {
                    List<Character> reconstPath = new ArrayList<>();

                    while (!parents.get(n).equals(n)) {
                        reconstPath.add(n);
                        n = parents.get(n);
                    }

                    reconstPath.add(startNode);

                    Collections.reverse(reconstPath);

                    System.out.println("Path found: " + reconstPath);
                    return reconstPath;
                }

                for (Pair<Character, Integer> pair : getNeighbors(n)) {
                    Character m = pair.getKey();
                    Integer weight = pair.getValue();

                    if (!openList.contains(m) && !closedList.contains(m)) {
                        openList.add(m);
                        parents.put(m, n);
                        g.put(m, g.getOrDefault(n, 0) + weight);
                    } else {
                        if (g.getOrDefault(m, 0) > g.getOrDefault(n, 0) + weight) {
                            g.put(m, g.getOrDefault(n, 0) + weight);
                            parents.put(m, n);

                            if (closedList.contains(m)) {
                                closedList.remove(m);
                                openList.add(m);
                            }
                        }
                    }
                }

                openList.remove(n);
                closedList.add(n);
            }

            System.out.println("Path does not exist!");
            return null;
        }

        public static void main(String[] args) {
            Map<Character, List<Pair<Character, Integer>>> adjacencyList = new HashMap<>();
            adjacencyList.put('A', Arrays.asList(new Pair<>('B', 1), new Pair<>('C', 3), new Pair<>('D', 7)));
            adjacencyList.put('B', Arrays.asList(new Pair<>('D', 5)));
            adjacencyList.put('C', Arrays.asList(new Pair<>('D', 12)));

            Graph graph = new Graph(adjacencyList);

            Character startNode = 'A';
            Character stopNode = 'D';

            List<Character> result = graph.aStarAlgorithm(startNode, stopNode);

            if (result != null) {
                System.out.println(Arrays.toString(result.toArray()));
            }
        }

        static class Pair<K, V> {
            private K key;
            private V value;

            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }
    }

}
