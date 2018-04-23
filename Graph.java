/**
 * @author  Azim Javedali Saiyed (800889017)
 * 
 * @project Dijkstra's Algorithm with Min Heap
 *
 * This program builds: 
 *  - initial graph from a file 
 *  - updates the graph to reflect changes
 *  - finds the shortest path by implementing Dijkstra's Algorithm using Min-Heap 
 *  - prints the graph
 *	- finds reachable sets of vertices 
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Graph Class initilizes and handles all the operations related to the Graph.
 */
public class Graph {

	public static final int INFINITY = Integer.MAX_VALUE; //Initialize constant with infinite value
	private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>(); //Creates a HashMap which stores all the information of the vertices
	private LinkedList<Pair> downEdges = new LinkedList<Pair>(); //Stores all the downedges in the graph
	private TreeSet<String> reachableNodes = new TreeSet<String>(); //Stores the visited nodes for the REACHABLE-ALGO

	/**
	 * If vertexName is not present, add it to vertexMap. In either case, return
	 * the Vertex.
	 */
	private Vertex getVertex(String vertexName) {
		Vertex v = vertexMap.get(vertexName);
		if (v == null) {
			v = new Vertex(vertexName);
			vertexMap.put(vertexName, v);
		}
		return v;
	}

	/**
	 * Main Class which reads the file which is passed to it and stores the graph. 
	 * It then calls the function processRequest() function which executes the queries.
	 */
	public static void main(String[] args) {
		Graph g = new Graph();
		g.downEdges.add(new Pair(" ", " "));
		try {
			FileReader fin = new FileReader(args[0]);
			Scanner graphFile = new Scanner(fin);
	
			String line;
			while (graphFile.hasNextLine()) {
				line = graphFile.nextLine();
				StringTokenizer st = new StringTokenizer(line);
	
				try {
					if (st.countTokens() != 3) {
						System.err.println("Skipping ill-formatted line "
								+ line);
						continue;
					}
					String source = st.nextToken();
					String dest = st.nextToken();
					double distance = Double.parseDouble(st.nextToken());
	
					g.addEdge(source, dest, distance);
					g.addEdge(dest, source, distance);
				} catch (NumberFormatException e) {
					System.err.println("Skipping ill-formatted line " + line);
				}
			}
			graphFile.close();
		} catch (IOException e) {
			System.err.println(e);
		}	
		Scanner in = new Scanner(System.in);
		while (processRequest(in, g))
			;
	}

	/**
	 * This function adds a new edge to the graph.
	 * If an edge is already present then it will update the distance and if distance is
	 * also the same then it will do nothing.
	 * Command : "addedge <SOURCENAME> <DESTNAME> <DISTANCE>"
	 */
	public void addEdge(String sourceName, String destName, double distance) {
		Vertex v = getVertex(sourceName);
		Vertex w = getVertex(destName);
	
		Iterator<Edge> listIterator = v.adj.listIterator();
		int i = 0, update = 0;
		while (listIterator.hasNext()) {
	
			Edge e = listIterator.next();
	
			if (w.name.equals(e.destName.name)) {
				v.adj.get(i).distance = distance;
				update = 1;
			}
			i++;
		}
		if (update == 0)
			v.adj.add(new Edge(w, distance));
	}

