import java.util.ArrayList;


public class TestArrayList2 {

	public static void main(String[] args){
		
		String[] sShort = new String[] {"Red","White","Blue"};
		
		for (int index=0; index < sShort.length; index++){
			TextIO.putln(sShort[index]);
		}
		for (String str:sShort)
			TextIO.putln(str);
		
		TextIO.putln(sShort);//sShort.toString()

		ArrayList<String> aList1 = new ArrayList();
		aList1.add("Red");
		aList1.add("White");
		aList1.add("Blue");
	
		
		for (int index=0; index<aList1.size(); index++)
		{
			TextIO.putln(aList1.get(index));
		}
	
		for (String s:aList1)
		{
			TextIO.putln(s);
		}
		
		TextIO.putln(aList1.toString());
	
	}//end main method
}//end class
