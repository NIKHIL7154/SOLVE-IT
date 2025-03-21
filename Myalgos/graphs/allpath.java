import java.util.ArrayList;
public class allpath {


    static class Edge {
        int src, dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static ArrayList<ArrayList<Edge>> createGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // Initialize adjacency list with empty lists
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (both ways for an undirected graph)
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            graph.get(src).add(new Edge(src, dest));
            graph.get(dest).add(new Edge(dest, src)); // Since it's undirected
        }

        return graph;
    }

    public static void printGraph(ArrayList<ArrayList<Edge>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " → ");

            for (Edge e : graph.get(i)) {
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
    }
    public static void allpath(ArrayList<ArrayList<Edge>> graph,boolean[] vis,String path,int target,int cur){

        if(cur==target){
            System.out.println(path);
            return;
        }
       
        // System.out.println(path+" at "+i);
        for(Edge e:graph.get(cur)){
            
            if(!vis[e.dest]){
                vis[e.dest]=true;
                allpath(graph, vis, path+e.dest, target,e.dest );
                vis[e.dest]=false;
            }
            
        }
    }

    public static void main(String[] args) {
        int n = 7; // Number of nodes (0 to 6)
        int[][] edges = {
            {0, 1}, {1, 3}, {3, 5},
            {0, 2}, {2, 4}, {4, 5}, {5, 6},
            {3, 4}
        };

        // Create the graph
        ArrayList<ArrayList<Edge>> graph = createGraph(n, edges);
        boolean[] vis=new boolean[graph.size()];
        vis[0]=true;
        allpath(graph, vis,  "0", 6, 0);
        // Print adjacency list
        // System.out.println("Adjacency List Representation:");
        // printGraph(graph);
    }
}