	/**
	 * Process a request; The function will ask for queries from the user.
	 * The program will exit when the command "quit" is entered.
	 */
	public static boolean processRequest(Scanner in, Graph g) {
		try {
	
			System.out.print("\nEnter Query: ");
			String qry = in.nextLine();
	
			String[] arr = qry.split(" ");
	
			switch (arr[0]) {
	
			case "print":
				g.print();
				break;
	
			case "quit":
				return false;
	
			case "reachable":
				g.reachableAlgo();
				break;
	
			case "path":
				if (arr.length == 3) {
					g.dijkstra(arr[1]);
					g.printPath(arr[2]);
				} else
					System.out.println("Invalid Path Query");
				break;
	
			case "edgeup":
				if (arr.length == 3) {
					g.edgeUp(arr[1], arr[2]);
				} else
					System.out.println("Invalid EdgeUp Query");
				break;
	
			case "edgedown":
				if (arr.length == 3) {
					g.edgeDown(arr[1], arr[2]);
				} else
					System.out.println("Invalid EdgeDown Query");
				break;
	
			case "vertexup":
				if (arr.length == 2) {
					g.vertexUp(arr[1]);
				} else
					System.out.println("Invalid VertexUp Query");
				break;
	
			case "vertexdown":
				if (arr.length == 2) {
					g.vertexDown(arr[1]);
				} else
					System.out.println("Invalid VertexDown Query");
				break;
	
			case "deleteedge":
				if (arr.length == 3) {
					g.removeEdge(arr[1], arr[2]);
				} else
					System.out.println("Invalid DeleteEdge Query");
				break;
	
			case "addedge":
				if (arr.length == 4) {
					g.addEdge(arr[1], arr[2], Double.parseDouble(arr[3]));
				} else
					System.out.println("Invalid AddEdge Query");
				break;
	
			default:
				System.out.println("Invalid Query !!");
				break;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Invalid Vertex Name");
		} catch (GraphException e) {
			System.err.println(e);
		}
		return true;
	}

	/**
	 * Dijkstra's shortest-path algorithm using Min-Heap.
	 */
	public void dijkstra(String startName) {
		clearAll();

		MinHeap pQueue = new MinHeap(vertexMap.size());

		Vertex start = vertexMap.get(startName);
		if (start == null){
			System.out.println("Start vertex not found");return;
		}
		if (start.status != "UP"){
			System.out.println("Vertex is Down");return;
		}

		start.dist = 0.0;

		pQueue.insert(new Path(start.name, start.dist));

		while (pQueue.size() != 0) {
			Vertex v = getVertex(pQueue.remove().str);

			for (Edge e : v.adj) {
				Vertex w = e.destName;
				if (w.status != "UP")
					continue;
				if (isEdgeDown(v.name, w.name))
					continue;

				double cvw = e.distance;

				if (cvw < 0)
					throw new GraphException("Graph has negative edges");
				if (w.dist > v.dist + cvw) {
					w.dist = v.dist + cvw;
					w.prev = v;

					pQueue.insert(new Path(w.name, w.dist));
				}
			}
		}
	}

	/**
	 * Initializes the vertex output info prior to running any shortest path
	 * algorithm.
	 */
	private void clearAll() {
		for (Vertex v : vertexMap.values())
			v.reset();
	}

	/**
	 * It makes the status of the Vertex as UP if it is DOWN else do nothing.
	 * When vertex is made UP, it will be used to calculate the shortest path.
	 * Command : "vertexup <VERTEX_NAME>"
	 */
	public void vertexUp(String str) {
		Vertex v = vertexMap.get(str);
		v.status = "UP";
	}

	/**
	 * It makes the status of the Vertex as DOWN if it is UP else do nothing.
	 * When vertex is made DOWN, it will be disabled which will disable all the Edges connected to it.
	 * Command : "vertexdown <VERTEX_NAME>"
	 */
	public void vertexDown(String str) {
		Vertex v = vertexMap.get(str);
		v.status = "DOWN";
	}

	/**
	 * This function enables the edge if it is already disabled else do nothing.
	 * Command : "edgeup <SOURCE_VERTEX> <DEST_VERTEX>"
	 */
	public void edgeUp(String source, String dest) {
	
		Iterator<Pair> itr = downEdges.iterator();
		int exist = 0;
		Pair temp = null;
	
		if (downEdges.size() != 0) {
			while (itr.hasNext()) {
				temp = itr.next();
				if (source.equals(temp.key()) && dest.equals(temp.value())) {
					exist = 1;
					break;
				}
			}
		}
		if (exist == 1)
			downEdges.remove(temp);
	}

	/**
	 * This function will disable the Edge making it unable to be traversed through.
	 * Command : "edgeup <SOURCE_VERTEX> <DEST_VERTEX>"
	 */
	public void edgeDown(String source, String dest) {
		Iterator<Pair> itr = downEdges.iterator();
		int add = 1;

		if (downEdges.size() != 0) {
			while (itr.hasNext()) {
				Pair temp = itr.next();
				if (temp.key() == source && temp.value() == dest) {
					add = 0;
					break;
				}
			}
		}

		if (add == 1)
			downEdges.add(new Pair(source, dest));
	}

	/**
	 * This function will delete the edge from the Graph.
	 * Command : "deleteedge <SOURCE_VERTEX> <DEST_VERTEX>"
	 */
	public void removeEdge(String sourceName, String destName) {
		Vertex v = getVertex(sourceName);
		Vertex w = getVertex(destName);
		int removed = 0;
	
		Iterator<Edge> listIterator = v.adj.listIterator();
		int i = 0;
		while (listIterator.hasNext()) {
	
			Edge e = listIterator.next();
	
			if (w.name.equals(e.destName.name)) {
				removed = 1;
				break;
			}
			i++;
		}
		if (removed == 1)
			v.adj.remove(i);
	}

	/**
	 * This function will return if the edge is down/disabled else it will return false.
	 */
	public Boolean isEdgeDown(String source, String dest) {
		Iterator<Pair> itr = downEdges.iterator();
		int down = 0;
	
		if (downEdges.size() != 0) {
			while (itr.hasNext()) {
				Pair temp = itr.next();
				if (temp.key().equals(source) && temp.value().equals(dest)) {
					down = 1;
					break;
				}
			}
		}
	
		if (down == 0)
			return false;
		else
			return true;
	}

	/**
	 * This function will print all the contents of the graph in Alphabetical Order.
	 * If a vertex or an edge is down then it will append the string "DOWN" near it.
	 */
	private void print() {
	
		TreeSet<String> tree = new TreeSet<String>();
	
		System.out.println();
	
		for (String key : vertexMap.keySet()) {
			tree.add(key);
		}
	
		Iterator<String> itr = tree.iterator();
		String adjN;
		while (itr.hasNext()) {
			adjN = itr.next();
			System.out.print(adjN);
			if (vertexMap.get(adjN).status != "UP")
				System.out.print(" DOWN");
			System.out.println();
	
			TreeSet<String> adj = new TreeSet<String>();
			HashMap<String, Double> temp = new HashMap<String, Double>();
			for (Edge key : vertexMap.get(adjN).adj) {
				adj.add(key.destName.name);
				temp.put(key.destName.name, key.distance);
			}
	
			Iterator<String> adjItr = adj.iterator();
			while (adjItr.hasNext()) {
				String adjItrN = adjItr.next();
				System.out.print("  " + adjItrN + " " + temp.get(adjItrN));
				if (isEdgeDown(adjN, adjItrN))
					System.out.print(" DOWN");
				System.out.println();
			}
	
		}
	
	}

	/**
	 * Recursive routine to print shortest path to dest after running shortest
	 * path algorithm. The path is known to exist.
	 */
	private void printPath(Vertex dest) {
		if (dest.prev != null) {
			printPath(dest.prev);
			System.out.print(" ");
		}
		System.out.print(dest.name);
	}

	/**
	 * Driver routine to handle unreachable and prints the total cost. It calls
	 * recursive routine to print shortest path to destNode after a shortest
	 * path algorithm has run.
	 */
	public void printPath(String destName) {
		Vertex w = vertexMap.get(destName);
		if (w == null){
			System.out.println("Destination vertex not found");
			return;
		}
		else if (w.dist == INFINITY)
			System.out.println(destName + " is unreachable");
		else {
			System.out.println();
			printPath(w);
			System.out.printf(" %.2f", w.dist);
			System.out.println();
		}
	}

	/**
	 * REACHABLE VERTICES ALGORITHM
	 * This algorithm will display all the vertices that are accessible from each of the Vertex in alphabetical order.
	 * ------------------------------------------------------------------------------------------------------
	 * PSUEDOCODE ->
	 * ------------------------------------------------------------------------------------------------------
	 * 		ALGORITHM REACHABLE-VERTICES( )
	 * 		1. Sort all the vertices in alphabetical order
	 * 		2. foreach Vertex which is UP
	 * 		3. 		print Vertex_Name
	 * 		4.		add Vertex to visited_nodes list
	 * 		5.		call REACHABLE(Vertex) algorithm
	 * 		6.	endforeach;
	 * 		7.	print all the Vertices from visited_nodes in alphabetical order
	 * 
	 * 		ALGORITHM REACHABLE(Vertex)
	 * 		1. forach adjacent vertices
	 * 		2.		if(edge is down or vertex is down) then
	 * 		3.			continue to next iteration
	 * 		4.		endif;
	 * 		5.		if(Vertex exists in visited_node list) then
	 * 		6.			continue
	 * 		7.		else
	 * 		8.			add vertex to visited nodes list
	 * 		9.			call REACHABLE(Vertex)
	 * 		10.		endif;
	 * 		11.	endfor;
	 * ------------------------------------------------------------------------------------------------------
	 * COMPLEXITY ->
	 * ------------------------------------------------------------------------------------------------------
	 * Here the algorithm REACHABLE-VERTICES( ) will be called for each of the N vertices. So the time 
	 * complexity of it will be O(n). And the recursive algorithm REACHABLE will call itself for all the
	 * adjacent vertices  will run for O(log n) times.
	 * Hence the complexity of this algorithm is given as :
	 * 												O(nlogn)
	 * ------------------------------------------------------------------------------------------------------
	 */
	private void reachableAlgo() {
	
		TreeSet<String> tree = new TreeSet<String>();
	
		System.out.println();
	
		for (String key : vertexMap.keySet()) {
			if (vertexMap.get(key).status != "UP")
				continue;
			tree.add(key);
		}
	
		Iterator<String> itr = tree.iterator();
		String adjN;
	
		while (itr.hasNext()) {
			adjN = itr.next();
			System.out.print(adjN);
			System.out.println();
	
			reachableNodes.clear();
			reachableNodes.add(adjN);
	
			reachable(adjN);
	
			Iterator<String> adjItr = reachableNodes.iterator();
			while (adjItr.hasNext()) {
				String adjItrN = adjItr.next();
				if (adjItrN != adjN)
					System.out.println("  " + adjItrN);
			}
		}
	}

	/**
	 * This recursive algorithm will be called by the reachableAlgo() function
	 */
	private void reachable(String node) {
	
		TreeSet<String> adj = new TreeSet<String>();
		for (Edge key : vertexMap.get(node).adj) {
			if (key.destName.status != "UP")
				continue;
			if (isEdgeDown(node, key.destName.name))
				continue;
	
			adj.add(key.destName.name);
		}
		for (String str : adj) {
			if (reachableNodes.contains(str))
				continue;
			else {
				reachableNodes.add(str);
				reachable(str);
			}
		}
	}
}

/**
 * Handles any Exception thrown by the Graph.
 */
class GraphException extends RuntimeException {
	public GraphException(String name) {
		super(name);
	}
}

/**
 * Vertex Class which handles all the information related to the vertex.
 */
class Vertex {
	public String name; // Vertex name
	public List<Edge> adj; // Adjacent vertices
	public Vertex prev; // Previous vertex on shortest path
	public Double dist; // Distance 
	public String status; // Status

