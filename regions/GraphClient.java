import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

public class GraphClient
{
    public static void main(String[] args)
    {
        try
	{
	   Scanner reader = new Scanner(new File("tinyG.txt"));
	   Graph g = new Graph(reader.nextInt());
	   int E = reader.nextInt();

	   for(int i = 0; i < E; i++)
	   {
	       int v = reader.nextInt();
	       int w = reader.nextInt();

	       g.addEdge(v, w);
	   }

	   //System.out.println(g);

	   DepthFirstSearch dfs = new DepthFirstSearch(0, g);
           System.out.println(dfs.hasPathTo(7));
           System.out.println(dfs.hasPathTo(6));

	   for(int i : dfs.pathTo(3))
	        System.out.print(i + " <- ");
	   System.out.print(0);


	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
}
