import java.util.Stack;
import java.util.TreeMap;

public class ConnectedComponents
{
    private static final String NEWLINE = System.getProperty("line.separator");
    private boolean[] marked;
    private int[] id;
    private int count;
    private int size;
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

    public ConnectedComponents(Graph g)
    {
        marked = new boolean[g.V()];
	id = new int[g.V()];
	this.count = 1;
	this.size = 0;

	for(int v = 0; v < g.V(); v++)
	{
	    if(!marked[v])
	    {
	        dfs(g, v);
		map.put(count, size);
		count++;
		size = 0;
	    }
	}
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;
	id[v] = count;

	for(int w : g.adj(v))
	{
	    if(size == 0) size = 1;
	    if(!marked[w])
	    {
	        size++;
		dfs(g, w);
	    }
	}
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();

	for(Integer i : map.keySet())
	{
	    s.append("Component : " + i + " Size: " + map.get(i) + NEWLINE); 
	}

	return s.toString();
    }


    /*public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v)
    {
        if(!hasPathTo(v)) return null;

	Stack<Integer> path = new Stack<Integer>();
	for(int x = v; x != s; x = id[x])
	    path.push(x);

	return path;
    }*/

    public static void main(String[] args)
    {
        int[][] input = {
	            {1, 1, 1, 1, 0},
		    {1, 0, 0, 0, 0},
		    {0, 0, 1, 1, 1},
		    {1, 0, 0, 0, 0},
		    {0, 1, 1, 1, 1}
		  };

	int rows = input.length;
	int columns  = input[0].length;

	Graph g = new Graph(rows * columns);

	for(int i = 0; i < rows; i++)
	{
	     for(int j = 0; j < columns; j++)
             {
	         if(input[i][j] == 1)
		 {
                     g.addEdge(i*columns+j, i*columns+j);

		     if(j+1 < columns && input[i][j+1] == 1) //Immediate right
                         g.addEdge(i*columns+j, i*columns+j+1);
		     if(i+1 < rows && input[i+1][j] == 1) //Immediate below
                         g.addEdge(i*columns+j, (i+1)*columns+j);
		     if(j+1 < columns && i+1 < rows && input[i+1][j+1] == 1) //Diagonal Right Below
                         g.addEdge(i*columns+j, (i+1)*columns+j+1);
		     if(j-1 >= 0 && i+1 < rows && input[i+1][j-1] == 1) //Diagonal Left Below
                         g.addEdge(i*columns+j, (i+1)*columns+j-1);
		 }
	     }
	}

	ConnectedComponents cc = new ConnectedComponents(g);
	System.out.println(cc);
    }
}
