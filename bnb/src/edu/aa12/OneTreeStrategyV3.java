package edu.aa12;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Philip Pickering <pgpick@gmx.at>
 * Date: 5/30/12
 * Time: 4:06 PM
 *
 * strategy: OTS with lowerBound() = kruskal.mst + decisions + one-tree-vertex-edges
 *
 * use all prev decisions for mst
 * choose ot-vertex, s.t. it's not in previous decisions if possible
 *
 */
public class OneTreeStrategyV3 extends OneTreeStrategy {
    @Override
    public double lowerBound(Graph graph, BnBNode node) {

        int one = 0;
        while (isInDecTree(one, node) && one < graph.getVertices() - 1) {
            one++;
        }

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
                    && (adds.edge.u != one) && adds.edge.v != one) // STUPID edge-case: if some edge to the last should have been added, but one-tree says "no"
            {
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

    OneTreeStrategyV3(Graph g) {
        super(g);
    }
}
