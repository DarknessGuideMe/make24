// import make24.FourNumberAllValue;

public class testFourNumberAllValue {

	public static void main(String[] args)
	{
		String a = "1";
		String b = "2";
		String c = "3";
		String d = "4";
		if (args.length == 4)
		{
			a = args[0];
			b = args[1];
			c = args[2];
			d = args[3];
		}
		
		FourNumberAllValue fna = new FourNumberAllValue(a, b, c, d);
		fna.displayAllValue();
	
	}

}