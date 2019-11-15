public class FordFulkerson {
    private boolean[] marked;     // marked[v] = true iff s->v path in residual graph
    private FlowEdge[] edgeTo;    // edgeTo[v] = last edge on shortest residual s->v path
    private double value;         // current value of max flow

    public FordFulkerson(FlowNetwork G, int s, int t) {
        value = 0.0;
    }

    /**
     * Returns the value of the maximum flow.
     *
     * @return the value of the maximum flow
     */
    public double value()  {
        return value;
    }

    // is there an augmenting path? 
    // if so, upon termination edgeTo[] will contain a parent-link representation of such a path
    // this implementation finds a shortest augmenting path (fewest number of edges),
    // which performs well both in theory and in practice
    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        edgeTo = new FlowEdge[G.V()];
        marked = new boolean[G.V()];
    }

    public static void main(String[] args) {
        FlowNetwork network = new FlowNetwork(5);
        network.addEdge(new FlowEdge(0, 1, 100));
        network.addEdge(new FlowEdge(1, 2, 10));
        network.addEdge(new FlowEdge(2, 3, 40));
        network.addEdge(new FlowEdge(3, 4, 80));
        network.addEdge(new FlowEdge(0, 3, 30));
        FordFulkerson ford = new FordFulkerson(network, 0, 4);
        System.out.println(ford.value());

        network = new FlowNetwork(5);
        network.addEdge(new FlowEdge(0, 1, 1000));
        network.addEdge(new FlowEdge(1, 4, 1));
        network.addEdge(new FlowEdge(1, 2, 1000));
        network.addEdge(new FlowEdge(2, 3, 1000));
        network.addEdge(new FlowEdge(3, 4, 1000));
        ford = new FordFulkerson(network, 0, 4);
        System.out.println(ford.value());
    }
}