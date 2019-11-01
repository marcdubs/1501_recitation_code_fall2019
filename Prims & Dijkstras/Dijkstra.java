public class Dijkstra {
    private Edge[] edgeTo; //Shortest edge from tree vertex to non-tree vertex
    private double[] distTo;      // distTo[v] = weight of shortest such edge
    private boolean[] marked;     // marked[v] = true if v on tree, false otherwise
    private IndexMinPQ<Double> pq;

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public Dijkstra(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        dijkstra(G, 0);
    }

    // run Prim's algorithm in graph G, starting from vertex s
    private void dijkstra(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    // scan vertex v
    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;         // v-w is obsolete edge
            if (e.weight() + distTo[v] < distTo[w]) {
                distTo[w] = e.weight() + distTo[v];
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < edgeTo.length; i++) {
            Edge e = edgeTo[i];
            if(e == null)
            continue;
            int v1 = e.either();
            int v2 = e.other(v1);
            int via = v1;
            if(v1 == i) {
                via = v2;
            }
            double dist = distTo[i];
            s += "Best way to " + i + " is via " + via + " with a distance of " + dist + ".\n";
        }
        return s;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(5);
        graph.addEdge(new Edge(0, 1, 500));
        graph.addEdge(new Edge(0, 2, 3));
        graph.addEdge(new Edge(2, 4, 5));
        graph.addEdge(new Edge(3, 2, 1));
        graph.addEdge(new Edge(3, 1, 7));
        graph.addEdge(new Edge(0, 3, 4));
        Dijkstra p = new Dijkstra(graph);
        System.out.println(p);
        System.out.println("------------");
        graph = new EdgeWeightedGraph(5);
        graph.addEdge(new Edge(0, 1, 1));
        graph.addEdge(new Edge(1, 2, 1));
        graph.addEdge(new Edge(2, 3, 1));
        graph.addEdge(new Edge(3, 4, 1));
        graph.addEdge(new Edge(0, 4, 2));
        p = new Dijkstra(graph);
        System.out.println(p);
    }
}