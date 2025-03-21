import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyL {
    static class Edge {
        private int src, dest,weight;
        public Edge(int src, int dest,int weight) {
            this.src = src;
            this.dest = dest;
            this.weight=weight;
        }
    }
    public static void mst(String[] ans,int i,ArrayList<Edge>[] graph,int sum,boolean[] vis,String path){
        if(i>=graph.length){
            if(sum<Integer.parseInt(ans[0])){
                ans[0]=Integer.toString(sum);
                ans[1]=path;
                System.out.println("Heheh");
            }
            return;
        }

        vis[i]=true;
        
        for(Edge e:graph[i]){
            if(!vis[e.dest]){
                mst(ans, i+1, graph, sum+e.weight, vis, path+Integer.toString(i)+Integer.toString(e.dest));
            }
        }
        vis[i]=false;

    }

    public static void main(String[] args) {
        // Correct way to declare an array of ArrayLists
        @SuppressWarnings("unchecked") // To suppress generic array creation warning
        ArrayList<Edge>[] graph = new ArrayList[3];

        // Initialize each list
        for (int i = 0; i < 3; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        graph[0].add(new Edge(0, 1,4));
        graph[0].add(new Edge(0, 2,5));
        graph[1].add(new Edge(1, 2,2));
        graph[1].add(new Edge(1, 0,4));
        graph[2].add(new Edge(2, 0,5)); // Uncommenting this is fine
        graph[2].add(new Edge(2, 1,2));
        String[] ans={"755",""};
        boolean[] vis=new boolean[3];
        mst(ans, 0, graph, 0, vis,"");
        System.out.println(graph.length);
        System.out.println(Arrays.toString(ans));
        
    }
    
}

