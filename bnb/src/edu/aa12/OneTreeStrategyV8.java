package edu.aa12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Philip Pickering <pgpick@gmx.at>
 * Date: 5/30/12
 * Time: 4:06 PM
 *
 * OTS with lowerBound() = kruskal.mst + decisions + one-tree-vertex-edges
 *
 * choosing the vertex for one-tree orderd by the two min edges
 *
 * use all prev decisions for mst
 * choose ot-vertex without thinking about prev decisions
 *
 */
public class OneTreeStrategyV8 extends OneTreeStrategy {


    private int[] sortVertices;

    @Override
    public double lowerBound(Graph graph, BnBNode node) {

        int v = graph.getVertices();

        int i = 0;
        int one;

        do {
            one = sortVertices[i];
            i++;
        } while(/*isInDecTree(one, node) &&*/ i < v);



        BnBNode n = new BnBNode(null, null, false);
        n = new BnBNode(node.parent, node.edge, node.edgeIncluded);
        List<Edge> edges = new LinkedList<Edge>(graph.incidentEdges[one]);

        for (Edge e : edges) {
            n = new BnBNode(n, e, false);
        }


        List<Edge> mst = kruskal.minimumSpanningTree(graph, n);

        mst.add(popMin(edges));
        mst.add(popMin(edges));

        BnBNode adds = n;


        // DON'T forget to add the nodes, which mst didn't add, again
        while (adds.parent != null) {
            if (adds.edgeIncluded
                  && (adds.edge.u != one) && adds.edge.v != one // STUPID edge-case: if some edge to the last should have been added, but one-tree says "no"
            ) {
                mst.add(adds.edge);
            }
            adds = adds.parent;
        }
        //System.out.println(cost(mst));
        return cost(mst);
    }

    public boolean isInDecTree(int one, BnBNode node) {
        BnBNode n = node;
        while (n.parent != null) {
            if (n.edge.u == one || n.edge.v == one) return true;
            n = n.parent;
        }

        return false;

    }

    OneTreeStrategyV8(Graph g) {
        super(g);
        
        sortVertices = new int[graph.getVertices()];
        double  []sumMinDist = new double[graph.getVertices()];
        
        for (int i = 0; i < graph.getVertices(); i++) {
            List<Edge> eds = new ArrayList<Edge>(graph.incidentEdges[i]);
            Edge min = popMin(eds);
            sumMinDist[i] = graph.getDistance(min.u, min.v);
            min = popMin(eds);
            sumMinDist[i]+=graph.getDistance(min.u, min.v);
        }

        for (int i = 0; i < graph.getVertices(); i++) {
            int max = 0;
            for (int j = 0; j < graph.getVertices(); j++) {
                if (sumMinDist[j] > sumMinDist[max])
                    max = j;
            }
            sortVertices[i] = max;
            sumMinDist[i] = 0;

        }
    }
}