	// Initializes the Vertex with default status as "UP".
	public Vertex(String nm) {
		name = nm;
		adj = new LinkedList<Edge>();
		status = "UP";
		reset();
	}

	// Resets the distance of Vertex to infinity and pointer to previous Vertex as NULL.
	public void reset() {
		dist = (double) Graph.INFINITY;
		prev = null;
	}

}

/**
 * Edge Class stores the information related to the Egde.
 */
class Edge {
	public Vertex destName; // Destination Node
	public double distance; // Distance of path

	// Constructor of the Edge Class.
	public Edge(Vertex w, double d) {
		destName = w;
		distance = d;
	}
}

/**
 * Path Class which stores the name of a Path.
 */
class Path {
	public String str;
	public double dist;

	public Path(String s, Double d) {
		str = s;
		dist = d;
	}

}

/**
 * This Class is a User-defined datatype which stores a pair of Strings.
 */
class Pair {
	private final String str1;
	private final String str2;

	public Pair(String aStr1, String aStr2) {
		str1 = aStr1;
		str2 = aStr2;
	}

	public String key() {
		return str1;
	}

	public String value() {
		return str2;
	}
}

/**
 * MinHeap Class which is used by Dijkstra's Algorithm.
 * This class will calculate Min-Heap of the tree, acting as a Priority Queue.
 */
class MinHeap {
	private Path[] Heap; //Heap variable declared of Path datatype
	private int size; //Size of the heap 
	private int maxsize; //Maxsize of the heap (total number of vertices)

