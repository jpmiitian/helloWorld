package problems.graph.traversals.bfs;

import problems.queue.DynQueueCircArr;

public class Graph {

	private final int maxVertices=20;
	private Vertex vertexList[];
	private int adjMatrix[][];
	private int vertexCount;
	private DynQueueCircArr theQueue;
	
	//Constructor
	public Graph() {
		vertexList = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		vertexCount = 0;
		for (int y = 0; y < maxVertices; y++) {
			for (int x = 0; x < maxVertices; x++) {
				adjMatrix[x][y] = 0; //initialise matrix graph representation
			}
		}
		theQueue = new DynQueueCircArr();
	}
	
	public void addVertex(char lab){
		vertexList[vertexCount++] = new Vertex(lab);
	}
	
	public void addEdge(int start,int end){
		adjMatrix[start][end]=1;
		adjMatrix[end][start]=1;
	}
	
	public void displayVertex(int v){
		System.out.println(vertexList[v].label);
	}
	
	public void bfs(){
		vertexList[0].visited = true;
		displayVertex(0);
		
		theQueue.enQueue(0);
		int v2;
		while(!theQueue.isEmpty()){
			int v1 = theQueue.deQueue();
			while((v2=getAdjUnvisitedVertex(v1))!=-1){
				vertexList[v2].visited =true;
				displayVertex(v2);
				theQueue.enQueue(v2);
			}
		}
		for(int j=0;j<vertexCount;j++){//in book it is (int j=0;j<nVerts;j++)
			vertexList[j].visited =false;
		}
	}
	
	public int getAdjUnvisitedVertex(int v){
		for(int j=0;j<vertexCount;j++)
			if(adjMatrix[v][j]==1 &&vertexList[j].visited==false)	
					return j;
		return -1;
	}
}
