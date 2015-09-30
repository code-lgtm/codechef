import java.io.*;

/*
*
* Problem: https://www.codechef.com/problems/RBTREE
*
*/

class CodeChefProb
{
    private final static boolean BLACK = true;
    private final static boolean RED = false;
    private static boolean colorRoot = BLACK;

    //Switch color of root node
    public static void switchColor()
    {
        colorRoot = colorRoot ? RED : BLACK;

    }

    //Get color of root node
    public static boolean getColor()
    {
        return colorRoot;
    }

    //Check the level in which the node is on.
    //The number of nodes at level x is pow(2,x)
    public static int findLevel(int n)
    {
        int x = 1;
	int count = 0;

	//Level of node would be logn. count captures that
	while(x < n)
	{
	    count++;
	    x = x<<1;
	}

	return (x == n) ? count : --count;
    }

    //If level is even. It is the same color as root node
    public static boolean colorNode(int h)
    {
	return (h%2 == 0) ? getColor() : !getColor();
    }

    //Count the nodes of the required color of path from x1 to x2
    public static int countColorNodes(int x1, int x2, boolean reqColor)
    {
        int count = 0;
        int h1 = findLevel(x1);
        int h2 = findLevel(x2);
        boolean colNode1 = colorNode(h1);
        boolean colNode2 = colorNode(h2);

        while(x1 != x2)
	{
	   //Traverse node which is at a higer level
	   if(h1 > h2)
	   {
	       if(colNode1 == reqColor) count++;

	       h1--;
	       colNode1 = !colNode1;
	       x1 /= 2;
	   }
	   else if(h2 > h1)
	   {
	       if(colNode2 == reqColor) count++;

	       h2--;
	       colNode2 = !colNode2;
	       x2 /= 2;
	   }
	   else
	   {
	       //Both nodes are at the same level. Go to parent for both of them
	       if(colNode1 == reqColor) count++;
	       h1--;
	       colNode1 = !colNode1;

	       if(colNode2 == reqColor) count++;
	       h2--;
	       colNode2 = !colNode2;

	       x1 /= 2;
	       x2 /= 2;
	   }
	}

	//Count common ancestor
	if(colNode1 == reqColor) count++;

	return count;
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());

	for(int i = 0; i < t; i++)
	{
	    String s = br.readLine();

	    if(s.equals("Qi")) switchColor();
	    else
	    {
	        String[] testCase = s.split(" ");
		int lo = Integer.parseInt(testCase[1]);
		int hi = Integer.parseInt(testCase[2]);
		boolean color = testCase[0].equals("Qb");

		System.out.println(countColorNodes(lo, hi, color));

	    }
	}

	br.close();
    }
}
