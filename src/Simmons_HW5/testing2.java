package Simmons_HW5;
//you can also use imports, for example:
//import java.math.*;

public class testing2 {
	public static void main(String[] args){
		for (int i = 1; i<=100;i++)
		{
			if (i%3==0&&i%5==0)System.out.println("FuzzBizz");
			else if (i%5==0)System.out.println("Buzz");
			else if (i%3 == 0)System.out.println("Fizz");
			else{ System.out.println(i);}
		}//end for
		}//end method meat
}//end class testing