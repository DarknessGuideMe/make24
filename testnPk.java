// import Combinatorics.com.PermutationGenerator;
import java.util.LinkedList;

public class testnPk {

	public static void main(String[] args)
	{	
		Integer[] a = {4, 6, 7, 10, 11, 18};
		nPk npk = new nPk(a.length, 3, a);
		LinkedList<Object[]> l = npk.getPermutations();
		
		for (Object[] b : l)
		{
			String re = "";
			for (int i = 0; i < b.length; i++)
				re += b[i] + "  ";
			System.out.println(re);
		}
		
		System.out.println("=======================================");
		int [] a2 = {4, 6, 7, 10, 11, 18};
		
		nPk npk2 = new nPk(a2.length, 3);
		LinkedList<int[]> indices = npk2.getIndices();
		
		for (int[] ind : indices)
		{
			String re = "";
			for (int i = 0; i < ind.length; i++)
				re += a2[ ind[i] ] + "  ";
			System.out.println(re);
		}
	
	}
	
}