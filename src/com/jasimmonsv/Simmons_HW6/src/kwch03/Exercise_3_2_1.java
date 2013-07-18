package kwch03;

import java.util.Stack;
import java.util.Scanner;

public class Exercise_3_2_1
{

	/* <exercise chapter="3" section="2" type="programming" number="1"> */
	public static String reverseWords(String sentence)
	{
		String[] words = sentence.split("\\s+");
		Stack<String> stack = new Stack<String>();
		for (String word : words)
		{
			stack.push(word);
		}
		StringBuilder stb = new StringBuilder();
		while (!stack.empty())
		{
			stb.append(stack.pop());
			if (!stack.empty())
			{
				stb.append(" ");
			}
		}
		return stb.toString();
	}

	/* </exercise> */

	public static void main(String[] args)
	{
		String line = null;
		Scanner in = new Scanner(System.in);
		while (true)
		{
			System.out.println("Enter line to be reversed");
			if (in.hasNextLine())
			{
				line = in.nextLine();
				System.out.println(reverseWords(line));
			}
			else
			{
				break;
			}
		}
	}
}
