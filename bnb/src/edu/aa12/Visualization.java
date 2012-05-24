package edu.aa12;

import java.awt.Color;
import java.util.List;

import ProGAL.geom2d.Circle;
import ProGAL.geom2d.LineSegment;
import ProGAL.geom2d.Point;
import ProGAL.geom2d.viewer.J2DScene;
import ProGAL.geom2d.viewer.TextShape;


/** 
 * Class for visualizing solutions. Requires ProGAL (www.diku.dk/~rfonseca/ProGAL) to be in the class-path. 
 */
public class Visualization {
	
	public static void main(String[] args){
		Graph g = new Instance2();
		
		visualizeSolution(g, new BranchAndBound_TSP(g).solve());
		
//		BnBNode n = new BnBNode(null,null,false);
//		n = new BnBNode(n,new Edge(7,10), false);
//		n = new BnBNode(n,new Edge(2,3), true);
//		n = new BnBNode(n,new Edge(4,5), true);
//		n = new BnBNode(n,new Edge(3,4), false);
//		n = new BnBNode(n,new Edge(1,8), false);
//		visualizeMST(g,n);
		
	}
	
	public static void visualizeSolution(Graph g, BnBNode n){
		J2DScene scene = J2DScene.createJ2DSceneInFrame();
		for(Edge e: g.edges){
			scene.addShape(new LineSegment(new Point(g.vertexCoords[e.u]), new Point(g.vertexCoords[e.v])), new Color(180,180,180));
			
		}
		while(n.parent!=null) {
			if(n.edgeIncluded){
				scene.addShape(new LineSegment(new Point(g.vertexCoords[n.edge.u]), new Point(g.vertexCoords[n.edge.v])), Color.BLACK, 0.03);
			}
			n=n.parent;
		}
		int i=0;
		for(double[] coords: g.vertexCoords){
			scene.addShape(new Circle(new Point(coords), 0.1));
			scene.addShape(new TextShape(""+(i++), new Point(coords), 0.1), Color.BLACK);
		}
	}
	
	
	public static void visualizeMST(Graph g, BnBNode n){
		List<Edge> edges = new Kruskal().minimumSpanningTree(g, n);

		J2DScene scene = J2DScene.createJ2DSceneInFrame();
		int i=0;
		while(n.parent!=null){
			Edge e = n.edge;
			if(n.edgeIncluded){
				scene.addShape(new LineSegment(new Point(g.vertexCoords[e.u]), new Point(g.vertexCoords[e.v])),java.awt.Color.GREEN, 0.05);
			}else{
				scene.addShape(new LineSegment(new Point(g.vertexCoords[e.u]), new Point(g.vertexCoords[e.v])),java.awt.Color.RED, 0.05);
			}
			n=n.parent;
		}
		for(Edge e: edges){
			scene.addShape(new LineSegment(new Point(g.vertexCoords[e.u]), new Point(g.vertexCoords[e.v])));
		}
		for(double[] coords: g.vertexCoords){
			scene.addShape(new Circle(new Point(coords), 0.1));
			scene.addShape(new TextShape(""+(i++), new Point(coords), 0.1));
		}
	}
}
