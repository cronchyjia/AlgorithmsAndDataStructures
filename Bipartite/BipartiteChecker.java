//226 Lab 5 June 2023

//This java file contains a template for a bipartite checker.
//Your task is to complete the code, and test your solution using the testing harness in main().
import java.util.*;

public class BipartiteChecker {
    /**
     * Checks whether or not a graph is bipartite using a modified BFS.
     * Run time requirement: O(v+e)
     * Space requirement: O(v)
     * @param graph the graph G, represented as an adjacency list
     * @return whether G is bipartite
     */
    public static boolean isBipartite(List<List<Integer>> graph) {

        //TODO: edge cases, exception handling
       
        //TODO: initialize data structures 

        //TODO: implement BFS
		
        //TODO: modify BFS

        int[] colour = new int[graph.size()];
		
		if(graph.size() == 0){
			return false;
		}
		
        for(int i = 0; i < graph.size(); i++){
            if(colour[i] != 0){
                continue;
            }
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            colour[i] = 1;
            
            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int x : graph.get(cur)){
                    if(colour[x] == 0){
                        colour[x] =- colour[cur];
                        queue.add(x);
                    }
                    else if(colour[x] != -colour[cur]){
                        return false;
                    }
                }
            }
        }
        return true;
    } 


    public static void main(String[] args) {
        // Empty graph - F
        List<List<Integer>> graph = new ArrayList<>();
        
        boolean isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The empty graph is bipartite.");
        } else {
            System.out.println("The empty graph is not bipartite.");
        }

        // Single vertex - T
        graph = new ArrayList<>();
        graph.add(Arrays.asList());

        isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The single vertex graph is bipartite.");
        } else {
            System.out.println("The single vertex is not bipartite.");
        }
        
        // Line graph - T
        graph = new ArrayList<>();
        graph.add(Arrays.asList(1));
        graph.add(Arrays.asList(0,2));
        graph.add(Arrays.asList(1));

        isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The line graph is bipartite.");
        } else {
            System.out.println("The line graph is not bipartite.");
        }

        // Square graph - T
        graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 3));
        graph.add(Arrays.asList(0, 2));
        graph.add(Arrays.asList(1, 3));
        graph.add(Arrays.asList(0, 2));

        isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The square graph is bipartite.");
        } else {
            System.out.println("The square graph is not bipartite.");
        }

        // Fully connected bipartite graph - T
        graph = new ArrayList<>();
        graph.add(Arrays.asList(3, 4, 5, 6));
        graph.add(Arrays.asList(3, 4, 5, 6));
        graph.add(Arrays.asList(3, 4, 5, 6));
        graph.add(Arrays.asList(0, 1, 2));
        graph.add(Arrays.asList(0, 1, 2));
        graph.add(Arrays.asList(0, 1, 2));
        graph.add(Arrays.asList(0, 1, 2));

        isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The fully connected graph is bipartite.");
        } else {
            System.out.println("The fully connected graph is not bipartite.");
        }

        // Pentagon graph - F
        graph = new ArrayList<>();
        graph.add(Arrays.asList(1,4));
        graph.add(Arrays.asList(0,2));
        graph.add(Arrays.asList(1,3));
        graph.add(Arrays.asList(2,4));
        graph.add(Arrays.asList(0,3));

        isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The pentagon graph is bipartite.");
        } else {
            System.out.println("The pentagon graph is not bipartite.");
        }
        
        // Petersen graph - F
        graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 4, 5));
        graph.add(Arrays.asList(0, 2, 6));
        graph.add(Arrays.asList(1, 3, 7));
        graph.add(Arrays.asList(2, 4, 8));
        graph.add(Arrays.asList(0, 3, 9));
        graph.add(Arrays.asList(0, 7, 8));
        graph.add(Arrays.asList(1, 8, 9));
        graph.add(Arrays.asList(2, 5, 9));
        graph.add(Arrays.asList(3, 5, 6));
        graph.add(Arrays.asList(4, 6, 7));

        isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The Petersen graph is bipartite.");
        } else {
            System.out.println("The Petersen graph is not bipartite.");
        }

    }
}