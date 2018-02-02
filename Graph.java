/* A class that represents each vertex of a graph.
Assumptions:
1. The graph implemented by this class is always an undirected graph
2. The graph implemented by this class is an unweighted graph
*/

/* Class vertex */
/* 1. Vertex Label */
public class Vertex
{
	string label;

	/* Constructor */
	public Vertex()
	{
		this.label = "";
	}
	public Vertex(string label)
	{
		this.label = label;
	}
}

/* Class Graph */
/* This class contains three attributes */
/* 1. List of Vertices */
/* 2. HashMap that maps each vertex to a set of vertices that it is connected to */
public class Graph{
	List<Vertex> vertices;
	Map<Vertex, Set<Vertex>> edges;

	// Constructor
	public Graph()
	{
		this.vertices = new ArrayList<Vertex>();
		this.edges = new HashMap<Vertex, Set<Vertex>>();
	}

	// Method to add vertex to a graph
	public void addVertex(string vLabel)
	{
		// Create a new vertex object
		Vertex newVert = new Vertex(vLabel);
		this.vertices.add(newVert);
	}

	// Method to add an edge between two vertices
	public void addEdge(Vertex v1, Vertex v2)
	{
		// Look up in the hash map to see if edge already exists 
		if(this.edges.containsKey(v1) && this.edges.containsKey(v2))
		{
			return;
		}
		
		// Check if the vertices are already mapped
		if(!this.isConnected(v1, v2))
		{
			// connect the vertices
			this.connectVertices(v1, v2);
		}
	}
	
	// Method to check if the vertices are already connected by edges
	public boolean isConnected(Vertex v1, Vertex v2)
	{
		Set<Vertex> connectVerticesV1 = this.edges.get(v1);
		Set<Vertex> connectVerticesV2 = this.edges.get(v2);

		if(connectVerticesV1.contains(v2) || connectVerticesV2.contains(v1))
			return true;
		return false;
 	} 

 	// Method to connect the two vertices
 	public void connectVertices(Vertex v1, Vertex v2)
 	{
 		Set<Vertex> connectVerticesV1 = this.edges.get(v1);
		Set<Vertex> connectVerticesV2 = this.edges.get(v2);
		
		// Add vertices to the set
		connectVerticesV1.add(v2);
		connectVerticesV2.add(v1);

		// Update HashMap
		this.edges.put(v1, connectVerticesV1);
		this.edges.put(v2, connectVerticesV2);
 	}
}