package edu.aa12;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Author: Philip Pickering <pgpick@gmx.at>
 * Date: 5/30/12
 * Time: 4:06 PM
 *
 * strategy: OTS with lowerBound() = kruskal.mst + decisions + one-tree-vertex-edges
 *
 * choosing the vertex for one-tree randomly
 *
 * use all prev decisions for mst
 * choose ot-vertex, s.t. it's not in previous decisions if possible
 *
 */
public class OneTreeStrategyV5 extends OneTreeStrategy {

    Random rand;
    @Override
    public double lowerBound(Graph graph, BnBNode node) {

        int v = graph.getVertices();
        int one = Math.abs(rand.nextInt())%v;
        //System.out.println(one);
        int cnt = 0;

        if (node.edgesDefined <= 2*(v/3)) {
            while (isInDecTree(one, node) && cnt < 100) {
                one = Math.abs(rand.nextInt())%v;
                cnt ++;
            }
        } else {
            while(isInDecTree(one, node) && cnt < v)    {
                one = (one+1) % v;
                cnt++;
            }
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

    OneTreeStrategyV5(Graph g) {
        super(g);
        rand = new Random();
    }
}
