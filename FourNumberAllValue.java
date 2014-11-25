// package make24;

// import Combinatorics.com.nPk;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Set;

public class FourNumberAllValue {
	
	private String[] numbers = null;
	private static final String[] operators = {"+", "-", "*", "/"};
	private HashMap<String, Double> exp_value;
	private HashMap<Double, LinkedList<String>> value_exp;
	private LinkedList<int[]> lIndices_Operator;
	
	private HashMap<String, String> exp_rpn;
	
	
	//========================================================================
	
	public FourNumberAllValue(String a, String b, String c, String d)
	{
		initialize();
		numbers = new String[] {a, b, c, d};
		computeAllValues();
	}
	
	//-------------------------------------------------
	
	public FourNumberAllValue(int a, int b, int c, int d)
	{
		initialize();
		numbers = new String[] {"" + a, "" + b, "" + c, "" + d};
		computeAllValues();
	}
	
	//========================================================================
	
	private void initialize()
	{
		exp_value = new HashMap<String, Double>();
		value_exp = new HashMap<Double, LinkedList<String>>();
		exp_rpn = new HashMap<String, String>();
		
		lIndices_Operator = new LinkedList<int[]>();
		for (int i1 = 0; i1 < 4; i1++)
			for (int i2 = 0; i2 < 4; i2++)
				for (int i3 = 0; i3 < 4; i3++)
				{
					int[] ind = new int[] {i1, i2, i3};
					lIndices_Operator.add(ind);
				}
	}
	
	//========================================================================
	
	private void computeAllValues()
	{	
		nPk permutator1 = new nPk(4, 4);
		LinkedList<int[]> indices1 = permutator1.getIndices();
		
		for (int[] ind1 : indices1)
		{
			
			for (int[] ind2 : lIndices_Operator)
			{
				//System.out.println("-------------------------------------------");
				
				String[] exp1 = new String[7];
				String[] exp2 = new String[7];
				String[] exp3 = new String[7];
				String[] exp4 = new String[7];
				String[] exp5 = new String[7];
				
				exp1[0] = numbers[ ind1[0] ];
				exp1[1] = numbers[ ind1[1] ];
				exp1[2] = operators[ ind2[0] ];
				exp1[3] = numbers[ ind1[2] ];
				exp1[4] = numbers[ ind1[3] ];
				exp1[5] = operators[ ind2[1] ];
				exp1[6] = operators[ ind2[2] ];
				
				exp2[0] = numbers[ ind1[0] ];
				exp2[1] = numbers[ ind1[1] ];
				exp2[2] = operators[ ind2[0] ];
				exp2[3] = numbers[ ind1[2] ];
				exp2[4] = operators[ ind2[1] ];
				exp2[5] = numbers[ ind1[3] ];
				exp2[6] = operators[ ind2[2] ];
				
				exp3[0] = numbers[ ind1[0] ];
				exp3[1] = numbers[ ind1[1] ];
				exp3[2] = numbers[ ind1[2] ];
				exp3[3] = numbers[ ind1[3] ];
				exp3[4] = operators[ ind2[0] ];
				exp3[5] = operators[ ind2[1] ];
				exp3[6] = operators[ ind2[2] ];
				
				exp4[0] = numbers[ ind1[0] ];
				exp4[1] = numbers[ ind1[1] ];
				exp4[2] = numbers[ ind1[2] ];
				exp4[3] = operators[ ind2[0] ];
				exp4[4] = numbers[ ind1[3] ];
				exp4[5] = operators[ ind2[1] ];
				exp4[6] = operators[ ind2[2] ];
				
				exp5[0] = numbers[ ind1[0] ];
				exp5[1] = numbers[ ind1[1] ];
				exp5[2] = numbers[ ind1[2] ];
				exp5[3] = operators[ ind2[0] ];
				exp5[4] = operators[ ind2[1] ];
				exp5[5] = numbers[ ind1[3] ];
				exp5[6] = operators[ ind2[2] ];
				
				/*
				printExpression(exp1);
				printExpression(exp2);
				printExpression(exp3);
				printExpression(exp4);
				printExpression(exp5);
				//*/
				
				handleExpression(exp1);
				handleExpression(exp2);
				handleExpression(exp3);
				handleExpression(exp4);
				handleExpression(exp5);
			}
		}
	
	}
	
	//========================================================================
	
	private void handleExpression(String[] exp)
	{
		ReversePolishNotation rpn = new ReversePolishNotation(exp);
		
		exp_value.put( rpn.toString(), rpn.getValue() );
		exp_rpn.put( rpn.toString(), concatExpression(exp) );
		
		LinkedList<String> le = value_exp.get( rpn.getValue() );
		if (le != null)
		{
			le.add( rpn.toString() );
		}
		else
		{
			le = new LinkedList<String>();
			le.add( rpn.toString() );
			value_exp.put( rpn.getValue(), le );
		}
	}
	
	//========================================================================
	
	private static String concatExpression(String[] exp)
	{
		StringBuilder sb = new StringBuilder();		
		for (int i = 0; i < exp.length; i++)
		{
			sb.append(exp[i]);
		}
		return sb.toString();
	}
	
	//========================================================================
	
	private static void printExpression(String[] exp)
	{
		for (int i = 0; i < exp.length; i++)
		{
			System.out.print(exp[i] + " ");			
		}
		System.out.println();
	}
	
	//========================================================================
	
	public void displayAllValue()
	{
		Set<Double> s_v = value_exp.keySet();
		LinkedList<Double> set_values = new LinkedList<Double>();
		for (double d : s_v) set_values.add(d);
		Collections.sort(set_values);
		for (double d : set_values)
		{
			LinkedList<String> expressions_d = value_exp.get(d);
			for (String s : expressions_d)
			{
				System.out.println(d + ":  " + s);
			}
		}
		
	}
	
	//========================================================================
	
	public HashMap<Double, LinkedList<String>> getValueExpressionMap()
	{
		return value_exp;
	}
	
	//========================================================================
	
	public HashMap<String, String> getExpressionRPN()
	{
		return exp_rpn;
	}
}