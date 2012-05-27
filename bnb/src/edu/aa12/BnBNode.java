package edu.aa12;

/** 
 * A node in the branch-and-bound tree.  
 */
public class BnBNode{
	public double lowerBound; 
	public final BnBNode parent;
	/** The depth in the bnb-tree*/
	public final int depth;
	/** The number of edges defined on the path to the root */
	public final int edgesDefined;
	public final Edge edge;
	/** True if <code>edge</code> is included, false otherwise. */
	public final boolean edgeIncluded;
	
	public BnBNode(BnBNode parent, Edge edge, boolean edgeIncluded){
		this.parent = parent;
		this.depth = (parent==null)?0:(parent.depth+1);
		int edgeInc = edgeIncluded?1:0;
		this.edgesDefined = (parent==null)?(edgeInc):(parent.edgesDefined+edgeInc);
		
		this.edge = edge;
		this.edgeIncluded = edgeIncluded;
	}

	/** Return a string-representation of a node. Convenient for debugging. */
	public String toString(){
		if(parent==null) return "";
		String spaces = "";
		
		for(int i=0;i<depth;i++) spaces+=" ";
		return parent.toString()+"\n"+spaces+String.format("BnBNode[%s,%b]",edge.toString(),edgeIncluded);
	}
}
