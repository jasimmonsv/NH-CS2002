public class Dec2BinRecursive
{

	/**
	 * Starting code for Problem 1, HW 7:
	 * 
	 * Chapter 5 Programming Project 1
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		int toConvert = 0;
		
		while (true)
		{
			TextIO.putln ("Enter an integer >= 0 to convert to binary (<0 to quit): ");
			toConvert = TextIO.getlnInt();
			if (toConvert < 0)
				break;
			
			TextIO.putln (toConvert + " : " + dec2bin(toConvert));
		}

	}
	
	public static String dec2bin (int d)
	{
		String result = "";
		if (d==0)
		{
			return "";
		}
		else
		{
			if (d % 2==0)
				return dec2bin (d/2) + "0";
			else
				return dec2bin (d/2) + "1";
		}
	}

}
