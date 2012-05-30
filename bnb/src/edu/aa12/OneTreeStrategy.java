package edu.aa12;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Philip Pickering <pgpick@gmx.at>
 * Date: 5/30/12
 * Time: 3:11 PM
 */
public class OneTreeStrategy implements ILowerBound {

    private Kruskal kruskal;
    Graph graph;
    OneTreeStrategy(Graph g) {
        kruskal = new Kruskal();
        graph = g;
    }

    @Override
    public double lowerBound(Graph graph, BnBNode node) {
        /*
        while (n.parent != null) {
            if (n.edge.u != one && n.edge.v != one) {
                news = new BnBNode(news, n.edge, n.edgeIncluded);
            }
            else {
                news = new BnBNode(news, n.edge, false);
            }
            n = n.parent;
        }*/
/*

        for (Edge e : edges) {
            news = new BnBNode(news, e, false);
        }


        List<Edge> mst = kruskal.minimumSpanningTree(graph, news);

        for (int i = 0; i < 2; i++) {
            Edge e = popMin(edges);
            if (e.equals(node.edge)) e = popMin(edges);

            mst.add(e);
        }
*/
        int one = 0;
        while (node.edge.u == one || node.edge.v == one) {
            one++;
        }

        BnBNode n = new BnBNode(null, null, false);
        n = new BnBNode(n, node.edge, node.edgeIncluded);
        List<Edge> edges = new LinkedList<Edge>(graph.incidentEdges[one]);

        for (Edge e : edges) {
            n = new BnBNode(n, e, false);
        }


        List<Edge> mst = kruskal.minimumSpanningTree(graph, n);
        //System.out.println("mst" + mst);
        mst.add(popMin(edges));
        mst.add(popMin(edges));
        //System.out.println("+++" + mst);
        //System.out.println(cost(mst));
        //System.exit(1);
		return cost(mst);
    }

    public double cost(List<Edge> edges) {
        double sum = 0;
        for (Edge e: edges) {
            sum += graph.getDistance(e.u, e.v);
        }
        //System.out.println(sum);
        return sum;
    }

    public Edge popMin(List<Edge> edges) {
        Edge min = edges.get(0);
        double minDist = graph.getDistance(min.u, min.v);
        for (Edge e: edges) {
            double dist = graph.getDistance(e.u, e.v);
            if (dist < minDist) {
                min = e;
                minDist = dist;
            }
        }
        edges.remove(min);
        return min;
    }
}
