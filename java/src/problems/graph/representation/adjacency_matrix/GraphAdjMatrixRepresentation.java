package problems.graph.representation.adjacency_matrix;

public class GraphAdjMatrixRepresentation {

	private boolean adjMatrix[][];
	private int vertexCount;
	
	/** Adjacency matrix representation of Graph */
	public GraphAdjMatrixRepresentation(int vertexCount) {
		this.vertexCount = vertexCount;
		adjMatrix = new boolean[vertexCount][vertexCount];

	}

	public void addEdge(int i, int j) {
		if (i > 0 && i < vertexCount && j > 0 && j < vertexCount) {
			adjMatrix[i][j] = true;
			adjMatrix[j][i] = true;
		}
	}
	
	public void removeEdge(int i, int j){
		if (i > 0 && i < vertexCount && j > 0 && j < vertexCount) {
			adjMatrix[i][j] = false;
			adjMatrix[j][i] = false;
		}
	}
	
	public boolean isEdgePresent(int i, int j){
		if (i > 0 && i < vertexCount && j > 0 && j < vertexCount)
			return adjMatrix[i][j];
		else
			return false;
	}
	
	
}
