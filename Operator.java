// package make24;

public class Operator {
	// TODO: use Enum...
	private String sSymbol;
	private int iSymbol; // 0 = +; 1 = -, 2 = *, 3 = /;

	// ===============================================================
	
	public Operator(String o)
	{
		setSymbol(o);
	}
	
	// ===============================================================
	
	public double operate(int a, int b)
	{
		return operate(1.0*a, 1.0*b);
	}
	
	//------------------------------------------
	
	public double operate(double a, int b)
	{
		return operate(a, 1.0*b);
	}
	
	//------------------------------------------
	
	public double operate(int a, double b)
	{
		return operate(1.0*a, b);
	}
	
	//------------------------------------------
	
	public double operate(double a, double b)
	{
		if (iSymbol == 0)	return a + b;
		
		if (iSymbol == 1)	return a - b;
		
		if (iSymbol == 2)	return a * b;
		
		if (iSymbol == 3)	return a / b;
		
		return 0.0;
	}
	
	// ===============================================================
	
	public boolean isCommutative()
	{
		return ((iSymbol == 0) || (iSymbol == 2));
	}
	
	// ===============================================================
	
	public String toString()
	{
		return sSymbol;
	}
	
	// ===============================================================
	
	public void setSymbol(String v)
	{
		if (v.equals("+"))
		{
			sSymbol = "+";
			iSymbol = 0;
		}
		else if (v.equals("-"))
		{
			sSymbol = "-";
			iSymbol = 1;
		}
		else if ( (v.equals("*")) || (v.equals("x")) )
		{
			sSymbol = "x";
			iSymbol = 2;
		}
		else if (v.equals("/"))
		{
			sSymbol = "/";
			iSymbol = 3;
		}
		else
		{
			throw new RuntimeException("Operator :: setSymbol :: invalid operator symbol... " + v);
		}
	}
	
	// ===============================================================
	
	public static boolean isOperator(String s)
	{
		return ( (s.equals("+")) || (s.equals("-")) || (s.equals("*")) || (s.equals("/")) || (s.equals("x")) );	
	}

}