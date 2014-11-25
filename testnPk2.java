// import Combinatorics.com.nPk;
import java.util.LinkedList;

public class testnPk2 {

	public static void main(String[] args)
	{	
		Integer[] a = {4, 4, 4, 5, 6, 5};
		nPk npk = new nPk(a.length, a.length, a);
		LinkedList<Object[]> l = npk.getPermutations();
		
		for (Object[] b : l)
		{
			String re = "";
			for (int i = 0; i < b.length; i++)
				re += b[i] + "  ";
			System.out.println(re);
		}
		
	}
	
}