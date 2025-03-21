import java.util.*;

public class DisconnectedGraph {
    static class Edge{
        private int src,dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void bfstraversal(ArrayList<Edge>[] graph,boolean[] vis,int start) {
        Queue<Integer> queue = new LinkedList<>();
        

        queue.add(start);
        vis[start] = true; // Mark as visited immediately

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            System.out.print(cur + " ");

            for (Edge e : graph[cur]) {
                if (!vis[e.dest]) {
                    queue.add(e.dest);
                    vis[e.dest] = true; // Mark as visited when enqueued
                }
            }
        }
    }
    public static void main(String[] args) {
         ArrayList<Edge>[] graph = new ArrayList[6];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                bfstraversal(graph, vis,i);
            }
            
        }

    }
}
