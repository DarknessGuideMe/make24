// package Combinatorics;

import java.util.LinkedList;

public class nPk {
	
	private boolean bDebug = true;
	
	private int n,k;
	private Object[] items;
	private int[] indices;
	private LinkedList<int[]> lIndices;
	
	// ===============================================================
	
	public nPk()
	{
	
	}
	
	//------------------------------------------
	
	public nPk(int n, int k)
	{
		this.n = n;
		this.k = k;
		Integer[] a = new Integer[n];
		for (int i = 1; i <= n; i++)	a[i-1] = i;
		setItems(a);
		
		permutations();
	}
	
	//------------------------------------------
	
	public nPk(Object[] v)
	{
		setItems(v);
		permutations();
	}
	
	//------------------------------------------
	
	public nPk(int n, int k, Object[] v)
	{
		this.n = n;
		this.k = k;
		setItems(v);
		permutations();
	}
	
	// ===============================================================
	
	public void initialize()
	{
		lIndices = new LinkedList<int[]>();
	}
	
	// ===============================================================
	
	public void setItems(Object[] v)
	{
		if (n == 0)
		{
			items = v;
			n = items.length;
			k = items.length;
		}
		else if (v.length != n)
		{
			System.err.println("nPk :: setItems :: length of the array must be equal to " + n + "...");
			System.exit(1);
		
		}
		else
		{
			items = v;
		}
		
		indices = new int[n];
		for (int i = 0; i < n; i++)	indices[i] = i;
		initialize();
	}	
	
	// ===============================================================
	
	public LinkedList<int[]> getIndices()	{	return lIndices;	}
	
	// ===============================================================
	
	private void permutations()
	{
		permutations(indices, k, 0);
	}	
	
	//------------------------------------------
	
	//http://stackoverflow.com/questions/127704/algorithm-to-return-all-combinations-of-k-elements-from-n
	private void permutations(int[] elements, int length,  int currentI)
	{
		//debug("\n==========================================\n" + toStringDetailed());
		//debug("\n==========================================\n" + "length = " + length + ", " + "currentI = " + currentI);
		
		for (int i = currentI; i < elements.length; i++)
		{
			// move the i-th element to front
			swap(elements, currentI, i);
			
			if (length == 1)
			{
				process();				
			}
			else
			{
				permutations(elements, length - 1, currentI + 1);				
			}
			
			swap(elements, i, currentI);
		
		}
	
	
	}
	
	// ===============================================================
	
	public String toStringDetailed()
	{
		String re = "";
		re += "n = " + n + "\n";
		re += "k = " + k + "\n";
		re += "Index Array:\n";
		for (int i = 0; i < n; i++)		re += indices[i] + "  ";
		re += "\n";
		return re;
	}
	
	// ===============================================================
	
	private void process()
	{
		int[] a = new int[k];
		//String re = "";
		for (int i = 0; i < k; i++)		
		{	
			a[i] = indices[i];
			//re += indices[i] + "  ";
		}
		//System.out.println(re);	
		
		
		lIndices.add(a);
		
	}
	
	// ===============================================================
	
	public LinkedList<Object[]> getPermutations()
	{
		LinkedList<Object[]> lRe = new LinkedList<Object[]>();
		while (lIndices.size() > 0)
		{
			Object[] a = new Object[k];
			indices = lIndices.remove();
			for (int i = 0; i < indices.length; i++)	a[i] = items[indices[i]];
			lRe.add(a);			
		}
		return lRe;
	}
	
	// ===============================================================
	
	private static void swap(int[] elements, int i, int j)
	{
		if (i == j)	return;
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	// ===============================================================
	
	private void debug(String s)	{	if (bDebug)	System.out.println(s);	}
	
	// ===============================================================
	
	

}