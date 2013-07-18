package kwch03;

import java.util.Scanner;

public class TestInfixToPostfixParensExp
{

	public static void main(String[] args)
	{

		InfixToPostfixParensExp evaluator = new InfixToPostfixParensExp();

		String line;
		Scanner in = new Scanner(System.in);
		do
		{

			System.out.println("Enter an infix expression to evaluate");
			if (in.hasNextLine())
			{
				line = in.nextLine();
				try
				{
					String result = evaluator.convert(line);
					System.out.println("Value is " + result);
				} catch (InfixToPostfixParensExp.SyntaxErrorException ex)
				{
					System.out.println("Syntax error " + ex.getMessage());
				}
			}
			else
			{
				break;
			}
		} while (true);
	}
}
