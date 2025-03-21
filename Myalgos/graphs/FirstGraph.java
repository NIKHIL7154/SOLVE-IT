
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class FirstGraph {
    static class Edge{
        private int src,dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void bfstraversa(ArrayList<Edge>[] graph){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] vis=new boolean[graph.length];
        queue.add(0);
        while(!queue.isEmpty()){
            int cur=queue.remove();
            if(!vis[cur]){
                System.out.print(cur+" ");
                vis[cur]=true;
            }
            for(Edge e:graph[cur]){
                queue.add(e.dest);
            }
        }
    }
    public static void bfstraversal(ArrayList<Edge>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        queue.add(0);
        vis[0] = true; // Mark as visited immediately

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

    public static void dfss(ArrayList<Edge>[] graph){
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        boolean[] vis=new boolean[graph.length];
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(!vis[cur]){
                System.out.print(cur+" ");
                vis[cur]=true;
                for(Edge e:graph[cur]){
               
                    if (!vis[e.dest]) {
                        stack.push(e.dest);
                    }
                }
            }
            
        }
    }
    
    public static void dfs(ArrayList<Edge>[] graph){
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[graph.length];
    
        stack.push(0); // Start from node 0
    
        while (!stack.isEmpty()) {
            int cur = stack.pop();
    
            if (!vis[cur]) {
                System.out.print(cur + " "); // Process node
                vis[cur] = true;
    
                // ✅ Push neighbors in reverse order for correct DFS traversal
                for (int i = graph[cur].size() - 1; i >= 0; i--) {
                    int neighbor = graph[cur].get(i).dest;
                    if (!vis[neighbor]) {
                        stack.push(neighbor);
                    }
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
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 5));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5,2));

        bfstraversal(graph);
        // dfss(graph);
    }
}
