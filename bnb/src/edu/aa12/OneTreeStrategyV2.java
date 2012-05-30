package edu.aa12;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Philip Pickering <pgpick@gmx.at>
 * Date: 5/30/12
 * Time: 4:06 PM
 *
 * strategy: OTS with lowerBound() = kruskal.mst + one-tree-vertex-edges
 *
 * consider only last decision for mst
 * choose ot-vertex s.t. it's not in prev decisions
 */
public class OneTreeStrategyV2 extends OneTreeStrategy {
    @Override
    public double lowerBound(Graph graph, BnBNode node) {
        int one = 0;
        while (isInDecTree(one, node) && one < graph.getVertices() - 1) {
            one++;
        }

        BnBNode n = new BnBNode(null, null, false);
        n = new BnBNode(n, node.edge, node.edgeIncluded);
        List<Edge> edges = new LinkedList<Edge>(graph.incidentEdges[one]);

        for (Edge e : edges) {
            n = new BnBNode(n, e, false);
        }


        List<Edge> mst = kruskal.minimumSpanningTree(graph, n);

        mst.add(popMin(edges));
        mst.add(popMin(edges));

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

    OneTreeStrategyV2(Graph g) {
        super(g);
    }
}
