import java.util.Stack;

public class DepthFirstSearch
{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstSearch(int s, Graph g)
    {
        marked = new boolean[g.V()];
	edgeTo = new int[g.V()];
	this.s = s;

	dfs(g, s);
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;

	for(int w : g.adj(v))
	{
	    if(!marked[w])
	    {
		dfs(g, w);
		edgeTo[w] = v;
	    }
	}
    }

    public boolean hasPathTo(int w)
    {
        return marked[w];
    }

    public Iterable<Integer> pathTo(int v)
    {
        if(!hasPathTo(v)) return null;

	Stack<Integer> path = new Stack<Integer>();
	for(int x = v; x != s; x = edgeTo[x])
	    path.push(x);

	return path;
    }
}
