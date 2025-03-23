import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GraphMethods {
    public final int vertices;
    public final List<List<Node>> adlist;

    class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public GraphMethods(int vertices) {
        this.vertices = vertices;
        adlist = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adlist.add(new ArrayList<>());
        }
    }

    public void add(int src, int dest, int weight) {
        adlist.get(src).add(new Node(dest, weight));
        adlist.get(dest).add(new Node(src, weight)); // for undirected graph
    }

    public void printGraph() {
        System.out.println("Format : 'src -> [ (src, weight) ]");
        for (int i = 0; i < adlist.size(); i++) {
            System.out.print(i + " -> [ ");
            for (Node a : adlist.get(i)) {
                System.out.print("(" + a.vertex + ", " + a.weight + ") ");
            }
            System.out.println("]");
        }
    }

    public void dijkstra() {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((node) -> node.weight));
        boolean[] visited = new boolean[vertices];
        pq.add(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.vertex]) {
                continue;
            }
            visited[cur.vertex] = true;

            for (Node neighbour : adlist.get(cur.vertex)) {
                int newDist = distance[cur.vertex] + neighbour.weight;
                if (newDist < distance[neighbour.vertex]) {
                    distance[neighbour.vertex] = newDist;
                    pq.add(new Node(neighbour.vertex, newDist));

                }
            }

        }
        System.out.println(Arrays.toString(distance));
    }

    public void primsAlgo() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((node) -> node.weight));
        boolean[] visited = new boolean[vertices];
        ArrayList<String> mst = new ArrayList<>();
        int[] keys = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(keys, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        keys[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curnode = pq.poll();
            int curvertext = curnode.vertex;

            visited[curvertext] = true;
            mst.add(parent[curvertext] + " -> " + curvertext + " cost -> " + curnode.weight);
            System.out.println(Arrays.toString(visited));
            for (Node neighbor : adlist.get(curvertext)) {
                if (!visited[neighbor.vertex] && neighbor.weight < keys[neighbor.vertex]) {
                    keys[neighbor.vertex] = neighbor.weight;
                    parent[neighbor.vertex] = curvertext;
                    pq.add(new Node(neighbor.vertex, keys[neighbor.vertex]));
                }
            }
        }
        for (String a : mst) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        GraphMethods g = new GraphMethods(5);
        g.add(0, 1, 10);
        g.add(1, 3, 4);
        g.add(3, 0, 13);
        g.add(0, 2, 12);
        g.add(2, 3, 13);
        g.add(3, 4, 5);
        g.printGraph();
        g.dijkstra();
        g.primsAlgo();
    }
}
