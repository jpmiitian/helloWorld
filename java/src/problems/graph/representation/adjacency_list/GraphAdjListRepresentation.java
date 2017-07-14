package problems.graph.representation.adjacency_list;

import java.util.ArrayList;

import problems.link_list.single_LL.node.ListNode;

public class GraphAdjListRepresentation {

	private ArrayList<Integer> vertices;
	private int vertexCount;
	private ListNode[] edges;
	
	
	/** Adjacency list representation of Graph */
	public GraphAdjListRepresentation(int vertexCount) {
		this.vertexCount = vertexCount;
		vertices = new ArrayList<Integer>();
		edges = new ListNode[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			vertices.add(i);
			edges[i] = new ListNode(-1);
		}
	}

	public void addEdge(int source, int destination) {
			int i = vertices.indexOf(source);
			int j = vertices.indexOf(destination);
			
			if(i!=-1 || j!=-1){
			/** DO THIS
				 edges[i].insertAtBegining(destination);
				 edges[i].insertAtBegining(source);	
			*/ 
			}
 	}
}
