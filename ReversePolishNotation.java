// package make24;

import java.util.LinkedList;

public class ReversePolishNotation {	
	
	private String[] expression;
	private LinkedList<Double> value;
	private LinkedList<String> string_representation;
	
	// ===============================================================
	
	public ReversePolishNotation(String[] exp)
	{
		expression = exp;
		evaluate();
	}
	
	// ===============================================================
	
	/*
	public static String convertExpressionToRPN(String exp)
	{
	
	}
	*/
	
	// ===============================================================
	
	private void evaluate()
	{
		value = new LinkedList<Double>();
		string_representation = new LinkedList<String>();
		
		int N = expression.length;
		try
		{
			for (int i = 0; i < N; i++)
			{
				if (Operator.isOperator(expression[i]))
				{
					Operator o = new Operator(expression[i]);
					
					double d2 = value.removeLast();
					double d1 = value.removeLast();					
					
					double new_v = o.operate(d1, d2);
					value.add(new_v);
					
					String s2 = string_representation.removeLast();
					String s1 = string_representation.removeLast();
					
					String new_s = "(" + s1 + " " + o + " " + s2 + ")";
					string_representation.add(new_s);
				}
				else
				{
					value.add( Double.parseDouble(expression[i]) );
					string_representation.add( expression[i] );
				}
			}
			
			
		
			if (value.size() != 1)
			{
				System.out.println("ReversePolishNotation :: evaluate :: at the end, value.size() = " + value.size());
				printExpression();
			}
			if (string_representation.size() != 1)
			{
				System.out.println("ReversePolishNotation :: evaluate :: at the end, string_representation.size() = " + string_representation.size());
				printExpression();
			}
		}
		catch (Exception e)
		{
			System.out.println("ReversePolishNotation :: evaluate :: " + e);
			e.printStackTrace();
			printExpression();
		}
		
	}
	
	// ===============================================================
	
	private void printExpression()
	{
		for (int i = 0; i < expression.length; i++)
		{
			System.out.print(expression[i] + " ");
		}
		System.out.println();
	}
	
	// ===============================================================
	
	public double getValue()
	{
		return value.peek();
	}
	
	// ===============================================================
	
	public String toString()
	{
		return string_representation.peek() + " = " + value.peek();
	}
	
	// ===============================================================
	
	/*
	public static equals(String[] exp1, String[] exp2)
	{	
		value = new LinkedList<Double>();
		string_representation = new LinkedList<String>();
		
		int N = expression.length;
		try
		{
			for (int i = 0; i < N; i++)
			{
				if (Operator.isOperator(expression[i]))
				{
					Operator o = new Operator(expression[i]);
					
					double d2 = value.removeLast();
					double d1 = value.removeLast();					
					
					double new_v = o.operate(d1, d2);
					value.add(new_v);
					
					String s2 = string_representation.removeLast();
					String s1 = string_representation.removeLast();
					
					String new_s = "(" + s1 + " " + o + " " + s2 + ")";
					string_representation.add(new_s);
				}
				else
				{
					value.add( Double.parseDouble(expression[i]) );
					string_representation.add( expression[i] );
				}
			}
			
			
		
			if (value.size() != 1)
			{
				System.out.println("ReversePolishNotation :: evaluate :: at the end, value.size() = " + value.size());
				printExpression();
			}
			if (string_representation.size() != 1)
			{
				System.out.println("ReversePolishNotation :: evaluate :: at the end, string_representation.size() = " + string_representation.size());
				printExpression();
			}
		}
		catch (Exception e)
		{
			System.out.println("ReversePolishNotation :: evaluate :: " + e);
			e.printStackTrace();
			printExpression();
		}
	
	}
	*/

}