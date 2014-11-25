// import make24;

public class Make24 {

	public static void main(String[] args)
	{
		int target = 24;
		if ((args.length != 4) && (args.length != 5))
		{
			System.out.println("Please input 4 integers to make 24...");
			System.exit(1);
		}
		
		String target_flag = "--target=";
		if (args.length == 5)
		{
			if (args[4].indexOf(target_flag) != -1)
			{
				target = Integer.parseInt( args[4].substring( args[4].indexOf(target_flag) + target_flag.length() ) );
			}
			else
			{
				System.out.println("unrecognized target flag... will use default target = 24...");				
			}
		}
		
	
		TwentyFourMaker tfm = null;
		if (target == 24)
		{
			tfm = TwentyFourMaker.getInstance();
		}
		else
		{
			tfm = TwentyFourMaker.getInstance(target);
		}
		tfm.compute(args[0], args[1], args[2], args[3]);
	
	}

}