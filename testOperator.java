// import make24.Operator;

public class testOperator {

	public static void main(String[] args)
	{
		int a = 9;
		int b = 5;
		
		if (args.length == 2)
		{
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
		}
		
		Operator o1 = new Operator("+");
		System.out.println(a + " " + o1 + " " + b + " = " + o1.operate(a,b));
		System.out.println(b + " " + o1 + " " + a + " = " + o1.operate(b,a));
		
		Operator o2 = new Operator("-");
		System.out.println(a + " " + o2 + " " + b + " = " + o2.operate(a,b));
		System.out.println(b + " " + o2 + " " + a + " = " + o2.operate(b,a));
		
		Operator o3 = new Operator("*");
		System.out.println(a + " " + o3 + " " + b + " = " + o3.operate(a,b));
		System.out.println(b + " " + o3 + " " + a + " = " + o3.operate(b,a));
		
		Operator o4 = new Operator("/");
		System.out.println(a + " " + o4 + " " + b + " = " + o4.operate(a,b));
		System.out.println(b + " " + o4 + " " + a + " = " + o4.operate(b,a));
	
	}

}