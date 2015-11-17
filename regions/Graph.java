import java.util.LinkedList;

public class Graph
{
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V)
    {
        this.V = V;
	this.E = 0;
	this.adj = (LinkedList<Integer>[]) new LinkedList[V];

	for(int i = 0; i < V; i++)
	{
	    this.adj[i] = new LinkedList<Integer>();
	}
    }

    public void addEdge(int v, int w)
    {
        E++;
        this.adj[v].add(w);
        this.adj[w].add(v);
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }

    public int V()
    {
        return this.V;
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();

        s.append(V + " vertices, " + E + " edges "+ NEWLINE);
        for(int i = 0; i < V; i++)
	{
	    s.append(i + ": ");
	    for(int w : adj[i])
	        s.append(w + " ");
            s.append(NEWLINE);
	}

	return s.toString();

    }

}
