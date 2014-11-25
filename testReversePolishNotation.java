// import make24.ReversePolishNotation;

public class testReversePolishNotation {

	public static void main(String[] args)
	{
		String[] exp = { "1", "2", "+", "3", "4", "+", "*" };
		if (args.length > 0)
		{
			exp = args;
		}
		for (int i = 0; i < exp.length; i++)
		{
			System.out.println(exp[i]);
		}
		System.out.println();
		ReversePolishNotation rpn = new ReversePolishNotation( exp );
		System.out.println(rpn);
	
	}

}