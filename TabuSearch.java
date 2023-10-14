import java.util.ArrayList;
import java.util.List;
 
public class TabuSearch {

    public static int objectiveFunction(List<Integer> solution) {
      
        return solution.stream().mapToInt(Integer::intValue).sum();
    }
 
   
    public static List<List<Integer>> getNeighbors(List<Integer> solution) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < solution.size(); i++) {
            for (int j = i + 1; j < solution.size(); j++) {
                List<Integer> neighbor = new ArrayList<>(solution);
             
                int temp = neighbor.get(i);
                neighbor.set(i, neighbor.get(j));
                neighbor.set(j, temp);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }
 
 
    public static List<Integer> tabuSearch(List<Integer> initialSolution, 
                                           int maxIterations, int tabuListSize) {
        List<Integer> bestSolution = new ArrayList<>(initialSolution);
        List<Integer> currentSolution = new ArrayList<>(initialSolution);
        List<List<Integer>> tabuList = new ArrayList<>();
 
        for (int iter = 0; iter < maxIterations; iter++) {
            List<List<Integer>> neighbors = getNeighbors(currentSolution);
            List<Integer> bestNeighbor = new ArrayList<>();
            int bestNeighborFitness = Integer.MAX_VALUE;
 
            for (List<Integer> neighbor : neighbors) {
                if (!tabuList.contains(neighbor)) {
                    int neighborFitness = objectiveFunction(neighbor);
                    if (neighborFitness < bestNeighborFitness) {
                        bestNeighbor = new ArrayList<>(neighbor);
                        bestNeighborFitness = neighborFitness;
                    }
                }
            }
 
            if (bestNeighbor.isEmpty()) {
         
                break;
            }
 
            currentSolution = new ArrayList<>(bestNeighbor);
            tabuList.add(bestNeighbor);
 
            if (tabuList.size() > tabuListSize) {
          
                tabuList.remove(0);
            }
 
            if (objectiveFunction(bestNeighbor) < objectiveFunction(bestSolution)) {
       
                bestSolution = new ArrayList<>(bestNeighbor);
            }
        }
 
        return bestSolution;
    }
 
    public static void main(String[] args) {
   
        List<Integer> initialSolution = List.of(1, 2, 3, 4, 5);
        int maxIterations = 100;
        int tabuListSize = 10;
 
        List<Integer> bestSolution = 
          tabuSearch(initialSolution, maxIterations, tabuListSize);
        System.out.print("Best solution:");
        for (int val : bestSolution) {
            System.out.print(" " + val);
        }
        System.out.println();
        System.out.println("Best solution fitness: " + objectiveFunction(bestSolution));
    }
}