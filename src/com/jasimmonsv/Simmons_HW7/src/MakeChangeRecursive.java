import java.util.ArrayList;

public class MakeChangeRecursive
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		// ArrayList<Change> allWays = waysToMakeChange(47, new Change(-1, -1,
		// -1, -1));

		printWaysToMakeChange2(47, 25, 0, 0, 0, 0); // new Change(-1, -1, -1, -1));

	}

	public static void printWaysToMakeChange(int amount, Change soFar)
	{
		if (amount == 0)
		{
			TextIO.putln(soFar.toString());
		}
		else
		{
			if (soFar.getNumQuarters() == -1) // may we include quarters?
			{
				// yes, so try 0, 1, 2, ... quarters, as long as n*25 < amount

				Change newSoFar = new Change(soFar); // clone it...

				for (int numQuarters = 0; 25 * numQuarters <= amount; numQuarters++)
				{
					newSoFar.add1Quarters();

					printWaysToMakeChange(amount - 25 * numQuarters, newSoFar);
				}
			}
			else if (soFar.getNumDimes() == -1) // may we include dimes?
			{
				// yes, so try 0, 1, 2, ... dimes, as long as n*10 < amount

				Change newSoFar = new Change(soFar); // clone it...

				for (int numDimes = 0; 10 * numDimes <= amount; numDimes++)
				{
					newSoFar.add1Dimes();

					printWaysToMakeChange(amount - 10 * numDimes, newSoFar);
				}
			}
			else if (soFar.getNumNickels() == -1) // may we include nickels?
			{
				// yes, so try 0, 1, 2, ... nickels, as long as n*5 < amount

				Change newSoFar = new Change(soFar); // clone it...

				for (int numNickels = 0; 5 * numNickels <= amount; numNickels++)
				{
					newSoFar.add1Nickels();

					printWaysToMakeChange(amount - 5 * numNickels, newSoFar);
				}
			}
			else if (soFar.getNumPennies() == -1) // may we include pennies?
			{
				// yes, so try 0, 1, 2, ... pennies, as long as n*1 < amount

				Change newSoFar = new Change(soFar); // clone it...

				for (int numPennies = 0; 1 * numPennies <= amount; numPennies++)
				{
					newSoFar.add1Pennies();

					printWaysToMakeChange(amount - 1 * numPennies, newSoFar);
				}
			}
		}
	}

	public static void printWaysToMakeChange2(int amount, 
											  int startWithValue, 
											  int qSoFar,
											  int dSoFar, 
											  int nSoFar, 
											  int pSoFar)
	{
		if (amount == 0)
		{
			TextIO.putln(qSoFar + " quarters, " + dSoFar + " dimes, " + nSoFar + " nickels, "
					+ pSoFar + " pennies.");
		}
		else
		{
			switch (startWithValue)
			{
			case 25:
				if (amount >= 25)
					printWaysToMakeChange2(amount - 25, 25, qSoFar + 1, dSoFar, nSoFar, pSoFar);
				
				printWaysToMakeChange2(amount, 10, qSoFar, dSoFar, nSoFar, pSoFar);

				break;
			case 10:
				if (amount >= 10)
					printWaysToMakeChange2(amount - 10, 10, qSoFar, dSoFar + 1, nSoFar, pSoFar);
				
				printWaysToMakeChange2(amount, 5, qSoFar, dSoFar, nSoFar, pSoFar);

				break;
			case 5:
				if (amount >= 5)
					printWaysToMakeChange2(amount - 5, 5, qSoFar, dSoFar, nSoFar+1, pSoFar);
				
				printWaysToMakeChange2(amount, 1, qSoFar, dSoFar, nSoFar, pSoFar);

				break;
			case 1:
				printWaysToMakeChange2(amount - 1, 1, qSoFar, dSoFar, nSoFar, pSoFar+1);
				// printWaysToMakeChange2(amount, 10, qSoFar, dSoFar, nSoFar, pSoFar);

			default:
				break;
			}
		}

	}

	public static ArrayList<Change> waysToMakeChange(int amount, Change soFar)
	{
		ArrayList<Change> toReturn = new ArrayList<Change>();

		if (amount == 0)
		{
			toReturn.add(soFar);
		}
		else
		{
			if (amount >= 25) // another quarter in change
			{
				Change newSoFar = new Change(soFar);
				newSoFar.add1Quarters();

				toReturn = waysToMakeChange(amount - 25, newSoFar);
			}

			if (amount >= 10) // another dime in change
			{
				Change newSoFar = new Change(soFar);
				newSoFar.add1Dimes();

				toReturn.addAll(waysToMakeChange(amount - 10, newSoFar));
			}

			if (amount >= 5) // another nickel in change
			{
				Change newSoFar = new Change(soFar);
				newSoFar.add1Nickels();

				toReturn.addAll(waysToMakeChange(amount - 5, newSoFar));

			}

			if (amount >= 1) // another penny in change
			{
				Change newSoFar = new Change(soFar);
				newSoFar.add1Pennies();

				toReturn.addAll(waysToMakeChange(amount - 1, newSoFar));

			}
		}

		return toReturn;
	}

}

class Change
{
	private int numQuarters;
	private int numDimes;
	private int numNickels;
	private int numPennies;

	public Change(int q, int d, int n, int p)
	{
		numQuarters = q;
		numDimes = d;
		numNickels = n;
		numPennies = p;
	}

	public Change(Change startWith)
	{
		numQuarters = startWith.getNumQuarters();
		numDimes = startWith.getNumDimes();
		numNickels = startWith.getNumNickels();
		numPennies = startWith.getNumPennies();
	}

	public int getNumQuarters()
	{
		return numQuarters;
	}

	public int getNumDimes()
	{
		return numDimes;
	}

	public int getNumNickels()
	{
		return numNickels;
	}

	public int getNumPennies()
	{
		return numPennies;
	}

	public void add1Quarters()
	{
		numQuarters++;
	}

	public void add1Dimes()
	{
		numDimes++;
	}

	public void add1Nickels()
	{
		numNickels++;
	}

	public void add1Pennies()
	{
		numPennies++;
	}

	public String toString()
	{
		return getNumQuarters() + " quarters, " + getNumDimes() + " dimes, " + getNumNickels()
				+ " nickels, " + getNumPennies() + " pennies.";
	}

}