	private static final int FRONT = 1; //Constant storing the Front value

	//Constructor which initializes the Min-Heap.
	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new Path[this.maxsize + 1];
		Heap[0] = new Path("null", (double) Integer.MIN_VALUE);
	}
	
	//Returns the size of the Heap
	public int size() {
		return size;
	}
	
	//Returns the Parent Node of a Vertex
	private int parent(int pos) {
		return pos / 2;
	}

	//Returns the left child of a node
	private int leftChild(int pos) {
		return (2 * pos);
	}
	
	//Returns the right child of a node
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	//Checks if the node is a leaf node or not
	private boolean isLeaf(int pos) {
		if (pos - 1 >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}
	
	//Swaps the position in the heap if the child node is smaller than the parent.
	private void swap(int fpos, int spos) {
		Path tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}
	
	//performs the Min-Heapify function of the tree when called.
	private void minHeapify(int pos) {
		if (!isLeaf(pos) && this.size > 0) {
			if (Heap[pos].dist > Heap[leftChild(pos)].dist
					|| Heap[pos].dist > Heap[rightChild(pos)].dist) {
				if (Heap[leftChild(pos)].dist < Heap[rightChild(pos)].dist) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	//Inserts a new element in the heap
	public void insert(Path element) {
		Heap[++size] = element;
		int current = size;
		while (Heap[current].dist < Heap[parent(current)].dist) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	//Performs the Min-Heap on the tree
	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}
	
	//Returns the root node i.e the smallest value from the heap and then heapify the tree
	public Path remove() {
		Path popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return popped;
	}

}
