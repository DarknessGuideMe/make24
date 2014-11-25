// package make24;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class TwentyFourMaker {
	
	private static TwentyFourMaker instance;
	private static int TARGET;
	private static final double EPSILON = 1e-10;
	private FourNumberAllValue all_values;
	private StringBuilder sReport;
	private int iCounter;
	
	//========================================================================
	
	private TwentyFourMaker()
	{
		this.TARGET = 24;
	}
	
	//-----------------------------------------------------------
	
	private TwentyFourMaker(int target)
	{
		this.TARGET = target;
	}
	
	//-----------------------------------------------------------
	
	public static TwentyFourMaker getInstance()
	{
		if (instance == null)
		{
			instance = new TwentyFourMaker();
		}
		return instance;
	}
	
	//-----------------------------------------------------------
	
	public static TwentyFourMaker getInstance(int target)
	{
		if (instance == null)
		{
			instance = new TwentyFourMaker(target);
		}
		else if (instance.getTarget() != target)
		{
			instance = new TwentyFourMaker(target);
		}
		return instance;
	}
	
	//========================================================================
	
	public void compute(int a, int b, int c, int d)
	{	
		compute("" + a, "" + b, "" + c, "" + d);
	}
	
	//-----------------------------------------------------------
	
	public void compute(String a, String b, String c, String d)
	{
		all_values = new FourNumberAllValue(a, b, c, d);
		HashMap<Double, LinkedList<String>> value_exp = all_values.getValueExpressionMap();
		HashMap<String, String> exp_rpn = all_values.getExpressionRPN();
		Set<String> solution_already_seen = new HashSet<String>();
		
		sReport = new StringBuilder();
		iCounter = 0;
		
		Set<Double> s_v = value_exp.keySet();
		for (double x : s_v)
		{
			int x_int = isCloseEnoughToInt(x);
			if (x_int == TARGET)
			{
				LinkedList<String> exps = value_exp.get(x);
				for (String s : exps)
				{
					String s_rpn = exp_rpn.get(s);
					if (!solution_already_seen.contains(s_rpn))
					{
						//sReport.append(s + "\n");
						sReport.append(s.substring(0, s.indexOf("=")) + " = " + TARGET + "\n");
						iCounter++;
						solution_already_seen.add(s_rpn);
					}
				}
			}
		}

		if (iCounter > 0) {
			System.out.println(this);
			System.out.println(iCounter + " solutions (not necessarily distinct)...");	
		} else {
			System.out.println("no solution");
		}
		
	}
	
	//=====================================================================
	
	public String toString()
	{
		return sReport.toString();
	}
	
	//=====================================================================
	
	private static int isCloseEnoughToInt(double x)
	{
		if (x < 0) return -1;
		double f = Math.floor(x);
		
		if (x - f < EPSILON)
		{
			return (int)(f);
		}
		
		return -1;
	}
	
	//=====================================================================
	
	public static int getTarget()	{	return TARGET; }


}