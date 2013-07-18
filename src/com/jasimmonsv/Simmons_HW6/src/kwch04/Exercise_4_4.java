package kwch04;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Exercise_4_4
{

	public static void main(String[] args)
	{

		/* <exercise chapter="4" section="4" type="programming" number="1"> */
		Pattern isNumeric = Pattern.compile("[+-]?(\\d+(\\.\\d*)?([eE][+-]?\\d+)?)|"
				+ "(\\.\\d+([eE][+-]?\\d+)?)");

		Deque<String> deque = new ArrayDeque<String>();

		int numNumeric = 0;
		int numOther = 0;
		Scanner in = new Scanner(System.in);
		String token;

		while (in.hasNext())
		{
			token = in.next();

			Matcher m = isNumeric.matcher(token);

			if (m.matches())
			{
				deque.addLast(token);
				numNumeric++;
			}
			else
			{
				deque.addFirst(token);
				numOther++;
			}
		}
		/* </exercise> */

		/* <exercise chapter="4" section="4" type="programming" number="2"> */

		Iterator<String> itr = deque.iterator();

		System.out.println("Strings that are not numeric");

		int i = 0;

		while (i < numOther && itr.hasNext())
		{
			System.out.println(itr.next());
			i++;
		}

		System.out.println("Strings that are numbers");

		while (itr.hasNext())
		{
			System.out.println(itr.next());
		}
		/* </exercise> */
	}
}
