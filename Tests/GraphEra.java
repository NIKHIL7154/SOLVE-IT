import java.util.*;

public class GraphEra {
    private Map<Integer, List<Integer>> adjList;

    public GraphEra() {
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // For undirected graph
        
    }

    public List<Integer> getAdjVertices(int vertex) {
        return adjList.get(vertex);
    }

    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (int adjVertex : adjList.get(vertex)) {
                System.out.print(adjVertex + " ");
            }
            System.out.println();
        }
    }

    public 

    public static void main(String[] args) {
        GraphEra graph = new GraphEra();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.printGraph();
    }
}